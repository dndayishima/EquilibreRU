
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
	
<<<<<<< HEAD
	public void setNom(String nom) {
		this.nom = nom;
	}
	
=======
>>>>>>> chainage_arriere
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	public void afficheFait() {
		System.out.println("FAIT -> " + this.nom + " = " + this.valeur);
	}
	
<<<<<<< HEAD
	public boolean equals(Fait fait) {
		return (this.nom.equals(fait.getNom()) && this.valeur.equals(fait.getValeur()));
=======
	// tester si this est égal au fait f
	public boolean equals(Fait f) {
		return (this.nom.equals(f.getNom()) && this.valeur.equals(f.getValeur()));
>>>>>>> chainage_arriere
	}
}
