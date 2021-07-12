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


	public int compareTo(Person p) {
		if (this.nName.compareTo(p.nName) != 0) {
			return this.nName.compareTo(p.nName);
		} else {
			return this.vName.compareTo(p.vName);
		}
	}
	
	
}
