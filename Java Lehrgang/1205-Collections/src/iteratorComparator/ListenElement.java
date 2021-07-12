package iteratorComparator;

public class ListenElement {
	
	// Klassenvariable, dient zum automatischen Generieren der Key-Wert für die Objekte
	private static int key_statisch = 0; 
	
	// Attribute
	// ---------
	private int key;
	private int info; 
	private ListenElement next; 
	
	// Konstruktoren
	// -------------
	
	public ListenElement() {
		this.key = key_statisch++;
		this.info=0;
		this.next = null;
	}
	
	public ListenElement (int info) {
		this.info = info;
		this.next = null;
		key = key_statisch++;
	}
	
	public ListenElement (int info, ListenElement next) {
		this.info = info;
		this.next = next;
		key = key_statisch++;
	}

	
	// Getter und Setter
	// -----------------
	public int getKey() {
		return key;
	}
	
	public int getInfo() {
		return info;
	}
/*
	public void setInfo(int wert) {
		this.info = wert;
	}
*/
	public ListenElement getNext() {
		return next;
	}

	public void setNext(ListenElement next) {
		this.next = next;
	}

	@Override
	public String toString(){
		return String.format("Key %02d : Info %d", this.key, this.info);
	}
	@Override
	public ListenElement clone(){
		return new ListenElement(this.info);
	}
	
}
