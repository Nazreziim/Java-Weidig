package schulverwaltung;

/**
 * Klasse verwaltet die Personendaten.
 * @author user
 *
 */
public abstract class Personal {
	
	enum Geschlecht {WEIBLICH, MAENNLICH};
	private Adresse adresse;
	private  Geschlecht geschlecht; 
	// Geburtsdatum
	
	/**
	 * Konstruktor
	 * @param nachname
	 * @param vorname
	 * @param strasse
	 * @param hausnr
	 * @param plz
	 * @param ort
	 * @param geschlecht
	 */
	Personal(String nachname, String vorname, String strasse, int hausnr, int plz, String ort, Geschlecht geschlecht){
		this.adresse = new Adresse(nachname, vorname, strasse, hausnr, plz, ort);
		this.geschlecht = geschlecht;
	}

	
	/**
	 * Gibt das Geschlecht der Person zurueck.
	 * @return
	 */
	public Geschlecht getGeschlecht() {
		return geschlecht;
	}

	/**
	 * Gibt den Vor- und Nachnamen einer Person zurueck.
	 * @return
	 */
	public String getName(){
		return String.format("%10s %s ", this.adresse.getVorname(), this.adresse.getNachname() );
	}
	
	/**
	 * Prueft. ob es sich um eine bestimmt Person handelt. 
	 * @param vorname
	 * @param nachname
	 * @return
	 */
	public boolean isPerson(String vorname, String nachname){
		return this.adresse.getVorname().equals(vorname) && this.adresse.getNachname().equals(nachname);
	}

	@Override
	public String toString() {
		
		return adresse.toString();
	}

	
}
