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


public class BaseDeFaits {
	private ArrayList<Fait> faits;
	
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
				Fait ff = new Fait(nomFait, valFait);
				f.add(ff);
			}
		}
		
		this.faits = f;
	}
	
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
	
	public ArrayList<Fait> getFaits() {
		return this.faits;
	}
}
