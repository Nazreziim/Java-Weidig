package setTest;

public class Person implements Comparable<Person>{
	private String vName;
	private String nName;
	private int persNr;
	
	public Person(String vName, String nName, int persNr) {
		this.vName = vName;
		this.nName = nName;
		this.persNr = persNr;
	}
	
	public void printPerson() {
		System.out.println(this.persNr + " - " + this.vName + " "+ this.nName);
	}


	
	// automatisch generiert ueber eclipse
	// wird bei HashSet benoetigt
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nName == null) ? 0 : nName.hashCode());
		result = prime * result + persNr;
		result = prime * result + ((vName == null) ? 0 : vName.hashCode());
		return result;
	}
	
	// automatisch generiert ueber eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Person other = (Person) obj;
		
		if (nName == null) {
			if (other.nName != null)
				return false;
		} else if (!nName.equals(other.nName))
			return false;
		if (persNr != other.persNr)
			return false;
		if (vName == null) {
			if (other.vName != null)
				return false;
		} else if (!vName.equals(other.vName))
			return false;
		return true;
	}

	// notwendig fuer die Benutzung in einem TreeSet
	public int compareTo(Person p) {
		if (this.nName.compareTo(p.nName) != 0) {
			return this.nName.compareTo(p.nName);
		} else {
			return this.vName.compareTo(p.vName);
		}
	}
	
	
}
