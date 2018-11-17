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


public class FilesChooser extends JPanel{
	
	private final JFileChooser fichierRegles;
	private final JFileChooser fichierFaits;
	
	public FilesChooser() {
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
					File f = fichierRegles.getSelectedFile();
					try {
						// TODO ajouter le comportement sur le choix d'un fichier
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
					File f = fichierFaits.getSelectedFile();
					try {
						// TODO ajouter le comportement sur le choix d'un fichier
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

}
