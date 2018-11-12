public class Main {
	public static void main(String args[]) {
<<<<<<< HEAD
		BaseDeRegles b = new BaseDeRegles("./src/regles1.xml");
		BaseDeFaits faits = new BaseDeFaits("./src/faits1.xml");
		for (Regle r : b.getRegles()) {
			r.afficheRegle();
		}
		System.out.println("==================");
=======
		BaseDeRegles baseRegles = new BaseDeRegles("./src/regles1.xml");
		BaseDeFaits faits = new BaseDeFaits("./src/faits1.xml");
		
		Fait but = new Fait();
		but.setNom("repas");
		but.setValeur("true");
		
		Moteur2 moteur = new Moteur2(faits, baseRegles, but);
>>>>>>> chainage_arriere
		
		if (moteur.chainageArriere(faits, baseRegles, but)) {
			System.out.println("SUCCES");
		} else {
			System.out.println("ECHEC");
		}
		System.out.println("==================");
		
		Fait F = new Fait("repas","true");
		
		F.afficheFait();
		
		Moteur m = new Moteur(faits, b, F);
		
		if(m.chainage_avant())
			System.out.println("\nC'EST OK DE OUFFF POUR LE CHAINAGE AVANT");
		else
			System.out.println("\nPUTAINNN CHAINAGE AVANT");
	}
}
