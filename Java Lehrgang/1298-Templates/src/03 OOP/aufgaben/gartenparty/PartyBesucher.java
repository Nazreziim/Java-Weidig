package aufgaben.gartenparty;

public class PartyBesucher {
	private String name;
	private char geschlecht;
	private int anzahl_bier;
	private double getr_alkohol;
	
	public PartyBesucher(String name, char geschlecht) {
		super();
		this.name = name;
		this.geschlecht = geschlecht;
		this.anzahl_bier = 0;
		this.getr_alkohol = 0;
	}



	
	// Ein Mann verträgt ca. 40 gr Alkohol, eine Frau 35 gr
	// gr = ml * (Vol% / 100) * 0.8
	public void trinkeBier(double alkohol) {
		this.anzahl_bier++;
		if (geschlecht == 'M' || geschlecht == 'm') {
			this.getr_alkohol += 500 * (alkohol / 100) * 0.8;
		}
		if (geschlecht == 'W' || geschlecht == 'w') {
			this.getr_alkohol += 500 * (alkohol / 100) * 0.8;
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

	public int getAnzahlBier() {
		return anzahl_bier;
	}


	public double getGetrAlkohol() {
		return getr_alkohol;
	}




	@Override
	public String toString() {
		return "PartyBesucher [name=" + name + ", geschlecht=" + geschlecht
				+ ", anzahl_bier=" + anzahl_bier + ", getr_alkohol="
				+ getr_alkohol + "]";
	}
	
	

	
	
	
	

}
