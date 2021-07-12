package schulverwaltung;

/**
 * Die Klasse erstellt einen Hinweis
 * als Benachrichtigung
 * @author user
 *
 */
public class Hinweis extends Elternbrief {

	private String hinweis;
	
	/**
	 * Konstruktor
	 * @param jahrgangsstufe
	 * @param hinweis
	 */
	public Hinweis(int jahrgangsstufe, String hinweis){
		super(jahrgangsstufe);
		this.hinweis = hinweis;
	}

	@Override
	public String toString() {
		return super.toString() + "\nHinweis: " + this.hinweis + "!";
	}
	
}
