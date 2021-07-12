/**
 * @author Fw Mütze
 * 26.04.2021
 *
*/
package schneckenrennen;

/**
 * Simuliert ein Schneckenrennen
 */
public class Rennen {

	private final String	name;
	private Rennschnecke[]	schnecken;
	private final int		pathLength;
	private Rennschnecke[]	gewinner;

	/**
	 * Default-Konstruktor, welcher den Namen des Rennens und die zurückzulegende
	 * Strecke als Parameter übergeben bekommt.
	 *
	 * @param name       ist der Name des Rennens
	 * @param pathLength ist die zurückzulegende Strecke
	 */
	public Rennen(String name, int pathLength) {
		this.name		= name;
		this.pathLength	= pathLength;
		schnecken		= new Rennschnecke[0];
	}

	/**
	 * Erweitert das Array mit den Schnecken um eins und fügt die neue Schnecke am
	 * Ende hinzu
	 *
	 * @param neueSchnecke ist die neue Schnecke
	 */
	public void addRennschnecke(Rennschnecke neueSchnecke) {
		for (final Rennschnecke schnecke : schnecken)
			if (schnecke.getName().equals(neueSchnecke.getName()))
				return;

		final Rennschnecke[] out = new Rennschnecke[schnecken.length + 1];
		for (int i = 0; i < schnecken.length; i++)
			out[i] = schnecken[i];
		out[schnecken.length]	= neueSchnecke;
		schnecken				= out;
	}

	/** führt das gesammte Rennen durch, bis ein Gewinner ermittelt werden konnte */
	public void durchfuehren() {
		final int space = (int) Math.round((pathLength - (name.length() - 12)) / 2.0);
		System.out.printf("%" + space + "s%s%" + space + "s%n", "", name, "");
		gewinner = null;
		while (gewinner == null) {
			lasseSchneckenKriechen();
			System.out.println(this);
			gewinner = ermittleGewinner();
		}
		for (final Rennschnecke element : gewinner)
			if (element != null)
				System.out.println("Gewinner: " + element.getName() + " aus der Klasse der " + element.getRasse() + "n");
	}

	/**
	 * @return gewinner[] die die Ziellinie überschritten haben - ALLE!!!
	 */
	public Rennschnecke[] ermittleGewinner() {
		final Rennschnecke[]	gewinner	= new Rennschnecke[schnecken.length];
		int						anzahl		= 0;
		for (int i = 0; i < schnecken.length; i++)
			if (schnecken[i].getDistanz() >= pathLength) {
				gewinner[i] = schnecken[i];
				anzahl++;
			}
		return anzahl > 0 ? gewinner : null;
	}

	/** @return gewinner sind die Gewinner des Rennens */
	public Rennschnecke[] getGewinner() {
		return gewinner;
	}

	/** @return schnecken die Schnecken des Rennens */
	public Rennschnecke[] getSchnecken() {
		return schnecken;
	}

	/** Lässt alle Schnecken einmal kriechen */
	public void lasseSchneckenKriechen() {
		for (final Rennschnecke schnecke : schnecken)
			schnecke.krieche();
	}

	/**
	 * Kürzt das Array um eins, falls eine zu entfernende Schnecke gefunden wurde.
	 * Ansonsten wird das Programm vorzeitig beendet;
	 *
	 * @param name ist der Name der Schnecke
	 */
	public void removeRennschnecke(String name) {
		// Unnötige Schnecke herausfiltern
		int pos = -1;
		for (int i = 0; i < schnecken.length; i++)
			if (schnecken[i].getName().equals(name)) {
				pos = i;
				break;
			}
		// Falls keine Schnecke gefunden wurde
		if (pos == -1)
			return;
		// Unnötige Schnecke entfernen
		for (int i = pos; i < schnecken.length - 1; i++)
			schnecken[i] = schnecken[i + 1];

		// Array einkürzen
		final Rennschnecke[] out = new Rennschnecke[schnecken.length - 1];
		for (int i = 0; i < out.length; i++)
			out[i] = schnecken[i];
		schnecken = out;
	}

	@Override
	public String toString() {
		final StringBuilder out = new StringBuilder();
		for (final Rennschnecke schnecke : schnecken) {
			out.append(String.format("%12s:", schnecke.getName()));
			out.append(schnecke.getDistanz() > 0 ? String.format("%" + schnecke.getDistanz() + "s", "").replace(" ", "-") : "");
			out.append(pathLength - schnecke.getDistanz() >= 1 ? String.format("%" + (pathLength - schnecke.getDistanz()) + "s%n", "").replace(" ", "o") : "\n");
		}
		return out.toString();
	}

}
