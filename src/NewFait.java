import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class NewFait extends JPanel {

	public NewFait() {
		this.setLayout(new GridLayout(0,4));
		
		JLabel titre = new JLabel("Ajouter un fait");
		titre.setHorizontalAlignment(JLabel.CENTER);
		JTextField textFieldNom = new JTextField("Nom");
		JTextField textFieldValeur = new JTextField("Valeur");
		JButton ajouter = new JButton("AJOUTER");
		
		this.add(titre);
		this.add(textFieldNom);
		this.add(textFieldValeur);
		this.add(ajouter);
		
		this.setBorder(new EmptyBorder(5,0,0,0));
	}
}
