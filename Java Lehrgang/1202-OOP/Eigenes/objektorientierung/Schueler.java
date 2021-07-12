package objektorientierung;

public class Schueler {
	private static String name;
	private int alter;
	private int klasse;

	private int iq;
	private int hunger;

	public Schueler(String n, int a, int k) {
		name = n;
		alter = a;
		klasse = k;
	}

	public Schueler(String n, int a) {
		name = n;
		alter = a;
	}

	public Schueler(String n) {
		name = n;
	}

	public Schueler() {
		this("Bernd", 17, 5);
	}

	// GETTER UND SETTER METHODEN
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
