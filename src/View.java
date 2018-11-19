import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class View extends JFrame{
	
	private JPanel panelRegles;
	private JPanel panelFaits;
	private JPanel panelNewFait;
	private JPanel panelFilesChooser;
	private JPanel panelNewBut;
	private JPanel panelResultat;
	
	private BaseDeRegles br;
	private BaseDeFaits bf;
	
	public void setBaseDeRegles(BaseDeRegles br) {
		this.br = br;
	}
	
	public void setBaseDeFaits(BaseDeFaits bf) {
		this.bf = bf;
	}
	
	public void afficher() {
		this.setTitle("SYSTEME EXPERT");
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
		
		this.setLayout(new BorderLayout());
		
		JPanel contenuTextuel = new JPanel();
		contenuTextuel.setLayout(new GridLayout(0,2));
		this.panelRegles = new ViewRegles(this.br);
		contenuTextuel.add(this.panelRegles);
		
		this.panelFaits = new ViewFaits();
		contenuTextuel.add(this.panelFaits);
		
		JPanel options = new JPanel();
		options.setLayout(new GridLayout(4,0));
		
		this.panelNewFait = new NewFait();
		this.panelFilesChooser = new FilesChooser();
		this.panelNewBut = new NewBut(this);
		this.panelResultat = new Resultat(this);
		options.add(this.panelNewFait);
		options.add(this.panelFilesChooser);
		options.add(this.panelNewBut);
		options.add(this.panelResultat);
		
		this.add(contenuTextuel, BorderLayout.CENTER);
		this.add(options, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
}
