
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Cette classe permet de représenter une base de fait
 * 
 * @author Divin et Mateanui
 */

public class BaseDeFaits {
	private ArrayList<Fait> faits;
	
	/**
	 * le constructeur nous permet de lire un fichier xml où l'on stock nos faits
	 * @param filename
	 */
	public BaseDeFaits(String filename) {
		File xmlFile = new File(filename);
		Document xmlDoc = this.getDocument(xmlFile);
		
		NodeList faits = xmlDoc.getElementsByTagName("fait");
		
		ArrayList<Fait> f = new ArrayList<Fait>();
		
		for (int i = 0; i < faits.getLength(); i++) {
			String nomFait, valFait;
			Node noeud = (Node) faits.item(i);
			Element fait = (Element) noeud;
			NamedNodeMap attrs = fait.getAttributes();
			if (attrs.getLength() > 1) {
				System.out.println("Un fait doit avoir un seul attribut");
				return;
			} else {
				Attr attribut = (Attr) attrs.item(0);
				nomFait = attribut.getName();
				valFait = attribut.getValue();
				
				Fait ff = new Fait(nomFait,valFait);
				f.add(ff);
			}
		}
		
		this.faits = f;
	}
	
	/**
	 * permet de traduire notre fichier xml en un document
	 * @param xmlFile
	 * @return Document
	 */
	public Document getDocument(File xmlFile) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/* Getteurs et setteurs */
	
	public ArrayList<Fait> getFaits() {
		return this.faits;
	}
}
