/**
 * @author Fw M�tze
 * 26.04.2021
 *
*/
package schneckenrennen;

/**
 * F�hrt ein Schneckenrennen durch
 */
public class SchneckenrennenTest {

	/**
	 * Launch
	 *
	 * @param args brauchen wir eh nicht
	 */
	public static void main(String[] args) {
		final Rennen rennen = new Rennen("Test", 30);
		rennen.addRennschnecke(new Rennschnecke("Schneckma", "Stinkerschnecke", 5.7));
		rennen.addRennschnecke(new Rennschnecke("Afrodithe", "Liebesschnecke", 4.9));
		rennen.addRennschnecke(new Rennschnecke("Car-los", "Eischnecke", 4.9));
		rennen.addRennschnecke(new Rennschnecke("Homeless", "Nacktschnecke", 5.7));
		rennen.addRennschnecke(new Rennschnecke("Homeless", "Nacktschnecke", 5.7));
		rennen.addRennschnecke(new Rennschnecke("Sternchen", "Apfelschnecke", 4.9));
		rennen.addRennschnecke(new Rennschnecke("Schleimer", "Eischnecke", 3.1));
		rennen.addRennschnecke(new Rennschnecke("Black Widow", "Todesschnecke", 4.8));
		rennen.addRennschnecke(new Rennschnecke("Aaronsko", "Schleimerschnecke", 5));
		final Wettb�ro wettb�ro = new Wettb�ro(rennen);
		wettb�ro.wetteAnnehmen("Schneckma", 100, "Aaron");
		wettb�ro.wetteAnnehmen("Afrodithe", 50, "Aaron");
		wettb�ro.wetteAnnehmen("Schleimer", 10, "Aaron");
		wettb�ro.wetteAnnehmen("Aaronsko", 70, "Aaron");
		System.out.println(wettb�ro);
		wettb�ro.rennenDurchfuehren();
	}
}
