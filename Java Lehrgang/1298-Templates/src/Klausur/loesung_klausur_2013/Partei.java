package loesung_klausur_2013;
// Name:
// Dienstgrad:

public class Partei {
	private String ausrichtung ="";
	private String name;
	private int anz_stimmen;
	private int anz_sitze_bundestag = 0;
	
	public Partei (String name) {
		this.name = name;
	}
	
	public Partei(String name, String ausrichtung) {
		this.name = name;
		this.ausrichtung = ausrichtung;
	}


	public String getName() {
		return name;
	}

	public int getAnzSitzeBundestag() {
		return anz_sitze_bundestag;
	}

	public void setAnzSitzeBundestag(int anz_sitze_bundestag) {
		this.anz_sitze_bundestag = anz_sitze_bundestag;
	}
	
	public int getAnzStimmen() {
		return anz_stimmen;
	}

	public void setAnzStimmen(int anz_stimmen) {
		this.anz_stimmen = anz_stimmen;
	}	
	
	public void setAusrichtung(String ausrichtung) {
		this.ausrichtung = ausrichtung;
	}
	


	public Politiker[] sendePolitiker() {
		Politiker[] erg = new Politiker[this.getAnzSitzeBundestag()];
		for (int i=0; i < this.getAnzSitzeBundestag(); i++) {
			erg[i] = new Politiker("Name", 1970, this);			
		}
		
		return erg;
		
	}





}
