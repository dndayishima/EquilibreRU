import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * représente la vue de la base de faits
 */

public class ViewFaits extends JPanel {
	private JLabel titre, faits;
	
	public ViewFaits(BaseDeFaits bf) {
	
		this.setLayout(new BorderLayout());
		
		titre = new JLabel("Faits (" + bf.getFaits().size() + ")");
		titre.setBorder(new EmptyBorder(10,0,0,0));
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		faits = new JLabel(this.lectureFaits(bf));
		faits.setBorder(new EmptyBorder(0,10,0,0));//top,left,bottom,right //utilisé pour le padding
		faits.setVerticalAlignment(JLabel.TOP);
		
		this.add(titre, BorderLayout.NORTH);
		this.add(faits, BorderLayout.CENTER);
		
		this.setBackground(Color.white);
		//this.setBorder(new EmptyBorder(10,5,10,10));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public String lectureFaits(BaseDeFaits bf) {
		ArrayList<Fait> faits = bf.getFaits();
		String result = "";
		if (faits.size() == 0) {
			result = "<html>LA BASE DE FAITS EST VIDE</html>";
		} else {
			result += "<html> <br/>";
			int i = 1;
			
			for (Fait fait : faits) {
				result += "Fait n°" + i++;
				result += "<br/><blockquote>" + fait.getNom() + " = " + fait.getValeur() + "</blockquote><br/><br/>";
			}
		}
		
		return result;
	}
	
	public void update(BaseDeFaits bf) {
		titre.setText("FAITS (" + bf.getFaits().size() + ")");
		faits.setText(this.lectureFaits(bf));
	}
}