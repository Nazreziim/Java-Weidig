package seminarplaner2012.domain;

public class Dozent extends Person {

	private int persNr;
	private String fachGeb;

	public Dozent(){
		super();
		this.persNr = 0;
		this.fachGeb = "";
	}

	public Dozent(String name, String vorname, String strasse, String hnr, 
								String plz, String stadt, int persNr, String fachGeb){
		super(name,vorname,strasse,hnr,plz,stadt);
		this.persNr = persNr;
		this.fachGeb = fachGeb;
	}
	
	// Methoden
	// get
	public int getPersNr() {
		return persNr;
	}

	public String getFachGeb() {
		return fachGeb;
	}
	
	// set
	public void setPersNr(int persNr) {
		this.persNr = persNr;
	}

	public void setFachGeb(String fachGeb) {
		this.fachGeb = fachGeb;
	}
}