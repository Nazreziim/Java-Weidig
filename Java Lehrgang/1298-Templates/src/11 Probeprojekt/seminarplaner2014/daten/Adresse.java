package daten;

import java.io.Serializable;

/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:38
 */
public class Adresse implements Serializable{
	private static final long serialVersionUID = -1586148158958726118L;
	private String strasse;
	private String hausnummer;
	private String plz;
	private String ort;

	public Adresse(){

	}
	
	public Adresse(String strasse, String hausnummer, String plz, String ort) {
		super();
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
	}
	
	public String getStrasse() {
		return this.strasse;
	}
	
	public String getHausnummer() {
		return this.hausnummer;
	}
	
	public String getPlz() {
		return this.plz;
	}
	
	public String getOrt() {
		return this.ort;
	}

	/**
	 * Gibt eine Adresse im üblichen Format wieder
	 * Bsp:
	 * 	Tutzinger Straße 46
	 * 	82340 Feldafing
	 */
	public String toString() {
		return this.strasse + " " + this.hausnummer + "\n" + this.plz + " " + this.ort;
	}
}