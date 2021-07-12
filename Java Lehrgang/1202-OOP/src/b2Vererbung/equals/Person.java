package b2Vererbung.equals;

public class Person {
	private String name;
	private int alter;
	private int groesseCm;

	public Person(String name, int alter, int groesseCm) {
		this.name = name;
		this.alter = alter;
		this.groesseCm = groesseCm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public int getGroesseCm() {
		return groesseCm;
	}

	public void setGroesseCm(int groesseCm) {
		this.groesseCm = groesseCm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alter;
		result = prime * result + groesseCm;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}

