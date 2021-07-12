package generics.liste;

public class LE<T> {
	// Attribute
	// ---------
	private static int key_statisch = 0;  // Klassenvariable, dient zum automatischen Generieren der Key-Wert für die Objekte
	private int key;
	private T info; 
	private LE<T> next; 
	
	// Konstruktoren
	// -------------
	public LE (T info) {
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
		this.info=null;
		this.next = null;
	}
	
	// Getter und Setter
	// -----------------
	public int getKey() {
		return key;
	}
	
	public T getInfo() {
		return info;
	}

	public void setInfo(T wert) {
		this.info = wert;
	}

	public LE<T> getNext() {
		return next;
	}

	public void setNext(LE<T> next) {
		this.next = next;
	}

	// restliche Methoden
	// ------------------
	
	// Aufgabe A
	// Anhängen (= hinten einfügen) eines Elements an ein schon bestehendes (this)
	// entweder: next ist null, dann einfach neues LE erzeugen
	// oder: Auftrag weiterreichen an next (LE)
	public void addEl(T info) {
		if (this.getNext() == null) {
			this.setNext(new LE<T>(info));
		} else {
			this.getNext().addEl(info);
		}
	}

	/*
	// Sortiertes Einfügen eines LE 
	public void addEl_sortiert(T info) {
		// 1. next == null
		if (this.getNext() == null) {
			LE neu = new LE(info);
			this.setNext(neu);
		} else {
			// 2. next.wert > wert
			if (key < this.getNext().getKey()) {
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
		
		
	}*/
	

	
	// Aufgabe C: Methode zur Ausgabe der Elemente
	public void showEl() {
		System.out.print("["+this.getKey() + "," + this.getInfo() + "] ");
		if (this.getNext() == null) { 
			System.out.println();
		} else {  // Rekursionsschritt			
			this.getNext().showEl();
		}
	}
	

	
	





	


}
