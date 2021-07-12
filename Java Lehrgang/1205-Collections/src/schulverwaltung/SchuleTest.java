package schulverwaltung;

public class SchuleTest {

	final static int ANZAHL_PERSONEN = 400;
	final static int ANZAHL_SCHULJAHRE = 3;
	
	public static void main(String[] args) {
	    int anzahlPersonen = SchuleTest.ANZAHL_PERSONEN;
		int anzahlSchuljahre = ANZAHL_SCHULJAHRE;
		
	    if (args.length >= 1 ){
			anzahlPersonen = Integer.parseInt(args[0]);
		}
	    
	    if (args.length >= 2 ){
	    	anzahlSchuljahre = Integer.parseInt(args[1]);
		}
		
		SchulVerw schulverwaltung = new SchulVerw();
		
		schulverwaltung.anmeldungPersonal(anzahlPersonen);
			
		for (int jahre = 0; jahre < anzahlSchuljahre; jahre++){
			
			schulverwaltung.erstelleNeuesSchuljahr(String.format("20" + (16 + jahre) + "/20" + (17 + jahre), jahre));
		
			System.out.println("Klassenlehrer wurde zugewiesen? "+ schulverwaltung.zuteilenLehrerKlasse());
		
			schulverwaltung.erstelleZeugnisse();
		
			System.out.printf("Es haben %03d Schueler das Schuljahr: " + schulverwaltung.gebeAktuellesSchuljahr() + " erfolgreich abgeschlossen.\n", schulverwaltung.abschlussSchuljahr());
			
			System.out.println();
			
		}
		
	}

}
