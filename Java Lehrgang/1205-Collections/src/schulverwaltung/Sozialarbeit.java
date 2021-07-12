package schulverwaltung;

/**
 * Diese KLasse erstellt eine Sozialarbeit
 * zur Benachrichtigung.
 * @author user
 *
 */
public class Sozialarbeit extends Elternbrief {

	private int stunden;
	private Adresse adresse;
	
	/**
	 * Konstruktor
	 * @param jahrgangsstufe
	 * @param stunden
	 * @param adresse
	 */
	public Sozialarbeit(int jahrgangsstufe, int stunden, Adresse adresse) {
		super(jahrgangsstufe);
		this.stunden = stunden;
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nSozialarbeit: " + "Stunden: " + this.stunden + "Adresse: " + this.adresse;
	}
	
}
