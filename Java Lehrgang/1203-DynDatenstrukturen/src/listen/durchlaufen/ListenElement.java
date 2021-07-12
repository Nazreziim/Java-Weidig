package listen.durchlaufen;

public class ListenElement {

	private int inhalt;
	private ListenElement next;
	
	public ListenElement(int inhalt, ListenElement next) {
		super();
		this.inhalt = inhalt;
		this.next = next;
	}

	public int getInhalt() {
		return inhalt;
	}
/*
	public void setInhalt(int inhalt) {
		this.inhalt = inhalt;
	}
*/
	public ListenElement getNext() {
		return next;
	}

	public void setNext(ListenElement next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Inhalt: " + this.inhalt;
	}
	
	
	
}
