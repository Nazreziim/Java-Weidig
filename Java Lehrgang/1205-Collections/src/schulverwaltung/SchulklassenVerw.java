package schulverwaltung;

import java.util.ArrayList;

/**
 * Diese Klasse verwaltet alle Schulklassen eines Schuljahres.
 * @author user
 *
 */
public class SchulklassenVerw {
	
	public final static int MAX_JAHRGANGSSTUFE = 12;
	public final static int MIN_JAHRGANGSSTUFE  = 5;
	public final static char MIN_KLASSE = 'a';
	
	// erste Dimension fuer Jahrgangsstufe 1,2,3 .. 12
	// zweite Dimension fuer Klasse je Jahrgangsstufe a, b, c, d,
	private ArrayList<Schulklasse[]> jahrgangsVerw;
	private String schuljahr;
	
	/**
	 * Konstruktor der Klasse
	 * @param schuljahr	Schuljahr der Klassenvewaltung
	 */
	public SchulklassenVerw(String schuljahr){
		this.jahrgangsVerw = new ArrayList<Schulklasse[]>(MAX_JAHRGANGSSTUFE - MIN_JAHRGANGSSTUFE + 1); 
		this.schuljahr = schuljahr;
	}
	
	
	/**
	 * Gibt das Schuljahr der Klassenvewaltung zurueck.
	 * @return
	 */
	public String gebeSchuljahr(){
		return this.schuljahr;
	}
	
	/**
	 * Gibt die Anzahl der Schueler einer Jahrgangsstufe zurueck.
	 * @param schueler		Alle aktiven Schueler der Schule.
	 * @param jahrgangstufe Jahrgangsstufe
	 * @return
	 */
	private int gebeAnzahlSchueler(Schueler[] schueler, int jahrgangstufe){
		int anzahl = 0;
		for ( Schueler s : schueler){
			if(s.getJahrgangstufe() == jahrgangstufe && !s.isSchulzeitBeendet()){
				anzahl++;
			}
		}
		return anzahl;
	}
	
	/**
	 * Gibt die Schueler einer Jahrgangsstufe zurueck.
	 * @param schueler		Alle aktiven Schueler der Schule
	 * @param jahrgangstufe Jahrgangsstufe
	 * @return
	 */
	private Schueler[] gebeSchueler(Schueler[] schueler, int jahrgangstufe){
		Schueler[] schuelerJahrgang = new Schueler[gebeAnzahlSchueler(schueler, jahrgangstufe)];
		int idx = 0;
		
		for ( Schueler s : schueler){
			if(s.getJahrgangstufe() == jahrgangstufe && !s.isSchulzeitBeendet()){
				schuelerJahrgang[idx] = s;
				idx++;
			}
		}
		
		return schuelerJahrgang;
	}
	
	
	/**
	 * Schueler werden den einzelen Klassen einer Jahrgangsstufe zugewiesen.
	 * @param schulklassen
	 * @param schuelerProJahrgang
	 * @param jahrgangsstufe
	 */
	private void zuteilenSchuelerKlasse(Schulklasse[] schulklassen, 
										Schueler[] schuelerProJahrgang,
										int jahrgangsstufe) {
		
		int idxSchuelerJahrgang = 0;
		int anzahlSchuelerInKlasse = 0;
		int anzKlassen = schulklassen.length;
		int anzSchueler = schuelerProJahrgang.length;
      
		for (int idxKlasse = 0; idxKlasse < schulklassen.length; idxKlasse++){
			
			schulklassen[idxKlasse] = new Schulklasse( jahrgangsstufe, (char) (MIN_KLASSE + idxKlasse));
			
			anzahlSchuelerInKlasse =  anzSchueler / anzKlassen;
			
			if (anzKlassen > 1){
				anzahlSchuelerInKlasse = (anzSchueler % anzKlassen == 0) ? anzahlSchuelerInKlasse : anzahlSchuelerInKlasse + 1;
			}
			
			
			// Schueler einer Schulklasse hinzufuegen		
			for ( int idxSchueler = 0; idxSchueler < anzahlSchuelerInKlasse; idxSchueler++){
				schulklassen[idxKlasse].hinzufuegenSchueler(schuelerProJahrgang[idxSchuelerJahrgang]); 
				idxSchuelerJahrgang++;
			}
			
			anzKlassen--;
			anzSchueler -= anzahlSchuelerInKlasse;
		}
	}
	
