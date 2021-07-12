package listen.polynom;

public class PolyGlied {
	private int exponent;
	private double koeffizient;
	private PolyGlied naechster;
	
	/**
	 * Konstruktor der Klasse
	 * @param exponent		Exponent des Polynoms
	 * @param koeffizient	Koeffizient des Polynoms
	 * @param naechster		Naechstes Listenelement
	 */
	public PolyGlied(int exponent, double koeffizient, PolyGlied naechster) {
		super();
		this.exponent = exponent;
		this.koeffizient = koeffizient;
		this.naechster = naechster;
	}

	/**
	 * Konstruktor der Klasse
	 * @param exponent		Exponent des Polynoms
	 * @param koeffizient	Koeffizient des Polynoms
	 */
	public PolyGlied(int exponent, double koeffizient) {
		this(exponent, koeffizient, null);
	}
	
	/**
	 * Getter-Methode gibt das Nachfolgeelement zurueck.
	 * @return	PolyGlied
	 */
	public PolyGlied getNaechster() {
		return naechster;
	}

	/**
	 * Setter-Methode setzt das Nachfolgeelement.
	 * @param naechster	PolyGlied
	 */
	public void setNaechster(PolyGlied naechster) {
		this.naechster = naechster;
	}

	/**
	 * Getter-Methode gibt den Exponent zurueck.
	 * @return	int 
	 */
	public int getExponent() {
		return exponent;
	}

	/**
	 * Getter-Methode gibt den Koeffizient zurueck.
	 * @return
	 */
	public double getKoeffizient() {
		return koeffizient;
	}

	/**
	 * Setter-Methode setzt den Koeffizient des PolyGlieds.
	 * @param koeffizient	Koeffizient
	 */
	public void setKoeffizient(double koeffizient) {
		this.koeffizient = koeffizient;
	}
	
	
	@Override
	public String toString() {
		return "PolyGlied [exponent=" + exponent + ", koeffizient=" + koeffizient + "]";
	}
	
	
}
