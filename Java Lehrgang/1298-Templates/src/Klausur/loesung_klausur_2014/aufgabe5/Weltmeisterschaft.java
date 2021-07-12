package loesung_klausur_2014.aufgabe5;

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
	
	public void naechsteRunde() { 
		Mannschaft[] erg = new Mannschaft[teams.length / 2];
		for (int i = 0; i < erg.length; i++) {
			Mannschaft sieger;
			if (teams[i].calcStaerke() > teams[teams.length-1-i].calcStaerke()) {
				sieger = teams[i];
			} else {
				sieger = teams[teams.length-1-i];
			}
			erg[i] = sieger;
		}
		teams = erg;		
	}

	


	public Mannschaft[] getTeams() {
		return teams;
	}
	

	@Override
	public String toString() {
		String erg = "An der WM nehmen teil: \n";
		for (Mannschaft t : teams) {
			erg += t.toString() + "\n";
		}
		return erg;
	}

}
