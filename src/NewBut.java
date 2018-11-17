import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class NewBut extends JPanel {
	
	private View view;
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
	}
}
