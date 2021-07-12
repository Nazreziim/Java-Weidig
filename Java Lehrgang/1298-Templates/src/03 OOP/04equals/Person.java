package equals;

public class Person {
	private String name;
	private int alter;
	private int groesse;
	
	public Person(String name, int alter, int groesse) {		
		this.name = name;
		this.alter = alter;
		this.groesse = groesse;
	}

	public String getName() {
		return name;
	}
	
	public boolean equals(Object p) {
		return this.getName().equals( ((Person)p).getName() );
	}
}
