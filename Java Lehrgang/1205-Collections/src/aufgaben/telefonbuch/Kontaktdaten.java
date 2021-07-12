package aufgaben.telefonbuch;

public class Kontaktdaten {
	int telNr;
	String adresse;

	public Kontaktdaten(int telNr, String adresse) {
		this.telNr = telNr;
		this.adresse = adresse;

	}

	@Override
	public String toString() {
		return " Kontaktdaten: telNr=" + telNr + ", adresse=" + adresse;
	}
}
