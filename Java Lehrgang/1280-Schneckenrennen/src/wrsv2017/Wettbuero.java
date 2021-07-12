package wrsv2017;

public class Wettbuero {

	private Rennen rennen;
	private Wette[] wetten;
	private double faktor;

	public Wettbuero(Rennen rennen, int anzahlWetten, double faktor) {
		this.rennen = rennen;
		this.wetten = new Wette[anzahlWetten];
		this.faktor = faktor;
	}

	public void wetteAnnehmen(String schneckenName, double wettEinsatz,
			String spieler) {
		boolean pos = wettEinsatz > 0.0;
		boolean done = false;
		for (int i = 0; pos && !done && i < wetten.length; ++i) {
			if (this.wetten[i] == null) {
				this.wetten[i] = new Wette(schneckenName, wettEinsatz, spieler);
				done = true;
			}
		}
	}

	public void rennenDurchfuehren() {
		this.rennen.durchfuehren();
	}

	@Override
	public String toString() {
		String result = "Wettbuero für Rennen \"" + this.rennen.getName()
				+ "\"\n";
		result += rennen.toString();
		result += "Wetten:\n";
		for (int i = 0; i < this.wetten.length; ++i) {
			if (this.wetten[i] != null) {
				result += "" + (i + 1) + ". " + this.wetten[i].toString()
						+ "\n";
			}
		}
		return result;
	}

}
