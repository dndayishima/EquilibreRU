public class Main {
	public static void main(String args[]) {
		BaseDeRegles b = new BaseDeRegles("./src/regles1.xml");
		BaseDeFaits faits = new BaseDeFaits("./src/faits1.xml");
		for (Regle r : b.getRegles()) {
			r.afficheRegle();
		}
		System.out.println("==================");
		
		System.out.println("BASE DE FAITS");
		for (Fait f : faits.getFaits()) {
			f.afficheFait();
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
