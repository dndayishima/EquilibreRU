
public class Fait {
	private String nom, valeur;
	
	public Fait() {
		this.nom = "";
		this.valeur = "";
	}
	
	public Fait(String nom, String valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getValeur() {
		return this.valeur;
	}
	
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	public void afficheFait() {
		System.out.println("FAIT -> " + this.nom + " = " + this.valeur);
	}
	
	// tester si this est égal au fait f
	public boolean equals(Fait f) {
		return (this.nom.equals(f.getNom()) && this.valeur.equals(f.getValeur()));
	}
}
