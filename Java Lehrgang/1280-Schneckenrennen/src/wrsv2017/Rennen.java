package wrsv2017;

public class Rennen {
	private String name;
	private int anzahlSchnecken;
	private Rennschnecke[] schnecken;
	private double streckenLaenge;

	public Rennen(String name, int anzahlSchnecken, double streckenLaenge) {
		this.name = name;
		this.anzahlSchnecken = anzahlSchnecken;
		this.streckenLaenge = streckenLaenge;
		this.schnecken = new Rennschnecke[this.anzahlSchnecken];
	}

	void addRennschnecke(Rennschnecke neueSchnecke) {
		boolean done = false;
		boolean schonVorhanden = false;
		for (int i = 0; !schonVorhanden && i < this.schnecken.length; ++i) {
			if (this.schnecken[i] != null
					&& this.schnecken[i].equals(neueSchnecke)) {
				schonVorhanden = true;
			}
		}

		for (int i = 0; !schonVorhanden && !done
				&& i < this.schnecken.length; ++i) {
			if (this.schnecken[i] == null) {
				this.schnecken[i] = neueSchnecke;
				done = true;
			}
		}
	}

	void removeRennschnecke(String name) {
		boolean done = false;
		for (int i = 0; !done && i < this.schnecken.length; ++i) {
			if (this.schnecken[i].getName().equals(name)) {
				this.schnecken[i] = null;
				done = true;
			}
		}
	}

	@Override
	public String toString() {
		String result = String.format("Rennen: %s%n%12s: %.2f%n%12s:%n",
				this.name, "Distanz", this.streckenLaenge, "Teilnehmer");
		for (int i = 0; i < this.schnecken.length; ++i) {
			if (this.schnecken[i] != null) {
				result += "Schnecke " + (i + 1) + ":\n";
				result += this.schnecken[i].toString();
				result += "\n-----\n";
			}
		}
		if (this.ermittleGewinner() != null) {
			result += "Gewinner: " + this.ermittleGewinner().getName()
					+ "\n-----\n";
		}
		return result;
	}

	public Rennschnecke ermittleGewinner() {
		Rennschnecke gewinner = null;
		boolean done = false;
		for (int i = 0; i < this.schnecken.length; ++i) {
			if (this.schnecken[i] != null
					&& this.schnecken[i].getWeg() > this.streckenLaenge) {
				if (gewinner == null
						|| gewinner.getWeg() < this.schnecken[i].getWeg()) {
					gewinner = this.schnecken[i];
				}
			}
		}
		return gewinner;
	}

	public void lasseSchneckenKriechen() {
		for (int i = 0; i < this.schnecken.length; ++i) {
			if (this.schnecken[i] != null) {
				this.schnecken[i].krieche();
			}
		}
	}

	public void durchfuehren() {
		while (this.ermittleGewinner() == null) {
			this.lasseSchneckenKriechen();
		}
	}

	public String getName() {
		return this.name;
	}
}
