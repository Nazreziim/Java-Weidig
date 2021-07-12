package schulverwaltung;

/**
 * Die Klasse verwaltet die allgemeine Daten zu einer Person
 * @author user
 *
 */
public class Adresse {
	
	private String nachname;
	private String vorname;
	private String strasse;
	private String ort;
	private int    hausnr;
	private int    plz;
	
	/**
	 * Konstruktor
	 * @param nachname
	 * @param vorname
	 * @param strasse
	 * @param hausnr
	 * @param plz
	 * @param ort
	 */
	public Adresse(String nachname, String vorname, String strasse, int hausnr, int plz, String ort) {
		super();
		this.nachname = nachname;
		this.vorname = vorname;
		this.strasse = strasse;
		this.hausnr  = hausnr;
		this.plz     = plz;
		this.ort     = ort;
	}
	
	/**
	 * Gibt den Nachnamen zurueck.
	 * @return
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * Gibt den Vornamen zurueck.
	 * @return
	 */
	public String getVorname() {
		return vorname;
	}


	@Override
	public String toString() {
		
		return String.format("%10s %10s %15s %3d %5d %s", vorname, nachname, strasse, hausnr, plz, ort);
	}
	
}
