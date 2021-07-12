package unterricht;

public class Hund {
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
