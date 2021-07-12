package basic.version6;

import java.util.List;

public class Controller {

	private ZahlEinfach model;
	private List<View> views;

	public Controller(ZahlEinfach model, List<View> views) {
		super();
		this.model = model;
		this.views = views;
	}

	public void start() {

		for (int i = 0; i < 5; ++i) {
			// Daten werden aktualisiert
			model.increment();

			// Ausgaben generieren in unterschiedlicher Form
			for (View view : views) {
				view.ausgabe();
			}

		}

		// Daten werden aktualisiert
		model.sub(3);

		// Ausgaben generieren in unterschiedlicher Form
		for (View view : views) {
			view.ausgabe();
		}

		// Daten werden aktualisiert
		model.add(100);

		// Ausgaben generieren in unterschiedlicher Form
		for (View view : views) {
			view.ausgabe();
		}

	}
}
