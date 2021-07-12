package daten;

import java.io.Serializable;

/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:35
 */
public class Teilnehmer extends Person implements Serializable {
	private static final long serialVersionUID = -5685778184554886740L;
	private Adresse adresse;

	public Teilnehmer(){

	}

	public Teilnehmer(String name, String vorname, Adresse adr) {
		super(name, vorname);
		this.adresse = adr;
	}
	
	public Teilnehmer(String name, String vorname) {
		super(name, vorname);
	}
	
	/**
	 * Wenn keine Adresse uebergeben wurde, gib nur Vorname und Name aus
	 * Bsp.:
	 * Max Mustermann
	 * 
	 * Wenn eine adresse uebergeben wurde gib die komplette Anschrift aus
	 * Bsp.:
	 * Max Mustermann
	 * Musterstraße 1
	 * 12345 Musterstadt
	 */
	public String toString() {
		if(this.adresse == null) {
			return this.getVorname() + " " + this.getName();
		} 
		else {
			return this.getVorname() +" " + this.getName() + "\n"  + this.adresse;
		}
	}
	
	public void setAdresse(Adresse adr) {
		this.adresse = adr;
	}
	
	public Adresse getAdresse(){
		return this.adresse;
	}
}