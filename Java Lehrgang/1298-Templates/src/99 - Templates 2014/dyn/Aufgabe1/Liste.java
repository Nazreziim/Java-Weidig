public class Liste {
	
	public ListElem start;
	
	public Liste() {
		ListElem.zaehler = 0;
		this.start = null;
	}
	
	public Liste(int wert) {
		ListElem.zaehler = 0;
		this.start = new ListElem(wert);
	}
	
	public void readIn(int wert) {
		if(this.start == null)
			this.start = new ListElem(wert);
		else
			this.start.hinzufuegen(wert);
	}
	
	public Liste copy() {
		Liste kopie = new Liste();
		if(this.start != null) {
			kopie.readIn(this.start.info);
			
			ListElem hilfZeiger = this.start;
			while(hilfZeiger.next != null){
				hilfZeiger = hilfZeiger.next;
				kopie.readIn(hilfZeiger.info);
			}			
			
		}
		
		return kopie;
	}
	
	public Liste copy_rek() {
		Liste kopie = new Liste();
		if(this.start != null) {
			kopie.start = this.start.copyElem();
		}
		
		return kopie;
	}
	
	public Liste conc(Liste liste) {
		if(this.start == null)
			this.start = liste.start;
		else {
			ListElem hilfZeiger = this.start;
			while(hilfZeiger.next != null) {
				hilfZeiger = hilfZeiger.next;
			}
			hilfZeiger.next = liste.start;
		}
		
		return this.copy_rek();
	}
	
	public ListElem head() {
		if(this.start == null)
			return null;
		else {
			ListElem elem = new ListElem(this.start.info);
			elem.key = this.start.key;
			return elem;
		}
	}
	
	public Liste tail() {
		if(this.start == null)
			return null;
		else {
			Liste liste = new Liste();
			liste.start = this.start.next.copyElem();
			return liste;
		}
	}
	
	public int length() {
		if (this.start == null)
			return 0;
		else {
			int erg = 1;
			ListElem hilfZeiger = this.start;
			while(hilfZeiger.next != null) {
				hilfZeiger = hilfZeiger.next;
				
				erg++;
			}
			
			return erg;
		}
	}
	
	public int length_rek() {
		if(this.start == null)
			return 0;
		else
			return this.start.lengthElem();
	}
	
	public void add(int info, int key) {
		ListElem hilfZeiger = this.start;
		boolean gefunden = false;
		while(hilfZeiger.next != null && !gefunden) {
			if (hilfZeiger.key == key) {
				hilfZeiger.info = info;
				gefunden = true;
			}
			hilfZeiger = hilfZeiger.next;
		}
	}
	
	public void add_rek(int info, int key) {
		if(this.start != null)
			this.start.addElem(info, key);
	}
	
	public int get(int key) {
		if(this.start != null)
			return this.start.getElem(key);
		else
			return -1;
	}
	
	public void drop(int key) {
		if(this.start != null) {
			if (this.start.key == key)
				this.start = this.start.next;
			else
				this.start.dropElem(key);
		}
	}
	
	public Liste reverse() {
		if (this.start == null)
			return null;
		else {
			Liste liste = new Liste();
			ListElem erg = this.start.reverseElem();
			liste.start = erg;
			return liste;
		}
	}
	
	public String toString() {
		return "Liste: \n " + this.start.toString();
	}
}
