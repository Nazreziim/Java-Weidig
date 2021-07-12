/**
 * @author Fw M�tze
 * 26.04.2021
 *
*/
package schneckenrennen;

/**
 * Ist ein Wette, welche aufgrund der Lizenzbeschr�nkungen im Land Deutschland
 * so eingeschr�nkt ist, dass sie nur in Schleswig-Holstein abgeschlossen werden
 * darf.
 */
public class Wette {

	private final Rennschnecke	schnecke;
	private final int			geld;
	private final int			faktor;
	private final String		spieler;

	/**
	 * Konstruktor, welcher die Schnecke, den Einsatz und den damit verbundenen
	 * Gewinnfaktor �bergeben bekommt
	 *
	 * @param schnecke ist die Schnecke, auf die gewettet wird
	 * @param geld     ist der Wetteinsatz
	 * @param faktor   ist der Faktor, welcher mit dem Einsatz mulitpliziert wird,
	 *                 falls die Schnecke gewinnt
	 * @param spieler  ist der Spieler, welcher die Wette abgeschlossen hat
	 */
	public Wette(Rennschnecke schnecke, int geld, String spieler) {
		this.schnecke	= schnecke;
		this.geld		= geld;
		this.spieler	= spieler;
		faktor			= 4;
	}

	/** @return gibt den Gewinn zur�ck */
	public int getGewinn() {
		return geld * faktor;
	}

	/** @return gibt die Schnecke zur�ck */
	public Rennschnecke getSchnecke() {
		return schnecke;
	}

	/** @return gibt den Spieler zur�ck */
	public String getSpieler() {
		return spieler;
	}

	@Override
	public String toString() {
		return spieler + " wettet, dass " + schnecke.getName() + " das Rennen gewinnt und verwettet daf�r " + geld + "�.";
	}

}
