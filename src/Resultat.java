import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Resultat extends JPanel {
	
	private View view;
	private JLabel resultat;
	
	public Resultat(View view) {
		this.view = view;
		this.setBackground(Color.white);
		
		resultat = new JLabel("RESULTAT DU CHAINAGE     SUCCES/ECHEC");
		resultat.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(resultat);
	}
	
	public void setSuccess(String typeChainage) {
		resultat.setText(typeChainage + "  SUCCES !");
		this.setBackground(Color.green);
	}
	
	public void setEchec(String typeChainage) {
		resultat.setText(typeChainage + "  SUCCES !");
		this.setBackground(Color.orange);
	}
	
	public void reset() {
		resultat.setText("RESULTAT DU CHAINAGE     SUCCES/ECHEC");
		this.setBackground(Color.white);
	}
	
}
