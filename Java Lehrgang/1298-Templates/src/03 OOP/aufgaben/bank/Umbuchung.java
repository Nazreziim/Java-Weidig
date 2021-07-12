package aufgaben.bank;

public class Umbuchung extends Thread {
	
	private Konto konto1;
	private Konto konto2;
	private double betrag;
	
	public Umbuchung(Konto konto1, Konto konto2, int betrag) {
		this.konto1 = konto1;
		this.konto2 = konto2;
		this.betrag = betrag;
	}
	
	public void run() {
		Abbuchung a = new Abbuchung(konto1, betrag);
		Zubuchung z = new Zubuchung(konto2, betrag);
		a.start();
		try {
			a.join();
		}
		catch (InterruptedException e) {
		}
		z.start();
	}
}

