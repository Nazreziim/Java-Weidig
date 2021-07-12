package seminarplaner2013;


/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:12
 */
public class SeminarplanerView extends View{

	public SeminarplanerView(){

	}
	
	/**
	 * return value codiert die Auswahl des Nutzers im Hauptmenü
	 */
	public int zeigeHauptmenue(){
		this.clearScreen();
		int auswahl = -1;
		try {
			String ausgabe = "Seminarplaner\n"
					+ "(1)\tZur Seminarverwaltung wechseln\n"
					+ "(2)\tZur Kundenverwaltung wechseln\n"
					+ "(3)\tZur Dozentenverwaltung wechseln\n"
					+ "(4)\tLaden\n"
					+ "(5)\tSpeichern\n"
					+ "(6)\tProgramm beenden";
			auswahl = Integer.parseInt(HilfsMeth.readString(ausgabe));
		} catch (Exception e) {
		}
		return auswahl;
	}

	public String liesPfadEin(){
		return "";
	}
}//end SeminarplanerView