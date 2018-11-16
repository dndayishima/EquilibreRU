import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ViewRegles extends JPanel{
	
	public ViewRegles(BaseDeRegles br) {

		this.setLayout(new BorderLayout());
		
		JLabel titre = new JLabel("REGLES (" + br.getRegles().size() + ")");
		titre.setBorder(new EmptyBorder(10,0,0,0));
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel regles = new JLabel(this.lectureRegles(br));
		regles.setBorder(new EmptyBorder(0,10,0,0));//top,left,bottom,right //utilisé pour le padding
		regles.setVerticalAlignment(JLabel.TOP);
		
		this.add(titre, BorderLayout.NORTH);
		this.add(regles, BorderLayout.CENTER);
		
		this.setBackground(Color.white);
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
}
