package schulverwaltung;

import java.util.LinkedList;

/**
 * Klasse verwaltet die Daten eines Schuelers.
 * -- Aktuelle Jahrgangsstufe
 * -- Zeugnis und Benachrichtigungen sowie
 * -- ob die Schulzeit schon beendet ist.
 * @author user
 *
 */
public class Schueler extends Personal {
	

	private int jahrgangsstufe; // 
	private Zeugnis zeugnis;
	private LinkedList<Elternbrief> benachrichtigung;
	private boolean schulzeitBeendet;
	
		
	/**
	 * Konstruktor
	 * @param nachname
	 * @param vorname
	 * @param strasse
	 * @param hausnr
	 * @param plz
	 * @param ort
	 * @param geschlecht
	 * @param jahrgangsstufe
	 */
	public Schueler(String nachname, String vorname, String strasse, int hausnr, int plz, String ort, Geschlecht geschlecht, int jahrgangsstufe) {
		super(nachname, vorname, strasse, hausnr, plz, ort, geschlecht);
		this.jahrgangsstufe = jahrgangsstufe;
		this.benachrichtigung = new LinkedList<Elternbrief>();
		this.schulzeitBeendet = false;
	}

	/**
	 * Gibt die aktuelle Jahrgangsstufe des Schuelers zurueck.
	 * @return
	 */
	public int getJahrgangstufe() {
		return jahrgangsstufe;
	}
	
	/**
	 * Gibt zurueck, ob er noch aktiver Schueler ist.
	 * @return
	 */
	public boolean isSchulzeitBeendet() {
		return schulzeitBeendet;
	}
	
	
	/**
	 * Setzt das Zeugnis fuer diesen Schueler
	 * @param zeugnis
	 */
	public void setZeugnis(Zeugnis zeugnis) {
		if (!isSchulzeitBeendet()){
			this.zeugnis = zeugnis;
		}
	}
	
	/**
	 * Gibt Auskunft, ob das aktuelle Schuljahr
	 * bestanden wurde.
	 * @return
	 */
	public boolean isSchuljahrBestanden(){
		return ( this.zeugnis != null) ? this.zeugnis.isBestanden() : false;
	}

	/**
	 * Setzt eine Benachrichtigung fuer einen Schueler
	 * @param benachrichtigung
	 */
	public void setBenachrichtigung(Elternbrief benachrichtigung) {
		if (!isSchulzeitBeendet()){
			this.benachrichtigung.add(benachrichtigung);
		}
	}
	
	/**
	 * Methode ueberprueft, ob Schueler das Schuljahr bestanden hat.
	 * Wenn ja, rueckt der Schueler in die naechste Jahrgangsstufe.
	 *          und bei Bestehen der letzten Jahrgangsstufe wird
	 *          der Schueler als entlassen markiert. 
	 */
	public void abschlussSchuljahr(){
		if ( (this.zeugnis != null) && this.zeugnis.isBestanden()){
			this.jahrgangsstufe++;
		}
		
		if (this.jahrgangsstufe > SchulklassenVerw.MAX_JAHRGANGSSTUFE){
			this.schulzeitBeendet = true;
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + jahrgangsstufe + " " + super.toString();
	}
	
	
}
