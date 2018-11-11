
public class Conclusion {
	private String nom, valeur;
	
	public Conclusion(String nom, String valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getValeur() {
		return this.valeur;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	public void afficheConclusion() {
		System.out.println("\tCONCLUSION  " + this.nom + " = " + this.valeur);
	}
}
