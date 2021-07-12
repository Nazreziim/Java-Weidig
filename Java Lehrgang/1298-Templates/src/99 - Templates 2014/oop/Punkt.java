/**
 * Die Klasse Punkt  
 */
class Punkt {
	
	// Attribute
	private int x;
	private int y;
	
	// Methode
	public Punkt() {
		this.x = 0;
		this.y = 0;
	}
	
	public Punkt(int wert) {
		this.x = wert;
		this.y = wert;
	}
	
	public Punkt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean equalsTo(Punkt punkt) {
		return this.x == punkt.getX() && this.y == punkt.y;
	}
	
	public String toString() {
		String ausgabe = "Die X-Koordinate des Punktes ist: " + this.x + ", die Y-Koordinate ist: " + this.y;
		return ausgabe;
	}
	
	public void verschiebe(int wert) {
		this.x = this.x + wert;
		this.y += wert;
	}
}
