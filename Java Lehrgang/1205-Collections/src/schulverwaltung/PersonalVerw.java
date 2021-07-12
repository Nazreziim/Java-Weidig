package schulverwaltung;

import java.util.LinkedList;

import schulverwaltung.Personal.Geschlecht;
/**
 * In dieser Klasse wird das gesamte Personal der Schule verwaltet.
 * Es verbleiben auch die Schueler, die ihre Schulzeit schon beendet
 * haben.
 * @author user
 *
 */
public class PersonalVerw {
		
	private LinkedList<Personal> personenVerw;
	
	/**
	 * Konstruktor
	 */
	public PersonalVerw(){
			
		this.personenVerw = new LinkedList<Personal>();
	}
	
	/**
	 * Anmeldung aller Personen 
	 * @param person
	 */
	public boolean anmeldenPersonal( Personal person ){
		boolean meldungOk = false;
		int jahrgangsStufe = 0;
		if ( person != null) {
			if ( person instanceof Schueler ){
				jahrgangsStufe = ((Schueler) person).getJahrgangstufe();
				
				if (jahrgangsStufe >= SchulklassenVerw.MIN_JAHRGANGSSTUFE &&
					jahrgangsStufe <= SchulklassenVerw.MAX_JAHRGANGSSTUFE ){
					meldungOk = true;
				}
				
			}
			else{
				meldungOk = true;
			}
		}
			
		if (meldungOk){
			personenVerw.add(person);
		}
		else{
			System.out.println("Anmeldung fehlgeschlagen! (JahrgangsStufe?)"  + jahrgangsStufe );
		}
		
		return meldungOk;
	}
	
	/**
	 * Gibt die Anzahl aller aktiven Schueler der Schule zurueck.
	 * @return
	 */
	public int anzahlSchueler(){
		int erg = 0;
		for (Personal person : personenVerw){
			if (person instanceof Schueler && !((Schueler) person).isSchulzeitBeendet()){
				erg++;
			}
		}
		
		return erg;
	}
	
	/**
	 *  Gibt die Anzahl aller aktiven Schueler eines Geschlechts der Schule zurueck.
	 * @param geschlecht
	 * @return
	 */
	public int anzahlSchueler(Geschlecht geschlecht){
		int erg = 0;

		for (Personal person : personenVerw){
			if (person instanceof Schueler && 
				!((Schueler) person).isSchulzeitBeendet() && 
				person.getGeschlecht() == geschlecht){
				erg++;
			}
		}
		
		return erg;
	}
	
	/**
	 * Gibt alle aktiven Schueler der Schule zurueck.
	 * @return
	 */
	public Schueler[] gebeSchueler(){
		Schueler[] schueler = new Schueler[anzahlSchueler()];
		int idx = 0;
		
		for (Personal person : personenVerw){
			if ( person instanceof Schueler && !((Schueler) person).isSchulzeitBeendet()){
				schueler[idx] = (Schueler) person;
				idx++;
			}
		}
		return schueler;
	}
	
	/**
	 * Sucht einen Schueler in der Personalverwaltung und gibt diesen zurueck.
	 * @param vorname
	 * @param nachname
	 * @return
	 */
	public Schueler gebeSchueler(String vorname, String nachname){
		Schueler schueler = null;
		boolean gefunden = false;
		int idx =0;
		
		while (idx < personenVerw.size() && !gefunden){
			if (personenVerw.get(idx) instanceof Schueler){
				if (personenVerw.get(idx).isPerson(vorname, nachname)){
					gefunden = true;
					schueler = (Schueler) personenVerw.get(idx);
				}
			}
		    idx++;
		}
		
		return schueler;
	}
	
	/**
	 * Ermittelt die Anzahl der Lehrer in der Schulverwaltung
	 * @return
	 */
	public int anzahlLehrer(){
		int erg = 0;
		for (Personal person : personenVerw){
			if (person instanceof Lehrer){
				erg++;
			}
		}
		return erg;
	}
	
	/**
	 * Ermittelt die Anzahl der Lehrer eines Geschlechts in der Schulverwaltung
	 * @param geschlecht
	 * @return
	 */
	public int anzahlLehrer(Geschlecht geschlecht){
		int erg = 0;
		for (Personal person : personenVerw){
			if (person instanceof Lehrer && person.getGeschlecht() == geschlecht){
				erg++;
			}
		}
		return erg;
	}
	
	/**
	 * Gibt die Lehrer der Schulverwaltung zurueck.
	 * @return
	 */
	public Lehrer[] gebeLehrer(){
		Lehrer[] lehrer = new Lehrer[anzahlLehrer()];
		int idx = 0;
		
		for (Personal person : personenVerw){
			if ( person instanceof Lehrer){
				lehrer[idx] = (Lehrer) person;
				idx++;
			}
		}
		return lehrer;
	}

	/**
	 * Ermittelt die Anzahl der Klassenlehrer des aktuellen Schuljahres 
	 * der Schulverwaltung.
	 * @return
	 */
	public int anzahlKlassenLehrer(){
		int erg = 0;
		for (Personal person : personenVerw){
			if (person instanceof Lehrer &&  ((Lehrer) person).isKlassenLehrer()) {
				erg++;
			}
		}
		return erg;
	}
	
	/**
	 * Gibt die Lehrer der Schulverwaltung zurueck.
	 * @return
	 */
	public Lehrer[] gebeKlassenLehrer(){
		Lehrer[] lehrer = new Lehrer[anzahlKlassenLehrer()];
		int idx = 0;
		
		for (Personal person : this.personenVerw){
			if ( person instanceof Lehrer &&  ((Lehrer) person).isKlassenLehrer()){
				lehrer[idx] = (Lehrer) person;
				idx++;
			}
		}
		return lehrer;
	}

	/**
	 * Es werden wieder alle Klassenlehrer zu normalen Lehrern und
	 * es erfolgt eine Auswertung wie viele Schueler die Schulzeit
	 * beendet haben und geben diese Anzahl zurueck.
	 * @return
	 */
	public int abschlussSchuljahr() {
		int anzahlSchuelerFertig = 0;
		
		for (Personal person : this.personenVerw){
			
			if ( person instanceof Lehrer &&  ((Lehrer) person).isKlassenLehrer()){
				((Lehrer) person).setKlassenLehrer(false);
				
			}else if ( person instanceof Schueler &&  ((Schueler) person).isSchulzeitBeendet()){
				anzahlSchuelerFertig++;
			}
		}
		
		System.out.printf("Es haben %03d Schueler erfolgreich die gesamte Schulzeit beendet.\n", anzahlSchuelerFertig);
		return anzahlSchuelerFertig;
		
	}
}
