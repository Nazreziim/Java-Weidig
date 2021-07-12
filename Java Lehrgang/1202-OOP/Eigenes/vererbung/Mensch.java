package vererbung;



public class Mensch {
	private int alter;
	private String name;

	public Mensch() {
		alter = 5;
		name = "Bernd";
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public String getName() {
		return name;
	}

	public final void setName(String name) {
		System.out.println("Klasse: MENSCH");
		this.name = name;
	}

}
