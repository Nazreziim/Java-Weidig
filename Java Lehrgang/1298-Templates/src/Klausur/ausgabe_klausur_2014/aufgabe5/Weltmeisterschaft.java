package ausgabe_klausur_2014.aufgabe5;
/**
*Name:
*DG:
*/
public class Weltmeisterschaft {
	private static int zaehler = 0;
	private Mannschaft[] teams;
	
	
	public Weltmeisterschaft() {
		teams = new Mannschaft[32];
		generateTeams();
	}

	/**
	 * Diese Methode erzeugt soviele Teams, wie Teilnehmer für die WM benötigt werden
	 */
	private void generateTeams() {
		for (int i = 0; i < teams.length; i++) {
			teams[i] = new Mannschaft("Land Nr. " + zaehler++);
		}
		
	}
	
	public Mannschaft[] getTeams() {
		return teams;
	}
	
	
	/**
	 * Diese Methode führt eine Spielrunde durch - und ist durch Sie zu befüllen!
	 */
	public void naechsteRunde() { 
			
	}

}
