package unterricht;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 6689867301834606727L;
	
	private String name;
	private String vorname;
	private int nr;
	public static int zaehler = 0;
	private transient Hund hund;
	
	public Person(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.nr = zaehler++;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Hund getHund() {
		return hund;
	}
	
	public void setHund(Hund hund) {
		this.hund = hund;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", vorname=" + vorname + ", nr= " + nr + ", zaehler=" + zaehler + "]\n"
				+ hund;
	}
	
	public void geheSpazieren() {
		System.out.println(vorname + " geht spazieren.");
	}

	
	
	
	
}
