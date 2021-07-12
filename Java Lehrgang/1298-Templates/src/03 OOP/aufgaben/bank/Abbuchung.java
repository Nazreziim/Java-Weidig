package aufgaben.bank;

public class Abbuchung extends Thread {
	
	private Konto konto;
	private double betrag;
	
	public Abbuchung(Konto konto, double betrag) {
		this.konto = konto;
		this.betrag = betrag;
	}
	
	public void run() {
		Bank.pause();
		//synchronized (konto) {
			double kontoStand = this.konto.getKontoStand();
			double kreditRahmen = this.konto.getKreditRahmen();
			if (kontoStand + kreditRahmen < this.betrag) {
				throw new ArithmeticException("Verfügungsrahmen zu gering");
			}
			else {
				kontoStand = kontoStand - betrag;
			}
			Bank.pause();
			this.konto.setKontoStand(kontoStand);
		//}
	}
	
	
			
}

