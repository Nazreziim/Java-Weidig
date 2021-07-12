package generics.baum;

public class Baum<T extends Comparable<T>, S> {
	private Knoten<T,S> wurzel;
	
	public Baum() {
		this.wurzel = null;
	}
	
	// Methode zum sortierten Einfügen in einen Baum
	public void add(T key) {
		if (this.wurzel == null) {  // leerer Baum!!!
			this.wurzel = new Knoten<T,S>(key);
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
	
	// Post-Order Ausgabe: Links - Rechts - Ich würde liefern: 1,3,1,4,6,7,5
	
	public void drop(T key) {
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
