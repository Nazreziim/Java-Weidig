package restesammlung;

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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	public boolean equals(Object p) {
		return this.getName().equals(((Person) p).getName());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
