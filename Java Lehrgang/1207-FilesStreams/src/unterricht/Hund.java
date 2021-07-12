package unterricht;

import java.io.Serializable;
/*
 * Möchte ich den Hund mit Teil der Serialisierung machen muss dieser Serializable sein
 */
public class Hund implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977431349419804703L;
	private String name;
	private int alter;
	
	
	public Hund(String name, int alter) {
		super();
		this.name = name;
		this.alter = alter;
	}
	
	
	@Override
	public String toString() {
		return "Hund [name=" + name + ", alter=" + alter + "]";
	}
	
}
