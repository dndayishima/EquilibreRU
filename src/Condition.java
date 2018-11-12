
public class Condition {
	private String nom, valeur;
	
	public Condition(String nom, String valeur) {
		this.nom = nom;
		this.valeur = valeur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getValeur() {
		return this.valeur;
	}
	
	public void afficheCondition() {
		System.out.println("\tCONDITION " + this.nom + " = " + this.valeur);
	}
	
	public boolean equals(Fait fait) {
		return (this.nom.equals(fait.getNom()) && this.valeur.equals(fait.getValeur()));
	}
}
