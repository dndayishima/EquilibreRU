import java.util.ArrayList;


public class Moteur2 {
	private BaseDeFaits bf;
	private BaseDeRegles br;
	private Fait but;
	
	public Moteur2(BaseDeFaits bf, BaseDeRegles br, Fait but) {
		this.bf = bf;
		this.br = br;
		this.but = but;
	}
	
	public boolean chainageArriere(BaseDeFaits bf, BaseDeRegles br, Fait but) {

		ArrayList<Regle> ER = new ArrayList<Regle>();
		
		if (bf.includes(but)) {
			System.out.println("Le but est dans la base de faits");
			return true;
		} else {
			Conclusion ccl = new Conclusion();
			ccl.setNom(but.getNom());
			ccl.setValeur(but.getValeur());
			ER = br.hasConclusion(ccl);
			Moteur2.displayReglesNum(ER);
		}
		if (ER.size() == 0) {
			System.out.println("vide");
			return false;
		}
		boolean valide = false;
		while (!valide && ER.size() != 0) {
			System.out.println("while");
			valide = true;
			Regle r = this.getFirstRegle(ER); // 1er element de ER
			ER = this.removeRegle(ER, r.getNumero());
			for (Condition c : r.getConditions()) {
				Fait f2 = new Fait();
				f2.setNom(c.getNom());
				f2.setValeur(c.getValeur());
				valide = valide && this.chainageArriere(bf, br, f2);
			}
		}
			
		if (valide) {
			BaseDeFaits newBf = bf;
			newBf.union(but);
			this.bf.setFaits(newBf);
		}
		return valide;
		
	}
	
	
	public ArrayList<Regle> removeRegle(ArrayList<Regle> regles, int numero) {
		ArrayList<Regle> resultat = new ArrayList<Regle>();
		for (Regle r : regles) {
			if (r.getNumero() != numero) {
				resultat.add(r);
			}
		}
		return resultat;
	}
	
	public Regle getFirstRegle(ArrayList<Regle> regles) {
		if (regles.size() > 0) {
			return regles.get(0);
		}
		return null;
	}
	
	public static void displayReglesNum(ArrayList<Regle> regles) {
		for (Regle r : regles) {
			System.out.print(r.getNumero() + ", ");
		}
		System.out.println("");
	}
}
