public class Knoten {
	public int wert;
	public Knoten links;
	public Knoten rechts;
	
	public Knoten() {
		this.wert = 0;
		this.links = null;
		this.rechts = null;
	}
	
	public Knoten(int wert) {
		this.wert = wert;
		this.links = null;
		this.rechts = null;
	}
	
	public void addKnoten(int wert) {
		if(wert < this.wert) {
			if(this.links == null)
				this.links = new Knoten(wert);
			else
				this.links.addKnoten(wert);
		}else {
			if(this.rechts == null)
				this.rechts = new Knoten(wert);
			else
				this.rechts.addKnoten(wert);
		}
			
	}
	
	public int hoeheKnoten() {
		int hoehe_links = 0;
		int hoehe_rechts = 0;
		if(this.links != null)
			hoehe_links += this.links.hoeheKnoten();
		if(this.rechts != null)
			hoehe_rechts += this.rechts.hoeheKnoten();
		
		return hoehe_links < hoehe_rechts ? hoehe_rechts + 1 : hoehe_links + 1;
	}
	
	public Knoten loescheKnoten(int wert) {
		// zu loeschender Knoten wurde gefunden
		if(this.wert == wert) {
			// 1. Knoten ist Blatt (einfach)
			if(this.links == null && this.rechts == null)
				return null;
			
			//2. Knoten hat einen Nachfolger
			else if (this.links != null && this.rechts == null)
				return this.links;
			else if (this.rechts != null && this.links == null)
				return this.rechts;
			
			// 3. Knoten hat zwei Nachfolger
			else {
				if(this.links.hoeheKnoten() > this.rechts.hoeheKnoten()) {
					Knoten erg = this.links.groessterLinks();
					this.wert = erg.wert;
					this.links = this.links.loescheKnoten(erg.wert);
					return this;
				}else {
					this.wert = this.rechts.kleinsterRechts();
					this.rechts = this.rechts.loescheKnoten(this.wert);
					return this;
				}
			}
		}
		
		// nicht der zu loeschende Knoten, also entweder links oder rechts weitersuchen
		else if(wert < this.wert) {
			if(this.links != null)
				this.links = this.links.loescheKnoten(wert);
		}
		else {
			if(this.rechts != null)
				this.rechts = this.rechts.loescheKnoten(wert);
		}
		
		return this;
	}
	
	public Knoten groessterLinks() {
		if(this.rechts == null)
			return this;
		else
			return this.rechts.groessterLinks();
	}
	
	public int kleinsterRechts() {
		if(this.links == null)
			return this.wert;
		else
			return this.links.kleinsterRechts();
	}
	
	public String toString() {
		String erg = "";
		if(this.links != null)
			erg += this.links.toString();
		
		erg += this.wert + " ";
		
		if(this.rechts != null)
			erg += this.rechts.toString();
		
		return erg;
	}

}
