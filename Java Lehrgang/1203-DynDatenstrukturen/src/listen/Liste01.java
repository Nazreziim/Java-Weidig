package listen;

public class Liste01 {
	private ListenElement start;
	
	/**
	 * Konstruktor der Klasse
	 */
	public Liste01(){
		this.start = null;
	}
	
	/**
	 * Methode fuegt ein Listenelement der Liste hinzu.
	 * @param info	int verwaltete Information.
	 */
	public void einfuegenVorne(int info){
		/*
		// in leere Liste einfuegen
		if (start == null){
			start = new ListenElement01(wert);
		}
		else{ // vorne in die Liste einfuegen
			start = new ListenElement01(wert, start);
		}
		*/
		// optimierte Version
		this.start = new ListenElement(info, this.start);
	}
	
	
	/**
	 * Methode fuegt ein Listenelement der Liste hinten an.
	 * @param info	int verwaltete Information.
	 */
	public void einfuegenHinten(int info){
		
		ListenElement hilf = this.start;
		
		if ( hilf != null){
			
			// hilf-Referenz auf letztes Element setzen
			while (hilf.getNext() != null){
				hilf = hilf.getNext();
			}
			// Element hinten einfuegen
			hilf.setNext(new ListenElement(info));
		}
		else{ // vorne einfuegen
			einfuegenVorne(info);
		}
	}
	
	
	/**
	 * Methode fuegt sortiert Listenelemente in die Liste ein.
	 * @param info	int verwaltete Information.
	 */
	public void einfuegenSortiert(int info){
		ListenElement vorgaenger = start;
		ListenElement nachfolger = start;
		
		// weiterschalten mit Nachschleppen
		while (nachfolger != null && nachfolger.getInfo() <= info){
			vorgaenger = nachfolger;
			nachfolger = nachfolger.getNext();
		}
		
		// Einfuegeposition gefunden
		if (vorgaenger == nachfolger){ // Anfang oder leere Liste
			einfuegenVorne(info);
		}
		else{ // sortiert einfuegen mitte und am Ende der Liste
			vorgaenger.setNext(new ListenElement(info, nachfolger));
		}
		
	}
	
	/**
	 * Methode entfernt ein Listenelement aus einer Liste.	
	 * @param info  int verwaltete Information
	 * @return	true, fuer Listenelement wurde entfernt.
	 */
	public boolean loescheElement(int info){
		ListenElement vorgaenger = this.start;
		ListenElement loeschen   = this.start;
		boolean gefunden = false;
		
		// Ausfuegestelle suchen
		while (loeschen != null && loeschen.getInfo() != info){
			vorgaenger = loeschen;
			loeschen   = loeschen.getNext();
		}
		
		// Element mit der Info loeschen
		if (loeschen != null && loeschen.getInfo() == info){
			
			// loeschen am Listenanfang
			if ( vorgaenger == loeschen ){
				this.start = this.start.getNext();
			}
			else{ // innerhalb der Liste oder am Listenende loeschen
				vorgaenger.setNext(loeschen.getNext()); // Element ausketten aus der Liste
			}
			gefunden = true;
		}
		return gefunden;
	}
	
	/**
	 * Methode loescht alle Listenelemente einer Liste.
	 * Hinweis: start-Referenz auf null setzen wuerde auch funktionieren!
	 */
	public void loescheAlleElemnte(){
		ListenElement loesch = null;
		
		while (this.start != null){
			loesch = this.start;
			
			this.start = this.start.getNext(); // alle Elemente ausketten
			
			loesch.setNext(null);
		}
		
	}
	
	/**
	 * Methode gibt alle Inhalte der einzelnen Listenelemente aus.
	 */
	public void ausgebenAllerElemente(){
		ListenElement hilf = this.start;
		
		System.out.println("Ausgabe aller Elemente");
		System.out.println("======================");
		
		while ( hilf != null){
			System.out.println(hilf.toString());
			hilf = hilf.getNext();
		}
	}
	
	/**	
	 * Methode gibt die Anzahl der Elemente zurueck.
	 * @return int Anzahl der Elemente
	 */
	public int anzahlElemente(){
		int anzahl = 0;
		ListenElement hilf = this.start;
		
		
		while ( hilf != null){
			anzahl++;
			hilf = hilf.getNext();
		}
		return anzahl;
	}
	
	/**
	 * Methode erstellt einen tiefe Kopie der eigenen Liste und
	 * gibt diese zurueck.
	 * @return Liste01 Referenz auf neue Liste
	 */
	@Override
	public Liste01 clone(){
		ListenElement hilf = this.start;		
		Liste01 liste = new Liste01();
		ListenElement hilfNeu = null;
		
		if ( this.start != null ){
			
			liste.start = this.start.clone();
			hilfNeu = liste.start;
		
			while (  hilf.getNext() != null){
				
				hilfNeu.setNext(hilf.getNext().clone());
				
			    hilfNeu = hilfNeu.getNext();
				hilf = hilf.getNext();
			}
		}
				
		return liste;
	}	
}
