import java.util.ArrayList;

public class Moteur {
	private BaseDeFaits BF;
	private BaseDeRegles BR;
	private Fait F;
	
	public Moteur(BaseDeFaits BF, BaseDeRegles BR, Fait F) {
		this.BF = BF;
		this.BR = BR;
		this.F = F;
	}
	
	/**
	 * permet d'appliquer le chainage avant sur une base de connaisance (base de règles et base de faits)
	 * @return boolean
	 */
	public boolean chainage_avant() {
		Regle regle_applicable;
		
		while(!appartient_a_la_base_de_fait(this.F,this.BF) && regle_applicable(this.BR,this.BF)!=null) {
			regle_applicable = regle_applicable(this.BR,this.BF);
			desactivation_regle(regle_applicable,this.BR);
			ajout_de_la_conclusion(regle_applicable,this.BF);
		}
		
		return (appartient_a_la_base_de_fait(this.F,this.BF));
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
			if(BF.getFaits().get(i).equals(F))
				return true;
		}
		
		return false;
	}
	
	/**
	 * permet de supprimer la règle trouvée lors du chainage avant de la base de regle
	 * @param r
	 * @param BR
	 */
	public void desactivation_regle(Regle r,BaseDeRegles BR) {
		if(non_doublons_de_la_base_de_fait(BF)) {
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
}
