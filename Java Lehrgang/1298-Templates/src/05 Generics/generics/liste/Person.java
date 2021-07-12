/**
 * 
 */
package generics.liste;



/**
 * Dies ist eine Klasse fuer Personen
 * @author LGerhard
 * 
 *
 */
public class Person implements Comparable<Person> {
	
	private String name;
	private int groesse;
	
	/**
	 * Das ist der Konstruktor
	 * @param name Der Name der Person als String
	 * @param groesse Die Körpergröße der Person
	 */
	public Person(String name, int groesse) {
		this.setName(name);
		this.setGroesse(groesse);		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the groesse
	 */
	public int getGroesse() {
		return groesse;
	}

	/**
	 * @param groesse the groesse to set
	 */
	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}
	
	public String toString() {
		
		return "Ich heisse "  + this.name + " und bin " + this.groesse + " gross.";		
	}

	
	/*public int compareTo(Person arg0) {
		int erg;
				
		if (this.groesse > arg0.groesse) {
			erg = 1;
		} else if (this.groesse == arg0.groesse) {
			erg = 0;
		} else {
			erg = -1;
		}
		return erg;
	}*/
	
	
	


	@Override
	public int compareTo(Person arg0) {
		int erg;
		if (this.groesse > arg0.groesse) {
			erg = 1;
		} else if (this.groesse == arg0.groesse) {
			erg = 0;
		} else {
			erg = -1;
		}
		return erg;
	} 
	

}
