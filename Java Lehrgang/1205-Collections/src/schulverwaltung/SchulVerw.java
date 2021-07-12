package schulverwaltung;

import java.util.Arrays;
import java.util.LinkedList;

import schulverwaltung.Personal.Geschlecht;

/**
 * Diese Klasse ist fuer die Schulverwaltung zustaendig.
 * Sie verwaltet alle Personen sowie alle Schuljahre.
 * @author user
 *
 */
public class SchulVerw {
	// Attribute
	LinkedList<SchulklassenVerw> schuljahreVerw;
	private SchulklassenVerw klassenVerw;
	private PersonalVerw personalVerw;
	
	/**
	 * Konstruktor
	 */
	public SchulVerw(){
		schuljahreVerw = new LinkedList<SchulklassenVerw>();
		personalVerw = new PersonalVerw();
	}
	
	/**
	 * Gibt aktuelles Schuljahr als String zurueck.
	 * @return
	 */
	public String gebeAktuellesSchuljahr(){
		return this.klassenVerw.gebeSchuljahr();
	}
	
	/**
	 * Anmeldung aller Personen fuer die Personenverwaltung.
	 * Personen werden automatisch erzeugt. 
	 * @param anzahl   Anzahl der zu erstellenden Personen
	 */
	public void anmeldungPersonal(int anzahl){
	
		final int spanne = SchulklassenVerw.MAX_JAHRGANGSSTUFE - SchulklassenVerw.MIN_JAHRGANGSSTUFE + 1;
		final int offset = SchulklassenVerw.MIN_JAHRGANGSSTUFE;
		
		Geschlecht geschlecht = Geschlecht.MAENNLICH;
		String vorname = null;
		
		for (int nr = 0; nr < anzahl; nr++){
			
			if ( nr % 2 == 0){
				geschlecht = Geschlecht.MAENNLICH;
				vorname = "Max";
			}
			else{
				geschlecht = Geschlecht.WEIBLICH;
				vorname = "Maria";
			}
			
			if ( nr % 7 == 0){
				personalVerw.anmeldenPersonal(new Lehrer(String.format("Maier%03d", nr), 
														 String.format("%s%03d", vorname, nr), 
														 "Bergstrasse ", 
														 nr, 
														 10_000 + nr, 
														 "Berlin",
														 geschlecht));
			}
			else{
				personalVerw.anmeldenPersonal(new Schueler(String.format("Miller%03d", nr), 
														   String.format("%s%03d", vorname, nr), 
															"Am Postberg ",
															nr, 
															80_000 + nr,
															"Muenchen",
															geschlecht,
															(int) (Math.random() * spanne   + offset)));
			}
			
		}
				
	}
	
	/**
	 * Gibt Uebersicht ueber die vorhanden aktiven Schueler und vorhanden Lehrer aus.
	 * Es wird unter den Geschlechtern unterschieden.
	 * @param schuljahr
	 */
	public void ausgabeAnzahlPersonen(String schuljahr){
		String ueberschrift = "Uebersicht Personal: " + schuljahr;
		System.out.println(ueberschrift);
		char[] unterstrich = new char[ueberschrift.length()];
		Arrays.fill(unterstrich, '=');
		System.out.println(unterstrich);
		System.out.println("Anzahl Schueler maennlich: " + personalVerw.anzahlSchueler(Geschlecht.MAENNLICH));
		System.out.println("Anzahl Schueler weiblich:  " + personalVerw.anzahlSchueler(Geschlecht.WEIBLICH));
		System.out.println("Anzahl Lehrer maennlich:   " + personalVerw.anzahlLehrer(Geschlecht.MAENNLICH));
		System.out.println("Anzahl Lehrer weiblich:    " + personalVerw.anzahlLehrer(Geschlecht.WEIBLICH));
	}
	
	/**
	 * Methode erstellt ein neues Schuljahr.
	 * Sie baut eine komplett neue Klassenverwaltung auf.
	 * @param schuljahr
	 */
	public void erstelleNeuesSchuljahr(String schuljahr){
		
		klassenVerw = new SchulklassenVerw(schuljahr);
		
		schuljahreVerw.add(klassenVerw);
		
		ausgabeAnzahlPersonen(schuljahr);
		
		klassenVerw.generiereSchulklassen(personalVerw.gebeSchueler());
		/*
		 * Testausgabe der KlassenVerwaltung
		 */
		// System.out.println(klassenVerw.toString());
	}
	
	/**
	 * Die Methode legt die Klassenlehrer fest und weisst ihnen
	 * eine Klasse zu.
	 * @return
	 */
	public boolean zuteilenLehrerKlasse(){
		Lehrer[] lehrer = personalVerw.gebeLehrer();
		// bestimmen der Klassenlehrer
		int anzahlKlassen = klassenVerw.gebeAnzahlKlassen();
		boolean zuteilenOk = false;
		
		/*
		 * Testausgabe fuer Anzahl Klassen pro Schuljahr
		 */
		System.out.printf("Es sind %02d Klassen in diesem Schuljahr.\n", anzahlKlassen);
		
		if (lehrer.length >= anzahlKlassen){
			
			// Klassenlehrer festlegen
			for (int i = 0; i < anzahlKlassen; i++){
				lehrer[i].setKlassenLehrer(true);
			}
			
			zuteilenOk = klassenVerw.zuteilenLehrerKlasse(personalVerw.gebeLehrer());
		}
		
		/*
		 * Testausgabe der KlassenVerwaltung
		 */
		System.out.println(klassenVerw.toString());
		
		return zuteilenOk;
	}
	
	/**
	 * Methode veranlasst, dass die Klassenlehrer ihre Zeugnisse
	 * fuer ihre Schueler erstellen.
	 */
	public void erstelleZeugnisse(){
		Lehrer[] klassenLehrer = personalVerw.gebeKlassenLehrer();
		
		for (Lehrer lehrer : klassenLehrer){
			lehrer.erstelleZeugnisse();
		}
	}
	
	/**
	 * Methode veranlasst den Schuljahresabschluss und gibt die
	 * Anzahl der bestandenen Schueler dieses Schuljahres zurueck.
	 * Klassenlehrer werden wieder zu normalen Lehrern.
	 * @return
	 */
	public int abschlussSchuljahr(){
		int anzBestSchu = klassenVerw.abschlussSchuljahr();
		personalVerw.abschlussSchuljahr();
		return anzBestSchu;
	}
	
}
