package generics.liste;

public class Liste<T> {
	private LE<T> start;
	
	public Liste() {
		this.start = null;
	}
	

	// Aufgabe a) (readIn - nur mit anderem Namen!)
	// Hinzufügen eines Elements in eine Liste (hinten dran!)
	// entweder: leere Liste -> dann start auf neues LE
	// oder: Liste schon befüllt -> dann Auftrag weiterreichen ans LE
	public void add_hinten(T wert) {
		if (this.start == null) {
			this.start = new LE<T>(wert);
		} else {
			start.addEl(wert);
		}
	}
	
	// Abwandlung a.1 : Einfügen vorne in eine Liste
	public void add_vorne(T wert) {
		// 1
		LE<T> neu_el = new LE<T>(wert);
		// 2
		neu_el.setNext(this.start);
		// 3
		this.start = neu_el;
	}
	
	// Abwandlung a.2 : Sortiertes Einfügen
	/*public void add_sortiert(int wert) {
		if (this.start == null) { //1.) leere Liste: einfügen vorne
			this.start = new LE(wert);
		} else {
			if (this.start.getInfo() >= wert) { // 2.) neuer Wert <= erster Listenwert: einfügen vorne!
				add_vorne(wert);
			} else { // 3.) neuer Wert irgendwo in oder am Ende der Liste -> Auftrag ans LE
				start.addEl_sortiert(wert);
			}	
		}			
	}*/
	

	
	// Aufgabe c) - Methode zum Ausgeben einer Liste
	public void show() {
		if (this.start == null) {
			// System.out.println("Leere Liste");
		} else {
			this.start.showEl();
		}
		
	}


	





	
}
