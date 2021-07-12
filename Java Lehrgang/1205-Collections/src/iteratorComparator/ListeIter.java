package iteratorComparator;

import java.util.Iterator;

public class ListeIter implements Iterator<Integer>, Iterable<Integer>{
	private ListenElement start;
	// fuer Iterator-Implementierung
	private ListenElement current;
	
	ListeIter(){
		this.start = null;
	}
	
	public void einfuegenVorne(int info){
		
		this.start = new ListenElement(info, this.start);
	}
	
	
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
	
	public void loescheAlleElemnte(){
		ListenElement loesch = null;
		
		while (this.start != null){
			loesch = this.start;
			
			this.start = this.start.getNext(); // alle Elemente ausketten
			
			loesch.setNext(null);
		}
		
	}
	
	
	public void ausgebenAllerElemente(){
		ListenElement hilf = this.start;
		
		System.out.println("Ausgabe aller Elemente");
		System.out.println("======================");
		
		while ( hilf != null){
			System.out.println(hilf.toString());
			hilf = hilf.getNext();
		}
	}
	
		
	public int anzahlElemente(){
		int anzahl = 0;
		ListenElement hilf = this.start;
		
		
		while ( hilf != null){
			anzahl++;
			hilf = hilf.getNext();
		}
		return anzahl;
	}
	
	@Override
	public ListeIter clone(){
		ListenElement hilf = this.start;		
		ListeIter liste = new ListeIter();
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

	@Override
	public Iterator<Integer> iterator() {
		this.current = this.start;
		return this;
	}

	@Override
	public boolean hasNext() {
		
		return current != null;
	}

	@Override
	public Integer next() {
		Integer wert = null;
		if (hasNext()){
			wert = current.getInfo();
			current = current.getNext();
		}
		return wert;
	}	
}
