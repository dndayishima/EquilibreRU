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
}
