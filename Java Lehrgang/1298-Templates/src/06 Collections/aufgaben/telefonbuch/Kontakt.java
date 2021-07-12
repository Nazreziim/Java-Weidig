package aufgaben.telefonbuch;

public class Kontakt {
	private String vorname;
	private String nachname;
	private String telNr;
	private String str;
	private String hNr;
	
Kontakt() {
	vorname="";
	nachname="";
	telNr="";
	str="";
	hNr="";
}

public Kontakt(String vorname, String nachname, String telNr, String str,
		String hNr) {
	super();
	this.vorname = vorname;
	this.nachname = nachname;
	this.telNr = telNr;
	this.str = str;
	this.hNr = hNr;
}



}
