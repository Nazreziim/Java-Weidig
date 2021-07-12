public class Baum {
	private Knoten wurzel;
	
	public Baum() {
		this.wurzel = null;
	}
	
	// Methode zum sortierten Einf�gen in einen Baum
	public void add(int key) {
		if (this.wurzel == null) {  // leerer Baum!!!
			this.wurzel = new Knoten(key);
		} else { // kein leerer Baum: Auftrag an wurzel weitergeben
			this.wurzel.addKnoten(key);
		}
	}
	
	// Methode zum Ausgeben eines Baumes
	public void show() {
		if (this.wurzel != null) {
			this.wurzel.showKnoten_sortiert();
		}
	}
	
	// Post-Order Ausgabe: Links - Rechts - Ich w�rde liefern: 1,3,1,4,6,7,5
	
	public void drop(int key) {
		if (this.wurzel != null) {
			this.wurzel = this.wurzel.dropKnoten(key);
		}
	}

	public int getHoehe() {
		int erg = 0;
		if (this.wurzel != null) {
			erg = this.wurzel.hoehe(); 
		}
		return erg;
	}
}
