
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
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	public void afficheFait() {
		System.out.println("FAIT -> " + this.nom + " = " + this.valeur);
	}
	
	public boolean equals(Fait fait) {
		return (this.nom.equals(fait.getNom()) && this.valeur.equals(fait.getValeur()));
	}
}
