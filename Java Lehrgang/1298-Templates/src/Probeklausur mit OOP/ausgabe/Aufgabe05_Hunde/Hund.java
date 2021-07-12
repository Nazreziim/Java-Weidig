Name:
Dienstgrad:

public class Hund{
	private int kundenNummer;
	private int steuerNummer;
	private String rasse;
	private char geschlecht;
	private int geburtsjahr;
	private boolean isKastriert;
	
	/*
		Platz für die Konstruktoren
	*/
	
	
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
	
	/*
		viel Platz fuer die von Ihnen zu erstellenden Methoden "impfungFaellig" und
		"isKreuzbarMit"
	*/
	
	
	
	
}
