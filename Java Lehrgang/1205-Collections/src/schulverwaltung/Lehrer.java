package schulverwaltung;
/**
 * Diese Klasse verwaltet einen Lehrer.
 * Diese beinhaltet auch eine Referenz auf seine
 * Klasse, falls er ein Klassenlehrer ist.
 * @author user
 *
 */
public class Lehrer extends Personal {

	private Schulklasse schulklasse;
	private boolean klassenLehrer;
	
	/**
	 * Konstruktor der Klasse
	 * @param nachname
	 * @param vorname
	 * @param strasse
	 * @param hausnr
	 * @param plz
	 * @param ort
	 * @param geschlecht
	 */
	public Lehrer(String nachname, String vorname, String strasse, int hausnr, int plz, String ort, Geschlecht geschlecht) {
		super(nachname, vorname, strasse, hausnr, plz, ort, geschlecht);
	}
	
	/**
	 * Gibt Auskunft, ob es sich um einen Klassenlehrer handelt.
	 * @return
	 */
	public boolean isKlassenLehrer() {
		return klassenLehrer;
	}


	/**
	 * Setter-Methode  macht einen Lehrer bzw. Klassenlehrer.
	 * @param klassenLehrer
	 */
	public void setKlassenLehrer(boolean klassenLehrer) {
		
		this.klassenLehrer = klassenLehrer;
		
	}

	/**
	 * Setzt die Klasse fuer einen Klassenlehrer
	 * @param klasse
	 */
	public void setSchulklasse(Schulklasse klasse) {
		if (isKlassenLehrer()){
			this.schulklasse = klasse;
		}
	}


	/**
	 * Mehtode erstellt bei einem Klassenlehrer die Zeugnisse fuer
	 * die einzelnen Schueler seiner Klasse.
	 */
	public void erstelleZeugnisse(){
		
		if (isKlassenLehrer()){
			
			System.out.printf("Lehrer: %s erstellt Zeugnisse\n", this.getName());
			

			for ( Schueler s : this.schulklasse.getSchueler() ){
				Zeugnis zeugnis = new Zeugnis((int) (Math.random() * 6.0 + 1.0),  
	                    					  (int) (Math.random() * 6.0 + 1.0),
	                    					  (int) (Math.random() * 6.0 + 1.0),
	                    					  (int) (Math.random() * 6.0 + 1.0));
				
				s.setZeugnis(zeugnis);
				if (!zeugnis.isBestanden()){
					s.setBenachrichtigung( new Hinweis(s.getJahrgangstufe(), "Klassenziel nicht erreicht"));
				}
				
				
				/*
				 * Testausgabe
				 */
				//System.out.println("Schueler: " + s.toString() + " bestanden: " + zeugnis.isBestanden() + " " + zeugnis.toString());
			}
			/*
			 * Testausgabe
			 */
			System.out.printf("In der Klasse: %2d%c haben %02d von %02d Schueler das Klassenziel erreicht.\n", 
					           this.schulklasse.getJahrgangsstufe(), this.schulklasse.getKlasseName(), this.schulklasse.anzahlBestandeneSchueler(), this.schulklasse.getAnzahlSchueler() );
			
		}
		
	}
	
}
