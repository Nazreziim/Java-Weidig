package listen;

public class Liste {
	private LE start;
	
	public Liste() {
		this.start = null;
	}
	
	// Aufgabe a) (readIn - nur mit anderem Namen!)
	// Hinzufügen eines Elements in eine Liste (hinten dran!)
	// entweder: leere Liste -> dann start auf neues LE
	// oder: Liste schon befüllt -> dann Auftrag weiterreichen ans LE
	public void add_hinten(int wert) {
		if (this.start == null) {
			this.start = new LE(wert);
		} else {
			start.addEl(wert);
		}
	}
	
	// Abwandlung a.1 : Einfügen vorne in eine Liste
	public void add_vorne(int wert) {
		// 1
		LE neu_el = new LE(wert);
		// 2
		neu_el.setNext(this.start);
		// 3
		this.start = neu_el;
	}
	
	// Abwandlung a.2 : Sortiertes Einfügen
	public void add_sortiert(int wert) {
		if (this.start == null) { //1.) leere Liste: einfügen vorne
			this.start = new LE(wert);
		} else {
			if (this.start.getInfo() >= wert) { // 2.) neuer Wert <= erster Listenwert: einfügen vorne!
				add_vorne(wert);
			} else { // 3.) neuer Wert irgendwo in oder am Ende der Liste -> Auftrag ans LE
				start.addEl_sortiert(wert);
			}	
		}			
	}
	
	// Aufgabe b) - Erzeugen einer Kopie
	public Liste copy() {
		Liste erg = new Liste();
		if (this.start != null) {
			erg.start = this.start.copyEl();
		}
		return erg;
	}
	
	// Aufgabe c) - Methode zum Ausgeben einer Liste
	public void show() {
		if (this.start == null) {
			// System.out.println("Leere Liste");
		} else {
			this.start.showEl();
		}
		
	}

	// Aufgabe d) - Listen aneinanderhängen
	public Liste conc(Liste zweite) {
		if (this.start == null) {
			this.start = zweite.start;
		} else {
			LE hilf = this.start;
			while (hilf.getNext() != null) {
				hilf = hilf.getNext();
			}
			hilf.setNext(zweite.start);
		}
		return this;
	}
	
	// Aufgabe e) - Erstes Listenelement als neue Liste
	public Liste head() {
		Liste erg = new Liste();
		if (this.start == null) {
			erg = null;
		} else {
			erg.start = new LE(this.start.getInfo());
		}
		return erg;
	}

	// Aufgabe f) - Eine neue Liste ohne das erste Element zurückgeben
	public Liste tail() {
		Liste erg = new Liste();
		if (this.start == null) {
			erg = null;
		} else {
			erg.start = this.start.getNext();
		}
		return erg;
	}

	// Aufgabe g) - Länge einer Liste
	public int length() {
		int erg = 0;
		if (this.start != null) {
			erg = this.start.lengthEl_iterativ();
		}
		return erg;
	}
	
	// Aufgabe h) - Diese Methode überschreibt im Element mit dem Schlüssel key,
	// den info-Wert mit dem übergebenen Parameter.
	// Sollte kein Element mit dem key existieren wird auch nichts gemacht! 
	public void add(int info, int key) {
		if (this.start != null) {
			this.start.changeInfo(info, key);
		}
		
	}
	
	// Aufgabe i) - Die info zu einem übergebenen key-Wert bestimmen und zurückgeben
	// Sollte der key nicht existieren wird -1 zurückgegeben
	public int get(int key) {
		int erg = -1;
		if (this.start != null) {
			erg = start.getEl(key);
		}
		return erg;
	}
		
	// Aufgabe j) - Methode zum löschen eines Elements
	public void drop(int key) {
		if (this.start != null) {
			if (this.start.getKey() == key) {
				this.start = this.start.getNext();
			} else {
				start.dropEl(key);
			}
		}
	}
	
	// Aufgabe k) - Liste rückwärts
	public Liste reverse() {
		Liste erg = new Liste();
		if (this.start == null ) {
			erg = null;
		} else {
			erg.start = this.start.reverse();
		}
		return erg;
	}




	
}
