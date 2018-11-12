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
 * Cette classe crée la base de règles à partir d'un fichier XML 
 */
public class BaseDeRegles {
	private ArrayList<Regle> regles;
	
	public BaseDeRegles(String filename) {
		File xmlFile = new File(filename);
		Document xmlDoc = this.getDocument(xmlFile);
		//System.out.println("racine : " + xmlDoc.getDocumentElement().getNodeName());
		NodeList regles = xmlDoc.getElementsByTagName("regle");
		//System.out.println("Nb regles : " + regles.getLength());
		
		ArrayList<Regle> r = new ArrayList<Regle>();
		
		for (int i = 0; i < regles.getLength(); i++) {
			ArrayList<Condition> c = new ArrayList<Condition>();
			Conclusion ccl = new Conclusion();
			
			Node noeud = (Node) regles.item(i);
			Element regle = (Element) noeud;
			int numRegle = Integer.parseInt(regle.getAttribute("numero"));
			//System.out.println(numRegle);
			
			// On trouve les conditions
			NodeList conditions = regle.getElementsByTagName("condition");
			for (int j = 0; j < conditions.getLength(); j++) {
				String nomCondition, valCondition;
				Node noeudCond = (Node) conditions.item(j);
				Element condition = (Element) noeudCond;
				
				// Chaque condition doit avoir un seul attribut
				NamedNodeMap attrs = condition.getAttributes();
				if (attrs.getLength() > 1) {
					System.out.println("Une condition doit avoir un seul attribut ! ");
					return;
				} else {
					Attr attribut = (Attr) attrs.item(0);
					nomCondition = attribut.getName();
					valCondition = attribut.getValue();
					Condition cond = new Condition();
					cond.setNom(nomCondition);
					cond.setValeur(valCondition);
					//Condition cond = new Condition(nomCondition, valCondition);
					c.add(cond);
				}
			}
			
			// on trouve la conclusion
			// Une seule conclusion
			NodeList conclusions = regle.getElementsByTagName("conclusion");
			if (conclusions.getLength() > 1) {
				System.out.println("Une règle doit avoir une seule conclusion");
				return;
			} else {
				String nomConclusion, valConclusion;
				Node noeudCcl = (Node) conclusions.item(0);
				NamedNodeMap attrs = noeudCcl.getAttributes();
				if (attrs.getLength() > 1) {
					System.out.println("Une conclusion a un seul attribut");
					return;
				} else {
					Attr attribut = (Attr) attrs.item(0);
					nomConclusion = attribut.getName();
					valConclusion = attribut.getValue();
					ccl.setNom(nomConclusion);
					ccl.setValeur(valConclusion);
				}
			}
			
			Regle rgl = new Regle(numRegle, c, ccl);
			r.add(rgl);
		}
		
		this.regles = r;
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
	
	public ArrayList<Regle> getRegles() {
		return this.regles;
	}
	
	// construire ER ensemble de règles R, telle que F appartient conclusion(R)
	public ArrayList<Regle> hasConclusion(Conclusion ccl) {
		ArrayList<Regle> resultat = new ArrayList<Regle>();
		for (int i = 0 ; i < this.regles.size() ; i++) {
			if (this.regles.get(i).getConclusion().equals(ccl)) {
				resultat.add(this.regles.get(i));
			}
		}
		return resultat;
	}
	
	// enlever une règle de numéro "numero"
	public ArrayList<Regle> removeRegle(int numero) {
		ArrayList<Regle> resultat = new ArrayList<Regle>();
		for (Regle r : regles) {
			if (r.getNumero() != numero) {
				resultat.add(r);
			}
		}
		return resultat;
	}

}
