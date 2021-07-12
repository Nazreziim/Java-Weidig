package loesung_klausur_2013;
// Name:
// Dienstgrad:
public class Minister extends Politiker {
	String resort;
	int imAmtSeit;

	public Minister(String name, int gebjahr, String resort, Partei partei) {
		super(name, gebjahr, partei);
		this.resort = resort;
	}

	public void setImAmtSeit(int imAmtSeit) {
		this.imAmtSeit = imAmtSeit;
	}
	

	public double getGehalt() {
		return super.getGehalt() + (super.akt_jahr - imAmtSeit) * 1200;
	}
	
	public String toString() {
		return super.toString() + "Ich bin Minister im Resort " + resort;
	}
	
	
	
}
