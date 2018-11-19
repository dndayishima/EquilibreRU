import java.util.ArrayList;

/**
 * représente le moteur permettant d'appliquer le chainage avant et arrière
 */

public class Moteur {
	private BaseDeFaits bf;
	private BaseDeRegles br;
	private Fait but;
	private ViewTrace viewTrace;
	
	public Moteur(BaseDeFaits BF, BaseDeRegles BR, Fait F, View v) {
		this.bf = BF;
		this.br = BR;
		this.but = F;
		this.viewTrace = v.getPanelTrace();
		viewTrace.setTrace(new ArrayList<String>());
	}
	
	/**
	 * permet d'appliquer le chainage avant sur une base de connaisance (base de règles et base de faits)
	 * @return boolean
	 */
	public boolean chainage_avant() {
		Regle regle_applicable;
		
		while(!appartient_a_la_base_de_fait(this.but,this.bf) && regle_applicable(this.br,this.bf)!=null) {
			regle_applicable = regle_applicable(this.br,this.bf);
			desactivation_regle(regle_applicable,this.br);
			ajout_de_la_conclusion(regle_applicable,this.bf);
		}
		
		return (appartient_a_la_base_de_fait(this.but,this.bf));
	}
	
	/**
	 * retoune la première regle recontrée correspondant à la base de fait. Cette méthode applique le parcours en profondeurs.
	 * Dès que la première règle est trouvé, on la return
	 * @param BR
	 * @param BF
	 * @return Regle
	 */
	public Regle regle_applicable(BaseDeRegles BR,BaseDeFaits BF) {
		Regle regle;
		
		for(int i = 0; i < BR.getRegles().size(); i++) {
			regle = BR.getRegles().get(i);
			
			if(ensemble_condition_appartient_a_base_de_fait(regle.getConditions(), BF)) {
				viewTrace.addToTrace("Regle " + regle.getNumero() + " applicable");
				return regle; //Dès que la première règle est trouvé, on la return (parcours en profondeur)
			}
		}
		
		return null;
	}
	
	/**
	 * permet de vérifier si un ensemble de condition appartient à une base de fait
	 * @param conditions
	 * @param BF
	 * @return boolean
	 */
	public boolean ensemble_condition_appartient_a_base_de_fait(ArrayList<Condition> conditions, BaseDeFaits BF) {
		boolean trouve = false;
		
		for(int i = 0; i < conditions.size(); i++) {
			if(condition_appartient_a_base_de_fait(conditions.get(i), BF))
				trouve = true;
			else {
				trouve = false;
				break;
			}
		}
		
		return trouve;
	}
	
	/**
	 * permet de vérifier si une condition d'une prémisse appartient à une base de fait
	 * @param condition
	 * @param BF
	 * @return boolean
	 */
	public boolean condition_appartient_a_base_de_fait(Condition condition, BaseDeFaits BF) {
		if(non_doublons_de_la_base_de_fait(BF)) {
			for(int i = 0; i < BF.getFaits().size(); i++) {
				Fait fait = BF.getFaits().get(i);
				
				if(condition.equals(fait))
					return true;
			}
		}
		
		return false;
	}
	
	/**
	 * permet de vérifier si dans la base de fait il n'existe pas de doublon
	 * @param BF
	 * @return boolean
	 */
	public boolean non_doublons_de_la_base_de_fait(BaseDeFaits BF) {
		for(int i = 0; i < BF.getFaits().size()-1; i++) {
			Fait f = BF.getFaits().get(i);
			
			for(int j = i+1; j < BF.getFaits().size(); j++) {
				Fait f_suivant = BF.getFaits().get(j);

				if(f.equals(f_suivant))
					return false;
			}
		}
		
		return true;
	}
	
	/**
	 * permet de vérifier si un fait appartient à une base de fait
	 * @param F
	 * @param BF
	 * @return boolean
	 */
	public boolean appartient_a_la_base_de_fait(Fait F,BaseDeFaits BF) {
		for(int i = 0; i < BF.getFaits().size(); i++) {
			if(BF.getFaits().get(i).equals(F)) {
				viewTrace.addToTrace("Fait \"" + BF.getFaits().get(i).getNom() + " = " + BF.getFaits().get(i).getValeur() + "\" existe dans la BF");
				return true;
			}
		}
		
		viewTrace.addToTrace("Le fait n'existe pas dans la BF");
		return false;
	}
	
	/**
	 * permet de supprimer la règle trouvée lors du chainage avant de la base de regle
	 * @param r
	 * @param BR
	 */
	public void desactivation_regle(Regle r,BaseDeRegles BR) {
		if(non_doublons_de_la_base_de_fait(bf)) {
			for(int i = 0; i < BR.getRegles().size(); i++) {
				Regle rr = BR.getRegles().get(i);
				
				if(rr.getNumero()==r.getNumero())
					BR.getRegles().remove(i);
			}
		}
	}
	
	/**
	 * permet d'ajouter la coclusion de la règle trouvé à la base de fait
	 * @param regle
	 * @param BF
	 */
	public void ajout_de_la_conclusion(Regle regle, BaseDeFaits BF) {
		Fait nouveau_fait = new Fait(regle.getConclusion().getNom(),regle.getConclusion().getValeur());
		
		BF.getFaits().add(nouveau_fait);
	}
	
	public boolean chainageArriere(BaseDeFaits bf, BaseDeRegles br, Fait but) {
		
		ArrayList<Regle> ER = new ArrayList<Regle>();
		
		if (bf.includes(but)) {
			viewTrace.addToTrace("Fait " + but.getNom() + " = " + but.getValeur() + " existe dans BF");
			System.out.println("Le but est dans la base de faits");
			return true;
		} else {
			viewTrace.addToTrace("Fait " + but.getNom() + " = " + but.getValeur() + " n'existe pas dans BF");
			viewTrace.addToTrace("Contruction d'un tableau ER de règles\n" + "ayant comme conclusion " + but.getNom() + " = " + but.getValeur());
			Conclusion ccl = new Conclusion();
			ccl.setNom(but.getNom());
			ccl.setValeur(but.getValeur());
			ER = br.hasConclusion(ccl);
			this.displayReglesNum(ER);
		}
		if (ER.size() == 0) {
			viewTrace.addToTrace("Le tableau ER est vide");
			System.out.println("vide");
			return false;
		}
		boolean valide = false;
		while (!valide && ER.size() != 0) {
			viewTrace.addToTrace("Pas de succès du chaînage arrière\n et ER n'est pas vide !");
			System.out.println("while");
			valide = true;
			Regle r = this.getFirstRegle(ER); // 1er element de ER
			viewTrace.addToTrace("On récupère la 1ère règle dans ER. Règle n°" + r.getNumero() + "\n" + "et on l'enlève de ER");
			ER = this.removeRegle(ER, r.getNumero());
			for (Condition c : r.getConditions()) {
				viewTrace.addToTrace("On refait le chaînage arrière sur\n les conclusions de la Règle n°" + r.getNumero());
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
	
	public void displayReglesNum(ArrayList<Regle> regles) {
		viewTrace.addToTrace("Tableau ER contient les règles : ");
		String str = "";
		for (Regle r : regles) {
			str = str + " " + r.getNumero();
			System.out.print(r.getNumero() + ", ");
		}
		viewTrace.addToTrace(str);
		System.out.println("");
	}
	
	public ViewTrace getViewTrace() {
		return this.viewTrace;
	}
}
