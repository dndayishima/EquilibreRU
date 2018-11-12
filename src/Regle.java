import java.util.ArrayList;


public class Regle {
	
	private int numero;
	private ArrayList<Condition> conditions;
	private Conclusion conclusion;
	
	public Regle(int numero, ArrayList<Condition> conditions, Conclusion conclusion) {
		this.numero = numero;
		this.conditions = conditions;
		this.conclusion = conclusion;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public ArrayList<Condition> getConditions() {
		return this.conditions;
	}
	
	public Conclusion getConclusion() {
		return this.conclusion;
	}
	
	public void afficheRegle() {
		System.out.println("SI");
		for (Condition c : this.conditions) {
			c.afficheCondition();
		}
		System.out.println("ALORS");
		conclusion.afficheConclusion();
	}
	
	public ArrayList<Fait> conditionsToFaits() {
		ArrayList<Fait> resultat = new ArrayList<Fait>();
		for (int i = 0; i < this.conditions.size(); i++) {
			Fait f = new Fait();
			f.setNom(this.conditions.get(i).getNom());
			f.setValeur(this.conditions.get(i).getValeur());
			resultat.add(f);
		}
		return resultat;
	}
	
	// Pour une règle, on vérifie que chaque condition de la prémisse
	// existe dans la base des faits bf
	public boolean premisseExisteDansBF(BaseDeFaits bf) {
		for (int i = 0 ; i < this.conditions.size() ; i++) {
			Fait f = new Fait();
			f.setNom(this.conditions.get(i).getNom());
			f.setValeur(this.conditions.get(i).getValeur());
			if (!bf.includes(f)) {
				return false;
			}
		}
		
		return true;
	}
	
	// Pour une règle, on vérifie que la conclusion
	// existe dans la base de fait bf
	public boolean conclusionExisteDansBF(BaseDeFaits bf) {
		Fait f = new Fait();
		f.setNom(this.conclusion.getNom());
		f.setValeur(this.conclusion.getValeur());
		return (bf.includes(f));
	}
}
