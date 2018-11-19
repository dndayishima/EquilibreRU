import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * représente la vue de la base de règles
 */

public class ViewRegles extends JPanel{
	private JLabel titre, regles;
	
	public ViewRegles(BaseDeRegles br) {		
		this.setLayout(new BorderLayout());
		
		titre = new JLabel("REGLES (" + br.getRegles().size() + ")");
		titre.setBorder(new EmptyBorder(10,0,0,0));
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		regles = new JLabel(this.lectureRegles(br));
		regles.setBorder(new EmptyBorder(0,10,0,0));//top,left,bottom,right //utilisé pour le padding
		regles.setVerticalAlignment(JLabel.TOP);
		
		this.add(titre, BorderLayout.NORTH);
		this.add(regles, BorderLayout.CENTER);
		
		this.setBackground(Color.white);
		//this.setBorder(new EmptyBorder(10,10,10,5));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public String lectureRegles(BaseDeRegles br) {
		ArrayList<Regle> regles = br.getRegles();
		String result = "";
		if (regles.size() == 0) {
			result = "<html>LA BASE DE REGLES EST VIDE</html>";
		} else {
			result += "<html> <br/>";
			for (Regle regle : regles) {
				result += "REGLE n°" + regle.getNumero() + "<br />";
				result += "SI <br/>";
				for (Condition condition : regle.getConditions()) {
					String c = "- - " + condition.getNom() + " = " + condition.getValeur() + "<br/>";
					result += c;
				}
				result += "ALORS <br/>";
				String ccl = "- - " + regle.getConclusion().getNom() + " = " + regle.getConclusion().getValeur() + "<br /><br />";
				result += ccl;
			}
		}
		return result;
	}
	
	public void update(BaseDeRegles br) {
		titre.setText("REGLES (" + br.getRegles().size() + ")");
		regles.setText(this.lectureRegles(br));
	}
}
