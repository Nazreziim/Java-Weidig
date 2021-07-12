package uebungen04;


public class A1Liste {
	private A1ListElem start;
	
	// Aufgabe 1a) FIFO-Prinzip hinten einfuegen
	public void readIn(int key, int info){
		A1ListElem hilf = start;
		
		if ( hilf == null){
			readInLifo( key, info);	
		}		
		else{
			
			while (hilf.getNext() != null){
				hilf = hilf.getNext();
			}
			
			hilf.setNext(new A1ListElem(key, info, null) );
		}
			
	}
	
	public void readInLifo(int key, int info){
		this.start = new A1ListElem(key, info, this.start);
	}
	
	// Aufgabe 1b)
	public A1Liste copy(){
		A1Liste neueListe = new A1Liste();
		A1ListElem hilf = this.start;
		
		while (hilf != null){
			neueListe.readIn(hilf.getKey(), hilf.getInfo());
			hilf = hilf.getNext();
		}
				
		return neueListe;
	}
	
	// Aufgabe 1c)
	public void show(){
		A1ListElem hilf = this.start;
		while ( hilf != null ){
			// Aktion
			System.out.println(hilf.toString());
			// weiterschalten zum naechsten Element
			hilf = hilf.getNext();
		}
	}
	
	// Aufgabe 1d)
	public A1Liste conc(A1Liste liste){
		A1Liste gesListe = this;
		A1ListElem hilf = this.start;
		
		if (hilf == null){
			gesListe = liste;
		}
		else{
			
			while (hilf.getNext() != null){
				hilf = hilf.getNext();
			}
			
			hilf.setNext(liste.start);		
		}
		
		return gesListe;
	}

	// Aufgabe 1e)
	public A1ListElem head(){
		A1ListElem neuesElement = null;
		
		if (this.start != null){
			neuesElement = new A1ListElem(start.getKey(), start.getInfo(), null);
		}
		
		return neuesElement;
	}
	
	// Aufgabe 1f)
	public A1Liste tail(){
		// wichtig: neue Liste anlegen, nicht Referenz kopieren!
		A1Liste cutListe = new A1Liste();
		cutListe.start = this.start;
		
		// erstes Element ausgekettet
		if ( cutListe.start != null ){
			cutListe.start = cutListe.start.getNext();
		}	
			
		return cutListe;
	}
	
	// Aufgabe 1g)
	public int length(){
		A1ListElem hilf = this.start;
		int anzahl = 0;
		
		while( hilf != null ){
			anzahl++;
			hilf = hilf.getNext();
		}
		
		return anzahl;
	}
	
	// Aufgabe 1h)
	public void add(int info, int key){
		A1ListElem hilf = this.start;
		
		while ( hilf != null ){
			if ( hilf.getKey() == key ){
				hilf.setInfo(info);
			}
			
			hilf = hilf.getNext();
		}
	}
	
	// Aufgabe 1i)
	public int get(int key){
		int erg = -1;
		A1ListElem hilf = this.start;
		
		// Variante gibt den letzten gefunden
		// Info-Wert zurueck.
		while ( hilf != null ){
			if ( hilf.getKey() == key ){
				erg = hilf.getInfo();
			}
			
			hilf = hilf.getNext();
		}
		
		return erg;
	}
	
	// Aufgabe 1j)
	public void drop(int key){
		
		A1ListElem vorgaenger = this.start;
		A1ListElem loeschen   = this.start;
				
		// Ausfuegestelle suchen
		while (loeschen != null && loeschen.getKey() != key){
			vorgaenger = loeschen;
			loeschen   = loeschen.getNext();
		}
		
		// Element mit der Info loeschen
		if (loeschen != null && loeschen.getKey() == key){
			
			// loeschen am Listenanfang
			if ( vorgaenger == loeschen ){
				this.start = this.start.getNext();
			}
			else{ // innerhalb der Liste oder am Listenende loeschen
				vorgaenger.setNext(loeschen.getNext()); // Element ausketten aus der Liste
			}		
		}
	}

	// Aufgabe 1k) effektiv aber nicht effizient
	public void reverse(){
		A1Liste neueListe = new A1Liste();
		A1ListElem hilf = this.start;
		
		while ( hilf != null ){
			
			neueListe.readInLifo(hilf.getKey(), hilf.getInfo());
			
			hilf = hilf.getNext();
		}
		
		this.start = neueListe.start;
	}
	
	// Aufgabe 1k)
	public void reverse1(){
		
		A1ListElem vorgaenger = this.start;
		A1ListElem nachfolger = this.start;
		A1ListElem anfang = null;
		
		while ( nachfolger != null  ){
			
			if ( vorgaenger != nachfolger ){
				
				vorgaenger.setNext(anfang);
				anfang = vorgaenger;
			}
			vorgaenger = nachfolger;
			nachfolger = nachfolger.getNext();
		}
		
		if (vorgaenger != null){
			vorgaenger.setNext(anfang);
		}
		
		this.start = vorgaenger;
	}
	
}

