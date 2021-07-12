package daten;

import java.io.Serializable;

/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:40
 */
public class Dozent extends Person implements Serializable{
	private static final long serialVersionUID = 604265497334992621L;
	private String fachgebiet;
	private int persNr;

	public Dozent(){

	}
	
	public Dozent( String name, String vorname,String fachgebiet) {
		super(name, vorname);
		this.fachgebiet = fachgebiet;
		this.persNr = this.getId();
	}
	
	public String toString() {
		return this.getVorname() + " " + this.getName() + "\nFachgebiet : " + this.fachgebiet + "\nPNr : " + this.persNr;
	}
	
	public int getPersNr() {
		return this.persNr;
	}
	public String getFachgebiet (){
		return this.fachgebiet;
	}
	public void setFachgebiet(String fachgebiet){
		this.fachgebiet = fachgebiet;
	}
}