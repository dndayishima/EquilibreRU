
public class Fait {
	private String nom, valeur;
	
	public Fait(String nom, String valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getValeur() {
		return this.valeur;
	}
	
	public void afficheFait() {
		System.out.println("FAIT -> " + this.nom + " = " + this.valeur);
	}
}
