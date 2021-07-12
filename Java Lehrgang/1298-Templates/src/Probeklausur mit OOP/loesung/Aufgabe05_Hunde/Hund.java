package loesung.Aufgabe05_Hunde;
//Name:
//Dienstgrad:

public class Hund{
	private int kundenNummer;
	private int steuerNummer;
	private String rasse;
	private char geschlecht;
	private int geburtsjahr;
	private boolean isKastriert;
	

	
	public Hund(int kdNr, int stNr, String rasse, char geschl, int gebJahr) {
		this.kundenNummer = kdNr;
		this.steuerNummer = stNr;
		this.rasse = rasse;
		this.geschlecht = geschl;
		this.geburtsjahr = gebJahr;
	}

	public Hund(int kdNr, int stNr) {
		this.kundenNummer = kdNr;
		this.steuerNummer = stNr;
	}

	public int getKundenNummer(){
		return this.kundenNummer;
	}
	
	public int getSteuerNummer(){
		return this.steuerNummer;
	}
	
	public String getRasse(){
		return this.rasse;
	}
	
	public char getGeschlecht(){
		return this.geschlecht;
	}
	
	public int getGeburtsjahr(){
		return this.geburtsjahr;
	}
	
	
	public boolean getIsKastriert(){
		return this.isKastriert;
	}
	
	
	public void setKundenNummer(int kundenNummer){
		this.kundenNummer=kundenNummer;
	}
	
	public void setSteuerNummer(int steuerNummer){
		this.steuerNummer=steuerNummer;
	}
	
	public void setRasse(String rasse){
		this.rasse=rasse;
	}
	
	public void setGeschlecht(char geschlecht){
		this.geschlecht=geschlecht;
	}
	
	public void setGeburtsjahr(int geburtsjahr){
		this.geburtsjahr=geburtsjahr;
	}
	
	public void setIsKastriert(boolean isKastriert){
		this.isKastriert=isKastriert;
	}

	
	
	public boolean impfungFaellig(int jahr) {
		
		return (jahr - this.getGeburtsjahr() == 2) || // zweites Lebensjahr
		((jahr - this.getGeburtsjahr() - 2) % 5 == 0); // danach jedes fünfte
	}
	
	public boolean isKreuzbarMit(Hund h) {
		return !this.isKastriert && !h.isKastriert &&  // beide Hunde nicht kastriert
			3 >= Math.abs(this.getGeburtsjahr() - h.getGeburtsjahr()) && // Altersunterschied höchstens 3 Jahre 
			this.getGeschlecht() != h.getGeschlecht(); // Geschlecht unterschiedlich
	}


	
	
	
	
}
