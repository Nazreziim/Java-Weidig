/**
 * @author Fw Mütze
 * 26.04.2021
 *
*/
package schneckenrennen;

/**
 * Führt ein Schneckenrennen durch
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
		final Wettbüro wettbüro = new Wettbüro(rennen);
		wettbüro.wetteAnnehmen("Schneckma", 100, "Aaron");
		wettbüro.wetteAnnehmen("Afrodithe", 50, "Aaron");
		wettbüro.wetteAnnehmen("Schleimer", 10, "Aaron");
		wettbüro.wetteAnnehmen("Aaronsko", 70, "Aaron");
		System.out.println(wettbüro);
		wettbüro.rennenDurchfuehren();
	}
}
