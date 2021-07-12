package b1Kapselung;

/**
 * Die Klasse Punkt  
 */
class Punkt {

	/**
	 * Attribut, bzw. globale Variable für die X-Koordinate
	 */
	private int x;
	
	/**
	 * Attribut, bzw. globale Variable für die Y-Koordinate
	 */
	private int y;
	
	/**
	 * Konstruktor - ohne Parameter
	 */
	public Punkt() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Konstruktor - mit Parameter
	 * X und Y erhalten den Wert wert
	 */
	public Punkt(int wert) {
		this.x = wert;
		this.y = wert;
	}
	
	/**
	 * Konstruktor - mit Parameter
	 */
	public Punkt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Getter für das Attribut x
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Getter für das Attribut y
	 */
	public int getY() {
		return this.y;
	}
	
	public void verschiebeZu(int x, int y) {
		if (x >= 0 && x <= 10) {
			this.x = x;
		}
		if (y >= 0 && y <= 10) {
			this.y = y;
		}
	}
	
	/**
	 * Verschiebt Punkt um angegebene Kooridinaten, wenn er noch im Spielfeld ist.
	 * Beide Werte werden überprüft und die Verschiebung nur durchgeführt, wenn die Attribute im gültigen bereich liegen.
	 */
	public void verschiebeUm(int x, int y) {
		System.out.println("Ich werde verschoben.");
		if ((this.x + x <= 10 && this.x + x >= 0) && (this.y + y <= 10 && this.y + y >= 0)) {
			this.x = this.x + x;
			this.y = this.y + y;
		}
	}
	
	/**
	 * Verschiebt Punkt um die Kooridinaten des angegeben Punktes.
	 * Dabei wird die bereits bestehende Methode aufgerufen.
	 */
	public void verschiebeUm(Punkt p) {
		this.verschiebeUm(p.getX(),p.getY());
		//this.x = this.x + p.getX();
		//this.y = this.y + p.getY();
	}

	public String toString() {
		return "(" + this.getX() + "," + this.y + ")";
	}
	
	public static void main(String[] args) {
		// Nutzung annonymer Konstruktor
		Punkt p1 = new Punkt();
		System.out.println(p1.getX());
		System.out.println(p1.getY());
		
		// Nutzung Konstruktor mit Parametern
		Punkt p2 = new Punkt(10,10);
		System.out.println(p2.getX());
		System.out.println(p2.getY());
		
		// Nutzung Konstruktor, der sich auf anderen Konstruktor abstützt
		Punkt p3 = new Punkt(5);
		System.out.println(p3.getX());
		System.out.println(p3.getY());
		
		// Nutzung einer Methode mit Parametern
		p3.verschiebeZu(15,6);		
		System.out.println(p3.getX());
		System.out.println(p3.getY());
		
		// Nutzung einer Methode mit Parametern, welche Bedingungen prüft
		p3.verschiebeUm(7,4);		
		System.out.println(p3.getX());
		System.out.println(p3.getY());

		// Nutzung einer Methode, die sich auf eine andere Methode abstützt 
		// und eine Objektreferenz als Parameter nutzt
		p3.verschiebeUm(p2);		
		System.out.println(p3.getX());
		System.out.println(p3.getY());
		
		//Verkettung von Ausdrücken
		System.out.println(p3);
		System.out.println(p3.toString().length() * 5);
		String s = p3.toString();
		int stellen = s.length();
		int erg = 5 * stellen;
		
		//Nutzung einer Objektreferenz in zwei Variablen
		Punkt p5 = new Punkt(5,5);
		Punkt p6 = p5;
		System.out.println(p6);
		p6.verschiebeUm(1,1);
		System.out.println(p5);
	}
}