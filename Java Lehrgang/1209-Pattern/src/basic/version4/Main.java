package basic.version4;

public class Main {

	public static void main(String[] args) {

		ZahlEinfach model = new ZahlEinfach();
		ViewDezimal viewDezimal = new ViewDezimal(model);
		ViewStern viewStern = new ViewStern(model);

		for (int i = 0; i < 5; ++i) {
			// Daten werden aktualisiert
			model.increment();

			// Ausgaben generieren in unterschiedlicher Form
			// Textausgabe
			viewDezimal.ausgabe();

			// grafische Ausgabe
			viewStern.ausgabe();
		}

		// Daten werden aktualisiert
		model.sub(3);
		// Ausgaben generieren in unterschiedlicher Form
		// Textausgabe
		viewDezimal.ausgabe();

		// grafische Ausgabe
		viewStern.ausgabe();

		// Daten werden aktualisiert
		model.add(100);

		// Ausgaben generieren in unterschiedlicher Form
		// Textausgabe
		viewDezimal.ausgabe();

		// grafische Ausgabe
		viewStern.ausgabe();

	}

}