	/**
	 * Erzeugt die benötigten Klassen fuer das aktuelle Schuljahr
	 * und weisst die Schueler den Klassen zu.
	 * @param schuelerAlle	Uebergabe aller aktiven Schueler der Schule
	 */
	public void generiereSchulklassen(Schueler[] schuelerAlle){
		
		int jahrgangsstufe = SchulklassenVerw.MIN_JAHRGANGSSTUFE;
		int anzahlJahrgange = MAX_JAHRGANGSSTUFE - MIN_JAHRGANGSSTUFE + 1;
		int anzahlSchueler = 0;
		int anzahlKlassen = 0;
		Schueler[] schuelerProJahrgang = null;
		
		for ( int jahrgang = 0; jahrgang < anzahlJahrgange; jahrgang++){   //von Index 0 beginnend
			
			anzahlSchueler = gebeAnzahlSchueler(schuelerAlle, jahrgangsstufe); 
			schuelerProJahrgang = gebeSchueler(schuelerAlle, jahrgangsstufe);
			
			/*
			 * Testausgabe
			 */
			System.out.printf("%02d Schueler im Jahrgang %2d\n", anzahlSchueler, jahrgangsstufe );
			
			// Anzahl Klasse pro Jahrgangstufe bestimmen
			anzahlKlassen = anzahlSchueler / Schulklasse.MAX_GROESSE;
			anzahlKlassen = (anzahlSchueler % Schulklasse.MAX_GROESSE == 0) ? anzahlKlassen : anzahlKlassen + 1;
			
			this.jahrgangsVerw.add( new Schulklasse[anzahlKlassen] );
			
			zuteilenSchuelerKlasse(this.jahrgangsVerw.get(jahrgang), schuelerProJahrgang, jahrgangsstufe);
			
			jahrgangsstufe++;
		}
		
	}


	/**
	 * Es wird jeder Klasse ein Klassenlehrer zugewiesen.
	 * @param lehrer
	 * @return
	 */
	public boolean zuteilenLehrerKlasse(Lehrer[] lehrer){
		
	    int idxKlasse = 0;
	    int idxJahrgang = 0;
	    int anzahlKlassenMitLehrer = 0;
		for (int i = 0; i < lehrer.length; i++){
			
			if (lehrer[i].isKlassenLehrer()){
				
				if ( (idxJahrgang < jahrgangsVerw.size()) && 
					 (idxKlasse < jahrgangsVerw.get(idxJahrgang).length ) ){
					
					jahrgangsVerw.get(idxJahrgang)[idxKlasse].setKlassenlehrer(lehrer[i]);
					
					lehrer[i].setSchulklasse(jahrgangsVerw.get(idxJahrgang)[idxKlasse]);
					
					anzahlKlassenMitLehrer++;
					
					if ( idxKlasse == jahrgangsVerw.get(idxJahrgang).length -1 ){
					
						idxKlasse = 0;
						idxJahrgang++;
					}
					else{
						idxKlasse++;
					}
				}				
			}
		}
		
		return anzahlKlassenMitLehrer == gebeAnzahlKlassen();
	}
	
	
	/**
	 * Sucht aus der Klassenverwaltung eine bestimmte Schulklasse und 
	 * gibt diese zurueck.
	 * @param jahrgangsstufe         Jahrgangsstufe	
	 * @param klassenName		     Klassenname
	 * @return
	 */
	private Schulklasse gebeSchulklasse(int jahrgangsstufe, char klassenName){
		
		char maxKlasse = '?';
		Schulklasse ergKlasse = null;
		
		if  (jahrgangsstufe >= MIN_JAHRGANGSSTUFE && jahrgangsstufe >= MAX_JAHRGANGSSTUFE){ 
			  
			maxKlasse = (char) ( MIN_KLASSE + jahrgangsVerw.get(jahrgangsstufe - MIN_JAHRGANGSSTUFE).length - 1); 
			
			if ( klassenName >= MIN_KLASSE && klassenName <= maxKlasse){
				ergKlasse = jahrgangsVerw.get(jahrgangsstufe - MIN_JAHRGANGSSTUFE) [klassenName - MIN_KLASSE];
			}
		}
		
		return ergKlasse;
	}
	

	/**
	 * Gibt die Anzahl der Klassen zurueck.
	 * @return
	 */
	public int gebeAnzahlKlassen(){
		int anzahl = 0;

		for ( int jahrgang = 0; jahrgang < jahrgangsVerw.size(); jahrgang++){

			anzahl += jahrgangsVerw.get(jahrgang).length;
		}
		return anzahl;
	}

	/**
	 * Gibt die Anzahl aller bestandenen Schueler eines Schuljahres zurueck.
	 * @return
	 */
	public int abschlussSchuljahr() {
		int anzahlBestanden = 0;
		
		for (Schulklasse[] jahrgang : jahrgangsVerw ){
			
			for (Schulklasse klasse : jahrgang){
				
				for (Schueler schueler : klasse.getSchueler()){
					schueler.abschlussSchuljahr();
				}	
				anzahlBestanden += klasse.anzahlBestandeneSchueler();
			}	
		}
		return anzahlBestanden;
	}

	@Override
	public String toString() {
		String meldung = "Jahrjahr: " + this.schuljahr + "\n";
		for (Schulklasse[] jahrgang : jahrgangsVerw ){
			
			for (Schulklasse klasse : jahrgang){
				
				meldung += klasse.toString() + "\n";
			}	
		}
		
		return meldung;
	}
	
	
}
