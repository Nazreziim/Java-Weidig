package basic.version3;

public class Main {

	public static void main(String[] args) {

		ZahlEinfach model = new ZahlEinfach();
		View view = new View(model);

		for (int i = 0; i < 5; ++i) {
			// Daten werden aktualisiert
			model.increment();

			// Ausgaben generieren in unterschiedlicher Form
			// Textausgabe
			view.ausgabeText();

			// grafische Ausgabe
			view.ausgabeStern();
		}

		// Daten werden aktualisiert
		model.sub(3);
		// Ausgaben generieren in unterschiedlicher Form
		// Textausgabe
		view.ausgabeText();

		// grafische Ausgabe
		view.ausgabeStern();

		// Daten werden aktualisiert
		model.add(100);

		// Ausgaben generieren in unterschiedlicher Form
		// Textausgabe
		view.ausgabeText();

		// grafische Ausgabe
		view.ausgabeStern();

	}

}
