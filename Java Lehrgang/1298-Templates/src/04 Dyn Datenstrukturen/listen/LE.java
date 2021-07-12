package listen;

public class LE {
	// Attribute
	// ---------
	private static int key_statisch = 0;  // Klassenvariable, dient zum automatischen Generieren der Key-Wert f�r die Objekte
	private int key;
	private int info; 
	private LE next; 
	
	// Konstruktoren
	// -------------
	public LE (int info) {
		this.info = info;
		this.next = null;
		key = key_statisch++;
	}
	
	/*public LE (int key, int wert) {
		this.key = key;
		this.info = info;
		this.next = null;
	}*/
	
	public LE() {
		this.key = key_statisch++;
		this.info=0;
		this.next = null;
	}
	
	// Getter und Setter
	// -----------------
	public int getKey() {
		return key;
	}
	
	public int getInfo() {
		return info;
	}

	public void setInfo(int wert) {
		this.info = wert;
	}

	public LE getNext() {
		return next;
	}

	public void setNext(LE next) {
		this.next = next;
	}

	// restliche Methoden
	// ------------------
	
	// Aufgabe A
	// Anh�ngen (= hinten einf�gen) eines Elements an ein schon bestehendes (this)
	// entweder: next ist null, dann einfach neues LE erzeugen
	// oder: Auftrag weiterreichen an next (LE)
	public void addEl(int info) {
		if (this.getNext() == null) {
			this.setNext(new LE(info));
		} else {
			this.getNext().addEl(info);
		}
	}

	// Sortiertes Einf�gen eines LE 
	public void addEl_sortiert(int info) {
		// 1. next == null
		if (this.getNext() == null) {
			LE neu = new LE(info);
			this.setNext(neu);
		} else {
			// 2. next.wert > wert
			if (info < this.getNext().getInfo()) {
				// a)
				LE neu = new LE(info);
				// b)
				neu.setNext(this.getNext());
				// c)
				this.setNext(neu);
			} else {
				// 3. next.wert <= wert -> Weiterreichen
				this.getNext().addEl_sortiert(info);
			}
		}
		
		
	}
	
	
	// Aufgabe B: Methode zum Kopieren von Elementen
	public LE copyEl() {
		LE erg = new LE();
		if (this.getNext() == null) {
			erg.setInfo(this.getInfo());
			erg.setNext(null);
		} else {
			erg.setInfo(this.getInfo());
			erg.setNext(this.getNext().copyEl());
		}
		return erg;
	}
	
	// Aufgabe C: Methode zur Ausgabe der Elemente
	public void showEl() {
		System.out.print("["+this.getKey() + "," + this.getInfo() + "] ");
		if (this.getNext() == null) { 
			System.out.println();
		} else {  // Rekursionsschritt			
			this.getNext().showEl();
		}
	}
	
	
	// Aufgabe G : Rekursive Bestimmung der L�nge (= Anzahl der Elemente)
	public int lengthEl() {
		int erg = 1;
		if (this.getNext() != null) {
			erg = this.getNext().lengthEl() + 1;
		}
		return erg;
	}
	
	// Aufgabe G: Iterative Variante zur Bestimmung der L�nge
	public int lengthEl_iterativ() {
		int erg = 1;
		LE hilf = this;
		while (hilf.getNext() != null) {
			erg++;
			hilf = hilf.getNext();			
		}
		return erg;
	
	}
	
	// Aufgabe I: Element-info zu �bergebenem key bestimmen und zur�ckgeben.
	// Wenn key nicht vorhanden: Ergebnis = -1
	public int getEl(int key) {
		int erg = -1;
		if (this.getKey() == key) {
			erg = this.getInfo();
		} else {
			if (this.getNext() != null) {
				erg = this.getNext().getEl(key);
			}
		}
		return erg;
	}
	
	// Aufgabe H: In einem Element mit Schl�sselwert key soll die info �berschrieben werden
	public void changeInfo(int info, int key) {
		if (this.getKey() == key) { // Stelle gefunden -> info �berschreiben
			this.setInfo(info);
		} else { // Stelle (noch) nicht gefunden
			if (this.getNext() != null) { // Wenn noch nicht am Listenende angekommen!
				this.getNext().changeInfo(info, key);
			}
		}		
	}
	
	// Aufgabe J : Entfernen eines Elements anhand des keys
	public void dropEl(int key) {
		
		if (this.getNext() == null) {
			// 1. Fall: Letztes Element erreicht - nichts zu l�schen
		} else {
			// 2. Fall: Das n�chste Element ist das zu l�schende -> next "ausketten" 
			if (this.getNext().getKey() == key) {
				this.setNext(this.getNext().getNext());
			} else { // 3. Fall: Rekursionsschritt (Bienge!!!) nicht letztes El. und das n�chste ist nicht das gesuchte
				this.getNext().dropEl(key);
			}
		}
	}
	

	
	// Aufgabe K: Listenelemente r�ckw�rts verketten
	public LE reverse() {
		LE erg;
		//Rekursionsende: letztes Element - ist r�ckw�rts auch nicht anders :-)
		if (this.getNext() == null) {
			erg = this;
		} else { // Rekursionsschritt: Aufruf von reverse auf dem n�chsten & ans Ergebnis den Wert des aktuellen anh�ngen
			erg = this.getNext().reverse();
			erg.addEl(this.getInfo());
		}
		return erg;
	}





	


}
