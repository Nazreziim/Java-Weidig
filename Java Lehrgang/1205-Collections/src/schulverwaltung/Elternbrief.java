package schulverwaltung;
/**
 * Abstrakte Klasse fuer die Benachrichtigung 
 * bei Fehlverhalten eines Schuelers.
 * @author user
 *
 */
public abstract class Elternbrief {
	private int jahrgangsstufe;
	
	/**
	 * Konstruktor
	 * @param jahrgangsstufe
	 */
	public Elternbrief(int jahrgangsstufe){
		this.jahrgangsstufe = jahrgangsstufe;
	}

	/**
	 * Gebe Jahrgangsstufe zurueck.
	 * @return
	 */
	public int getJahrgangsstufe() {
		return jahrgangsstufe;
	}

	@Override
	public String toString() {
		
		return "Jahrgangsstufe: " + jahrgangsstufe;
	}

}
