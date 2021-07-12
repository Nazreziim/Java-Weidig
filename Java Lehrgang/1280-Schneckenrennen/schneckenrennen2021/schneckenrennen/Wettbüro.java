/**
 * @author Fw Mütze
 * 26.04.2021
 *
*/
package schneckenrennen;

/**
 * Erlaubt das Glücksspiel auf das Rennen der Schnecken. Gilt nur für Einwohner
 * in Schleswig-Holstein
 */
public class Wettbüro {

	private final Rennen	rennen;
	private Wette[]			wetten;

	/**
	 * Der Kosntruktor legt fest, auf welches Rennen gewettet werden darf
	 *
	 * @param rennen ist das Rennen, auf welches gewettet wird
	 */
	public Wettbüro(Rennen rennen) {
		this.rennen	= rennen;
		wetten		= new Wette[0];
	}

	private String getGewinne() {
		final StringBuilder		out			= new StringBuilder();
		final Rennschnecke[]	gewinner	= rennen.getGewinner();

		for (final Rennschnecke gewinnTest : gewinner)
			if (gewinnTest != null)
				for (final Wette wette : wetten)
					if (wette.getSchnecke().getName().equals(gewinnTest.getName()))
						out.append(String.format("%s hat mit einer Wette auf %s %d€ gewonnen.%n", wette.getSpieler(), gewinnTest.getName(), wette.getGewinn()));

		return out.toString();
	}

	/** führt das Rennen durch */
	public void rennenDurchfuehren() {
		rennen.durchfuehren();
		System.out.println(getGewinne());
	}

	@Override
	public String toString() {
		final StringBuilder out = new StringBuilder();

		for (final Wette wette : wetten)
			out.append(wette + "\n");

		return out.toString();
	}

	/**
	 * Nimmt eine Wette an und fügt sie dem Pool/Array an Wetten hinzu
	 *
	 * @param schneckenName Name der Schnecke, auf die gewettet werden soll
	 * @param wettEinsatz   Höhe des Wetteinsatzes
	 * @param spieler       ist der Name des Spielers
	 */
	public void wetteAnnehmen(String schneckenName, int wettEinsatz, String spieler) {
		final Rennschnecke[]	schnecken		= rennen.getSchnecken();
		Rennschnecke			wettschnecke	= null;
		for (final Rennschnecke schnecke : schnecken)
			if (schnecke.getName().equals(schneckenName)) {
				wettschnecke = schnecke;
				break;
			}
		if (wettEinsatz > 0) {
			final Wette		wette	= new Wette(wettschnecke, wettEinsatz, spieler);
			final Wette[]	out		= new Wette[wetten.length + 1];
			for (int i = 0; i < wetten.length; i++)
				out[i] = wetten[i];
			out[wetten.length]	= wette;
			wetten				= out;
		}
	}
}
