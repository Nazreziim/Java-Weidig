public class Liste {
	private ListElem start;
	
	public Liste() {
		this.start = null;
	}
	
	public void einfuegen_hinten(int wert) {
		if (this.start == null)
			this.start = new ListElem(wert);
		else
			this.start.hinzufuegen(wert);
	}

	public void einfuegen_vorne(int wert) {
		if (this.start == null)
			this.start = new ListElem(wert);
		else
			this.start = new ListElem(wert, this.start);
	}
	
	public void einfuegen_sort_iter(int wert) {
		//ListElem neuElem = new ListElem(wert);
		if(this.start == null)
			this.start = new ListElem(wert);
		else {
			ListElem vorgaenger = this.start;
			if (vorgaenger.getWert() > wert){
				this.einfuegen_vorne(wert);
				//neuElem.setNaechster(this.start);
				//this.start = neuElem;
			}else {
				while(vorgaenger.getNaechster() != null && vorgaenger.getNaechster().getWert() < wert) {
					vorgaenger = vorgaenger.getNaechster();
				}
				ListElem neuElem = new ListElem(wert, vorgaenger.getNaechster());
				vorgaenger.setNaechster(neuElem);
				System.out.println("Vorgaenger: " + vorgaenger.getWert());
			}
		}
	}
	
	public void einfuegen_sort_rek(ListElem elem, int wert) {
		if(elem == null) {
			ListElem neuElem = new ListElem(wert, elem);
			this.start = neuElem;
		} else if(elem.getWert() > wert) {
			ListElem neuElem = new ListElem(wert, elem);
			elem = neuElem;
		}else {
			einfuegen_sort_rek(elem.getNaechster(), wert);	
		}
	}
	
	public String toString() {
		if(this.start == null)
			return "Leere Liste";
		
		return this.start.toString();
	}
	
	public ListElem getStart() {
		return this.start;	
	}
}
