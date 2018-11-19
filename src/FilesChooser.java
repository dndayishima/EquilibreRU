import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * représente un JPanel permettant de choisir un fichier
 */

public class FilesChooser extends JPanel{
	
	private final JFileChooser fichierRegles;
	private final JFileChooser fichierFaits;
	private View view;
	
	public FilesChooser(View view) {
		this.view = view;
		this.setLayout(new GridLayout(0,2));
		
		//JFileChooser fichierRegles = new JFileChooser();
		//JFileChooser fichierFaits = new JFileChooser();
		
		FileFilter filter = new FileNameExtensionFilter("Fichier xml", "xml");
		File directory = new File("./base_de_connaissance");
		
		fichierRegles = new JFileChooser(directory);
		fichierFaits = new JFileChooser(directory);
		fichierRegles.setAcceptAllFileFilterUsed(false);
		fichierFaits.setAcceptAllFileFilterUsed(false);
		fichierRegles.addChoosableFileFilter(filter);
		fichierFaits.addChoosableFileFilter(filter);
		
		JButton boutonChooseRegles = new JButton("FICHIER REGLES");
		JButton boutonChooseFaits = new JButton("FICHIER FAITS");
		
		boutonChooseRegles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evenement) {
				int returnVal = fichierRegles.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String f = fichierRegles.getSelectedFile().getAbsolutePath();
					try {
						// TODO ajouter le comportement sur le choix d'un fichier
						chargerFichierRegle(f);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		boutonChooseFaits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evenement) {
				int returnVal = fichierFaits.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String f = fichierFaits.getSelectedFile().getAbsolutePath();
					try {
						// TODO ajouter le comportement sur le choix d'un fichier
						chargerFichierFait(f);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		this.add(boutonChooseRegles);
		this.add(boutonChooseFaits);
		
		this.setBorder(new EmptyBorder(5,0,0,0));
	}
	
	// Méthode permettant de charger mes fichiers regles
	
	public void chargerFichierRegle(String filename) {
		try {
			BaseDeRegles regles = new BaseDeRegles(filename);
			view.setBaseDeRegles(regles);
			view.getViewRegles().update(regles);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Méthode permettant de charger mes fichiers faits
	
		public void chargerFichierFait(String filename) {
			try {
				BaseDeFaits faits = new BaseDeFaits(filename);
				view.setBaseDeFaits(faits);
				view.getViewFaits().update(faits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
