public class ListElem {
	
	public static int zaehler = 0;
	public int key;
	public int info;
	public ListElem next;
	
	public ListElem() {
		this.key = zaehler++;
		this.info = 0;
		this.next = null;
	}
	
	public ListElem(int wert) {
		this.key = zaehler++;
		this.info = wert;
		this.next = null;
	}
	
	public void hinzufuegen(int wert) {
		if(this.next == null)
			this.next = new ListElem(wert);
		else
			this.next.hinzufuegen(wert);
	}
	
	public ListElem copyElem() {
		ListElem kopie;
		if(this.next == null)
			kopie = new ListElem(this.info);
		else {
			kopie = new ListElem(this.info);
			kopie.next = this.next.copyElem();
		}
		
		return kopie;
	}
	
	public int lengthElem() {
		int erg = 1;
		if (this.next != null)
			erg += this.next.lengthElem();
		
		return erg;
	}
	
	public void addElem(int info, int key) {
		if (this.key == key) {
			this.info = info;
		}else {
			if(this.next != null)
				this.next.addElem(info, key);
		}
	}
	
	public int getElem(int key) {
		if (this.key == key)
			return this.info;
		else {
			if(this.next != null)
				return this.next.getElem(key);
			else
				return -1;
		}
	}
	
	public void dropElem(int key) {
		if(this.next != null) {
			if(this.next.key == key)
				this.next = this.next.next;
			else
				this.next.dropElem(key);
		}
			
	}
	
	public ListElem reverseElem() {
		if(this.next == null)
			return this;
		else {
			ListElem erg = this.next.reverseElem();
			erg.hinzufuegen(this.info);
			return erg;
		}
	}
	
	public String toString() {
		return "Element " + this.key + ": " + this.info + "\n" + this.next;
	}
}
