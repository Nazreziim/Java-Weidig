public class ListElem {
	private int wert;
	private ListElem naechster;

	public ListElem() {
		this.wert = 0;
		this.naechster = null;
	}
	
	public ListElem(int wert) {
		this.wert = wert;
		this.naechster = null;
	}
	
	public ListElem(int wert, ListElem naechster) {
		this.wert = wert;
		this.naechster = naechster;
	}
	
	public int getWert() {
		return this.wert;	
	}
	
	public ListElem getNaechster() {
		return this.naechster;	
	}
	
	public void setWert(int wert) {
		this.wert = wert;
	}
	
	public void setNaechster(ListElem naechster) {
		this.naechster = naechster;
	}
	
	public void hinzufuegen(int wert) {
		if(this.naechster == null) {
			this.naechster = new ListElem(wert);
		} else {
			this.naechster.hinzufuegen(wert);
		}
	}
	
	public void hinzufuegen_iter(int wert) {
		if(this.naechster == null) {
			this.naechster = new ListElem(wert);
		} else {
			ListElem hilfZeiger = this.naechster;
			while(hilfZeiger.naechster != null) {
				hilfZeiger = hilfZeiger.naechster;
			}
			hilfZeiger.naechster = new ListElem(wert);
		}
	}
	
	public String toString() {
		if (this.naechster == null) {
			return Integer.toString(this.wert);
		} else {
			return this.wert + "\n" + this.naechster.toString();
		}
	}
}
