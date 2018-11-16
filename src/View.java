import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JFrame{
	
	private JPanel panelRegles;
	private BaseDeRegles br;
	
	public void setBaseDeRegles(BaseDeRegles br) {
		this.br = br;
	}
	
	public void afficher() {
		this.setTitle("SYSTEME EXPERT");
		this.setSize(800, 380);
		//this.setResizable(false);
		this.setLayout(new GridLayout(0,3));
	
		this.panelRegles = new ViewRegles(this.br);
		
		this.add(this.panelRegles);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
}
