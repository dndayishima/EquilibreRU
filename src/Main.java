public class Main {
	public static void main(String args[]) {
		
		BaseDeRegles baseRegles = new BaseDeRegles("./base_de_connaissance/regles1.xml");
		BaseDeFaits faits = new BaseDeFaits("./base_de_connaissance/faits1.xml");
		
		Fait but = new Fait();
		but.setNom("repas");
		but.setValeur("true");
		
		Moteur moteur = new Moteur(faits, baseRegles, but);
		
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
