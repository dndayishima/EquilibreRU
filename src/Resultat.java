import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * représente le JPanle résultat de la fenetre
 */

public class Resultat extends JPanel {
	
	private View view;
	
	public Resultat(View view) {
		this.view = view;
		this.setBackground(Color.white);
		
		JLabel resultat = new JLabel("RESULTAT DU CHAINAGE     SUCCES/ECHEC");
		resultat.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(resultat);
	}
}
