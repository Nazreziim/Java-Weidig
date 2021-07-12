package wrsv2017;

public class Wette {
	private String spieler;
	private double wettEinsatz;
	private String schnecke;

	public Wette(String schnecke, double wettEinsatz, String spieler) {
		this.schnecke = schnecke;
		this.wettEinsatz = wettEinsatz;
		this.spieler = spieler;
	}

	@Override
	public String toString() {
		return String.format("Wette: \"%s\" setzt %.2f auf \"%s\".",
				this.spieler, this.wettEinsatz, this.schnecke);
	}

	public String getSpieler() {
		return this.spieler;
	}

	public double getWettEinsatz() {
		return this.wettEinsatz;
	}

	public String getRennschnecke() {
		return this.schnecke;
	}
}
