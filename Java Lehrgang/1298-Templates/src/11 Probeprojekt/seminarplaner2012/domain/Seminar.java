package seminarplaner2012.domain;


/**
 * @author c-ix-03-01
 * @version 1.0
 * @created 04-Mai-2012 09:48:44
 */
public class Seminar {

	private String titel;
	private String ort;
	private int teilnehmer;
	private int maxTeilnehmer;
	private Dozent dozent;



	/**
	 * @param titel Titel des Seminars
	 * @param ort Ort an welchem das Seminar stattfindet
	 * @param maxTeilnehmer Maximal zugelassene Teilnehmer
	 * @param dozent Vorgesehener Dozent
	 */
	public Seminar(String titel, String ort, int maxTeilnehmer, Dozent dozent) {
		super();
		this.titel = titel;
		this.ort = ort;
		this.maxTeilnehmer = maxTeilnehmer;
		this.dozent = dozent;
	}
	
	/**
	 * @param titel Titel des Seminars
	 * @param ort Ort an welchem das Seminar stattfindet
	 * @param teilnehmer Anzahl der aktuell gemeldeten Teilnehmer
	 * @param maxTeilnehmer Maximal zugelassene Teilnehmer
	 * @param dozent Vorgesehener Dozent
	 
	 */
	public Seminar(String titel, String ort, int teilnehmer, int maxTeilnehmer,
			Dozent dozent) {
		super();
		this.titel = titel;
		this.ort = ort;
		this.teilnehmer = teilnehmer;
		this.maxTeilnehmer = maxTeilnehmer;
		this.dozent = dozent;
	}




	public void finalize() throws Throwable {

	}
}//end Seminar