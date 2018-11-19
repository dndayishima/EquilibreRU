import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * représente la vue général de notre application
 */

public class View extends JFrame{
	
	private ViewRegles panelRegles;
	private ViewFaits panelFaits;
	private ViewTrace panelTrace;
	private NewFait panelNewFait;
	private FilesChooser panelFilesChooser;
	private NewBut panelNewBut;
	private Resultat panelResultat;
	
	private BaseDeRegles br;
	private BaseDeFaits bf;
	
	public ViewRegles getViewRegles() {
		return panelRegles;
	}
	
	public ViewFaits getViewFaits() {
		return panelFaits;
	}
	
	public void setBaseDeRegles(BaseDeRegles br) {
		this.br = br;
	}
	
	public void setBaseDeFaits(BaseDeFaits bf) {
		this.bf = bf;
	}
	
	public void afficher() {
		this.setTitle("SYSTEME EXPERT");
		this.setSize(900, 700);
		this.setLocationRelativeTo(null); //positionne la fenetre au centre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //quitte l'application correctement
		//this.setResizable(false);
		
		this.setLayout(new BorderLayout());
		
		JPanel contenuTextuel = new JPanel();
		contenuTextuel.setLayout(new GridLayout(0,3));
		
		this.panelRegles = new ViewRegles(this.br);
		contenuTextuel.add(this.panelRegles);
		
		this.panelFaits = new ViewFaits(this.bf);
		contenuTextuel.add(this.panelFaits);
		
		this.panelTrace = new ViewTrace();
		contenuTextuel.add(this.panelTrace);
		
		JPanel options = new JPanel();
		options.setLayout(new GridLayout(4,0));
		
		this.panelNewFait = new NewFait(this,bf);
		this.panelFilesChooser = new FilesChooser(this);
		this.panelNewBut = new NewBut(this);
		this.panelResultat = new Resultat(this);
		options.add(this.panelNewFait);
		options.add(this.panelFilesChooser);
		options.add(this.panelNewBut);
		options.add(this.panelResultat);
		
		this.add(contenuTextuel, BorderLayout.CENTER);
		this.add(options, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public Resultat getPanelResultat() {
		return this.panelResultat;
	}
	
	public BaseDeRegles getBaseDeRegles() {
		return this.br;
	}
	
	public BaseDeFaits getBaseDeFaits() {
		return this.bf;
	}
	
	public ViewTrace getPanelTrace() {
		return this.panelTrace;
	}
}
