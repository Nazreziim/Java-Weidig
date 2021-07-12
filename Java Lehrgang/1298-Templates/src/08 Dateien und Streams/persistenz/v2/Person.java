package persistenz.v2;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 2868629357105284973L;
	
	private String name;
	private String vorname;
	private transient Hund hund;
	private transient int groesse;
	private int nr;
	public static int zaehler = 0;
	
	public Person(String name, String vorname, int groesse) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.groesse = groesse;
		this.nr = ++zaehler;
	}

	

	public Hund getHund() {
		return hund;
	}
	
	
	/**
	 * @param hund the hund to set
	 */
	public void setHund(Hund hund) {
		this.hund = hund;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", vorname=" + vorname + ", groesse="
				+ groesse + ", nr=" + nr + ", zaehler=" + zaehler + "]";
	}
	

}
