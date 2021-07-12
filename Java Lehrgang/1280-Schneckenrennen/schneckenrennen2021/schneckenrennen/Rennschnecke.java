/**
 * @author Fw Mütze
 * 26.04.2021
 *
*/
package schneckenrennen;

/**
 * Ist eine Klasse, welche die Eigenschaften einer Schnecke darstellt und diese
 * für die Instanziierung innerhalb des Rennens zur Verfügung stellt.
 */
public class Rennschnecke {

	private final String	name;
	private final String	rasse;
	private final double	geschwindigkeit;
	private double			distanz;

	/**
	 * Konstruktor, welcher Namen, Rasse und maximale Geschwindigkeit der Schnecke
	 * übergeben bekommt
	 *
	 * @param name            ist der Name der Schnecke
	 * @param rasse           ist die Rasse der Schnecke
	 * @param geschwindigkeit ist die maximale Geschwindigkeit der Schnecke, die sie
	 *                        zurücklegen kann
	 */
	public Rennschnecke(String name, String rasse, double geschwindigkeit) {
		this.name				= name;
		this.rasse				= rasse;
		this.geschwindigkeit	= geschwindigkeit;
		distanz					= 0;
	}

	/** @return distanz die zurückgelegte Distanz der Schnecke */
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
	 * berechnet einen zufälligen Wert zwischen 1 und der maximalen Geschwindigkeit
	 * und lässt die Schnecke diese Distanz kriechen
	 */
	public void krieche() {
		distanz += (1 + Math.random() * (geschwindigkeit - 1));
	}

	@Override
	public String toString() {
		return "Rennschnecke [name=" + name + ", rasse=" + rasse + ", geschwindigkeit=" + geschwindigkeit + ", distanz=" + distanz + "]";
	}

}
