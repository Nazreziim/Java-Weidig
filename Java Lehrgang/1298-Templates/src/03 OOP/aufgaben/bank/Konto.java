package aufgaben.bank;

public class Konto {
	private int kontoNr;
	private double kontoStand;
	private double kreditRahmen;
	
	public Konto(int kontoNr, int anfangskapital) {
		this.kontoNr = kontoNr;
		this.kontoStand = anfangskapital;
		this.kreditRahmen = 0;
	}
	
	public int getKontoNr() {
		return this.kontoNr;
	}
	
	public double getKontoStand() {
		return this.kontoStand;
	}
	
	public void setKontoStand(double betrag) {
		this.kontoStand = betrag;
	}
	
	public double getKreditRahmen() {
		return this.kreditRahmen;
	}

}
