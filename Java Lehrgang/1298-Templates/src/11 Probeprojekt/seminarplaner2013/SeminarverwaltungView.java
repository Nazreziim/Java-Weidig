package seminarplaner2013;


/**
 * @author LGerhard
 * @version 1.0
 * @created 16-Okt-2013 15:10:21
 */
public class SeminarverwaltungView extends View{

	public SeminarverwaltungView(){

	}
	
	public int zeigeMenue(){
		int auswahl = -1;
		try {
			this.clearScreen();
			String ausgabe = "Seminarverwaltung\n"
					+ "(1)\tNeues Seminar hinzufuegen\n"
					+ "(2)\tBestehendes Seminar aendern\n"
					+ "(3)\tSeminar loeschen\n"
					+ "(4)\tSeminaruebersicht\n"
					+ "(5)\tSeminardetails\n"
					+ "(6)\tZurueck zum Seminarplaner";
			auswahl = Integer.parseInt(HilfsMeth.readString(ausgabe));
		} catch (Exception e) {
		}
		return auswahl;
	}
	
	public String frageNach(String frage){
		String antwort = HilfsMeth.readString(frage);
		
		return antwort;
	}
	
	public void zeige(String s) {
		System.out.println(s);
	}
}//end SeminarverwaltungView