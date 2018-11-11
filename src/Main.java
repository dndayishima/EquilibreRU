
public class Main {
	public static void main(String args[]) {
		BaseDeRegles b = new BaseDeRegles("./src/regles.xml");
		BaseDeFaits faits = new BaseDeFaits("./src/faits.xml");
		for (Regle r : b.getRegles()) {
			r.afficheRegle();
		}
		System.out.println("==================");
		
		System.out.println("BASE DE FAITS");
		for (Fait f : faits.getFaits()) {
			f.afficheFait();
		}
	}
}
