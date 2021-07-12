package listen.flavius;

/**
 * Die Sklavenliste verwaltet die SklavenElemente.
 * 
 * @author whoelzle
 *
 */
public class SklavenList {
	private SklavenElement start;
	private boolean istAufnameBeendet;
	
	/**
	 * Konstruktor der Klasse
	 */
	public SklavenList() {
		this.start = null;
		this.istAufnameBeendet = false;
	}
	
	/**
	 * Methode fuegt vorne einen Sklaven in die Liste ein.
	 * @param info	Sklave
	 */
	private void einfuegenVorne(Sklave info){
		
		this.start = new SklavenElement(info, this.start);
	}
	
	/**
	 * Methode fuegt hinten ein Element in die Liste ein.
	 * @param info
	 */
	public boolean einfuegenHinten(Sklave info){
		
		boolean istAufnahmeOk = !istAufnahmeBeendet();
		
		if (istAufnahmeOk) {
			SklavenElement hilf = this.start;
			
			if ( hilf != null){
				
				// hilf-Referenz auf letztes Element setzen
				while (hilf.getNext() != null){
					hilf = hilf.getNext();
				}
				// Element hinten einfuegen
				hilf.setNext(new SklavenElement(info));
			}
			else{ // vorne einfuegen
				einfuegenVorne(info);
			}
		}
		
		return istAufnahmeOk;
	}
	
	/**
	 * Methode prueft, ob die Aufnahme beendet wurde.
	 * @return
	 */
	private boolean istAufnahmeBeendet() {
		return this.istAufnameBeendet;
	}
	
	/**
	 * Private rekursive Methode zum Schliessen der Liste zu einem Ring.
	 * @param sklavenElement
	 */
	private void schliesseKreis(SklavenElement sklavenElement) {
		if (sklavenElement != null) {
			if (sklavenElement.getNext() == null) {
				sklavenElement.setNext(this.start);
			} else {
				schliesseKreis(sklavenElement.getNext());
			}
		}
	}
	
		
	/**
	 * Methode erstellt eine Ringliste.
	 */
	public void schliesseKreis() {
				
		schliesseKreis(this.start);
		this.istAufnameBeendet = true;
	}
	
	/**
	 * Methode prueft, ob Elemente in der Liste vorhanden sind.
	 * @return	true, keine Elemente in der Liste.
	 */
	public boolean istLeer() {
		return this.start == null;
	}
	
	/**
	 * Methode stellt das Endekriterium fest.
	 * @return	boolean true, fuer nur noch ein Element in der Liste
	 */
	public boolean istBeendet() {
		return this.start.getNext() == start;
	}
	
	
	/**
	 * Methode gibt das letzte verbleibene Element der Liste zurueck.
	 * @return	Sklave 
	 */
	public Sklave gebeSieger() {
		Sklave sklave = null;
		
		if (istBeendet()) {
			sklave = this.start.getElement();
		}
		return sklave;
	}
	
	/**
	 * Methode gibt das aktuelle (erstes Element) Element zurueck.
	 * @return Sklave 
	 */
	public Sklave gebeAktuellesElement() {
		
		return (this.start != null ) ? this.start.getElement() : null;
	}
	
	
	/**
	 * Methode entfernt ein bestimmtes Element aus der Liste und gibt diese
	 * zurueck.
	 * @param anzahlSilben	das wie vielte- Element in der Ring-Liste soll entfernt werden.
	 * @return
	 */
	public SklavenElement entferneElement(int anzahlSilben) {
		SklavenElement loeschElement = null;
		
		if (istAufnahmeBeendet() && !istBeendet() && anzahlSilben > 1) {
			
			// Beim Silben zaehlen steht man bereits auf dem ersten Element und
			// zum weiteren wollen wir vor dem zu entfernenden Element stehen bleiben,
			// damit wir es ausketten koennen.
			// Abzählen: Weiterschalten der Start-Referenz (anzSilben - 2 Mal!)
			// danach steht start auf dem Vorgänger des zu entfernenden Elements 
			for (int i = 2; i < anzahlSilben; i++) {
				this.start = this.start.getNext();
			}
				
			loeschElement = this.start.getNext();	
			
			// Ausketten = Entfernen
			start.setNext(start.getNext().getNext());
			
			
			// auf naechstes Element setzen
			this.start = this.start.getNext();
		}
		
		return loeschElement;
	}
	
}
