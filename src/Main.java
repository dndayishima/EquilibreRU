
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
	}
}
