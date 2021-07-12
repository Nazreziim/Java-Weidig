package schulverwaltung;

/**
 * Diese Klasse erstellt eine Verweis
 * zur Benachrichtigung.
 * @author user
 *
 */
public class Verweis extends Elternbrief {

	private String grund;
	
	/**
	 * Konstruktor
	 * @param jahrgangsstufe
	 * @param grund
	 */
	public Verweis(int jahrgangsstufe, String grund ) {
		super(jahrgangsstufe);
		this.grund = grund;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nVerweis: " + this.grund + "!";
	}
}
