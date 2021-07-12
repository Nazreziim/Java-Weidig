package aufgaben.gartenparty;

public class Bierkiste {
	private String marke;
	private double alkohol;
	private int anzahl_flaschen;
	public Bierkiste(String marke, double alkohol, int anzahl_flaschen) {
		super();
		this.marke = marke;
		this.alkohol = alkohol;
		this.anzahl_flaschen = anzahl_flaschen;
	}
	
	@Override
	public String toString() {
		return "Bierkiste [marke=" + marke + ", alkohol=" + alkohol
				+ ", anzahl_flaschen=" + anzahl_flaschen + "]\n";
	}

	public int getAnzahlFlaschen() {
		return anzahl_flaschen;
	}

	public void setAnzahlFlaschen(int anzahl_flaschen) {
		this.anzahl_flaschen = anzahl_flaschen;
	}

	public String getMarke() {
		return marke;
	}

	public double getAlkohol() {
		return alkohol;
	}
	
	

}
