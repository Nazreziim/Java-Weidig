/**
 * @author Fw M�tze
 * 26.04.2021
 *
*/
package schneckenrennen;

/**
 * Ist eine Klasse, welche die Eigenschaften einer Schnecke darstellt und diese
 * f�r die Instanziierung innerhalb des Rennens zur Verf�gung stellt.
 */
public class Rennschnecke {

	private final String	name;
	private final String	rasse;
	private final double	geschwindigkeit;
	private double			distanz;

	/**
	 * Konstruktor, welcher Namen, Rasse und maximale Geschwindigkeit der Schnecke
	 * �bergeben bekommt
	 *
	 * @param name            ist der Name der Schnecke
	 * @param rasse           ist die Rasse der Schnecke
	 * @param geschwindigkeit ist die maximale Geschwindigkeit der Schnecke, die sie
	 *                        zur�cklegen kann
	 */
	public Rennschnecke(String name, String rasse, double geschwindigkeit) {
		this.name				= name;
		this.rasse				= rasse;
		this.geschwindigkeit	= geschwindigkeit;
		distanz					= 0;
	}

	/** @return distanz die zur�ckgelegte Distanz der Schnecke */
	public double getDistanz() {
		return distanz;
	}

	/** @return name der Name der Schnecke */
	public String getName() {
		return name;
	}

	/** @return rasse die Rasse der Schnecke */
	public String getRasse() {
		return rasse;
	}

	/**
	 * berechnet einen zuf�lligen Wert zwischen 1 und der maximalen Geschwindigkeit
	 * und l�sst die Schnecke diese Distanz kriechen
	 */
	public void krieche() {
		distanz += (1 + Math.random() * (geschwindigkeit - 1));
	}

	@Override
	public String toString() {
		return "Rennschnecke [name=" + name + ", rasse=" + rasse + ", geschwindigkeit=" + geschwindigkeit + ", distanz=" + distanz + "]";
	}

}
