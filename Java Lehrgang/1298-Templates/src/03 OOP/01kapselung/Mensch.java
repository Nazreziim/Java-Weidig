package kapselung;


/**
 * Die Klasse Mensch 
 */
class Mensch {

	private int alter;
	
	private String name;
	
	private char geschlecht;

	public Mensch (String n, char g, int a) {
		this.alter = a;
		this.name = n;
		this.geschlecht = g;
	}
	
	public static void main(String[] args) {
		Mensch m1 = new Mensch("Peter", 'm', 29);
		Mensch m2 = new Mensch("Peter", 'm', 29);
	}
}