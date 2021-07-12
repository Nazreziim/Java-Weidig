package uebungen04;

public class A1ListElem {
	private int key;
	private int info;
	private A1ListElem next;
	
	public A1ListElem(int key, int info, A1ListElem next) {
		super();
		this.key = key;
		this.info = info;
		this.next = next;
	}

	
	public A1ListElem getNext() {
		return next;
	}

	public void setNext(A1ListElem next) {
		this.next = next;
	}

	public int getKey() {
		return key;
	}

	
	public void setInfo(int info) {
		this.info = info;
	}


	public int getInfo() {
		return info;
	}

	// Aufgabe 1c
	@Override
	public String toString() {
		return String.format("Key: %02d Info: %2d", this.key, this.info);
	}
	
	
}
