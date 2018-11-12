public class Main {
	public static void main(String args[]) {
		
		BaseDeRegles baseRegles = new BaseDeRegles("./src/regles1.xml");
		BaseDeFaits faits = new BaseDeFaits("./src/faits1.xml");
		
		Fait but = new Fait();
		but.setNom("repas");
		but.setValeur("true");
		
		Moteur2 moteur = new Moteur2(faits, baseRegles, but);
		
		if (moteur.chainageArriere(faits, baseRegles, but)) {
			System.out.println("SUCCES");
		} else {
			System.out.println("ECHEC");
		}
		System.out.println("==================");
						
		Moteur m = new Moteur(faits, baseRegles, but);
		
		if(m.chainage_avant())
			System.out.println("\nC'EST OK DE OUFFF POUR LE CHAINAGE AVANT");
		else
			System.out.println("\nPUTAINNN CHAINAGE AVANT");
	}
}
