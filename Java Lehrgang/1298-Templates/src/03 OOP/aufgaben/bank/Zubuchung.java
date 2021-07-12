package aufgaben.bank;

public class Zubuchung extends Thread {
	
	private Konto konto;
	private double betrag;
	
	public Zubuchung(Konto konto, double betrag) {
		this.konto = konto;
		this.betrag = betrag;
	}
	
	public void run() {
		Bank.pause();
		//synchronized (konto) {
			double kontoStand = this.konto.getKontoStand();
			double kreditRahmen = this.konto.getKreditRahmen();
			kontoStand = kontoStand + this.betrag;
			Bank.pause();
			this.konto.setKontoStand(kontoStand);
		//}
	}
}

