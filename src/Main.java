public class Main {
	public static void main(String args[]) {
		
		BaseDeRegles baseRegles = new BaseDeRegles("./base_de_connaissance/regles1.xml");
		BaseDeFaits faits = new BaseDeFaits("./base_de_connaissance/faits1.xml");
		
		// AFFICHAGE
		View v = new View();
		v.setBaseDeRegles(baseRegles);
		v.setBaseDeFaits(faits);
		v.afficher();
		
		// FIN TEST AFFICHAGE
		
		Fait but = new Fait();
		but.setNom("repas");
		but.setValeur("true");
		
	}
}
