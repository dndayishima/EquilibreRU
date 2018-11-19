import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Ajout un fait
 */

public class NewFait extends JPanel {
	private BaseDeFaits bf;
	private JTextField textFieldNom;
	private JTextField textFieldValeur;
	private View view;
	
	public NewFait(View view, final BaseDeFaits bf) {
		this.bf = bf;
		this.view = view;
		
		this.setLayout(new GridLayout(0,4));
		
		JLabel titre = new JLabel("Ajouter un fait");
		titre.setHorizontalAlignment(JLabel.CENTER);
		textFieldNom = new JTextField("Nom");
		textFieldValeur = new JTextField("Valeur");
		JButton ajouter = new JButton("AJOUTER");
		
		this.add(titre);
		this.add(textFieldNom);
		this.add(textFieldValeur);
		this.add(ajouter);
		
		ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ajouterFait(textFieldNom.getText().toString(),textFieldValeur.getText().toString());
			}
		});
		
		this.setBorder(new EmptyBorder(5,0,0,0));
	}
	
	public void ajouterFait(String nom, String valeur) {
		Fait fait = new Fait();
		fait.setNom(nom);
		fait.setValeur(valeur);
		bf.add(fait);
		view.getViewFaits().update(bf);
	}
}
