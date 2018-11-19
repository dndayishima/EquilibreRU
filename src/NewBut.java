import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class NewBut extends JPanel {
	
	private static View view;
	private JTextField nomBut, valeurBut;
	private JButton ch_arriere, ch_avant;
	
	public NewBut(View view) {
		this.view = view;
		this.setLayout(new GridLayout(0,4));
		
		this.nomBut = new JTextField("Nom du but");
		this.valeurBut = new JTextField("Valeur du but");
		this.ch_arriere = new JButton("CH. ARRIERE");
		this.ch_avant = new JButton("CH. AVANT");
				
		this.add(nomBut);
		this.add(valeurBut);
		this.add(ch_arriere);
		this.add(ch_avant);
		
		this.setBorder(new EmptyBorder(5,0,0,0));
		
		this.ch_arriere.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			View v = NewBut.view;
			Resultat r = v.getPanelResultat();
			if (nomBut.getText().equals("") || valeurBut.getText().equals("")) {
				r.reset();
				return;
			} else {
				Fait but = new Fait();
				but.setNom(nomBut.getText());
				but.setValeur(valeurBut.getText());
				boolean resultat = chainage_arriere(v.getBaseDeFaits(), v.getBaseDeRegles(), but);
				if (resultat) {
					r.setSuccess("CHAINAGE ARRIERE");
				} else {
					r.setEchec("CHAINAGE ARRIERE");
				}
			}
		  } 
		});
		
		this.ch_avant.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  View v = NewBut.view;
			  Resultat r = v.getPanelResultat();
			  if (nomBut.getText().equals("") || valeurBut.getText().equals("")) {
				  	r.reset();
					return;
				} else {
					Fait but = new Fait();
					but.setNom(nomBut.getText());
					but.setValeur(valeurBut.getText());
					boolean resultat = chainage_avant(v.getBaseDeFaits(), v.getBaseDeRegles(), but);
					if (resultat) {
						r.setSuccess("CHAINAGE AVANT");
					} else {
						r.setEchec("CHAINAGE AVANT");
					}
				}
		  } 
		});
		
	}
	
	
	public boolean chainage_avant(BaseDeFaits bf, BaseDeRegles br, Fait but) {
		Moteur moteur = new Moteur(bf, br, but);
		return (moteur.chainage_avant());
	}
	
	public boolean chainage_arriere(BaseDeFaits bf, BaseDeRegles br, Fait but) {
		Moteur moteur = new Moteur(bf, br, but);
		return (moteur.chainageArriere(bf, br, but));
	}
}
