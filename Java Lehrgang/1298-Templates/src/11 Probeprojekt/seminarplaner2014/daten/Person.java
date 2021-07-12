package daten;

import java.io.Serializable;

/**
 * @author c-ix-03-11
 * @version 1.0
 * @created 22-Jul-2014 11:56:32
 */
public abstract class Person implements Serializable{
	private static final long serialVersionUID = -7885637751162016823L;
	private static int zaehler = 1;
	private int id;
	private String name;
	private String vorname;

	public Person(){

	}
	
	public Person(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.id = zaehler;
		zaehler++;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getVorname() {
		return this.vorname;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
}