import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class ViewFaits extends JPanel {

	public ViewFaits(/*BaseDeFaits bf*/) {
	
		this.setLayout(new BorderLayout());
		
		JLabel titre = new JLabel("Faits (n)");
		titre.setBorder(new EmptyBorder(10,0,0,0));
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		// ajout des faits ici
		
		this.add(titre, BorderLayout.NORTH);
		//this.add(regles, BorderLayout.CENTER);
		
		this.setBackground(Color.white);
		//this.setBorder(new EmptyBorder(10,5,10,10));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
