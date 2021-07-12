package _003MVC3;

//Erklärung nach Möglichkeit1 selbsterklärend in Verbindung mit der MVC.ppt
public class MVCMoeglichkeit3 {

	public static void main(String[] args) {

		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model, view);

		model.setController(controller);
		
		controller.start();
	}

}

class Model {
	private int wert;

	private Controller controller;

	public void wertUmEinsErhöhen() {
		this.wert++;

		// Mitteilung: Ich bin fertig
		this.controller.ausgeführt();

	}

	// GETTER UND SETTER
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}
}

class View {

	Model model;

	public View(Model model) {
		this.model = model;
	}

	public void aenderung() {
		// Holt sich die neuen Informationen aus dem Model
		System.out.println("Neuer Wert: " + this.model.getWert());
	}
}

class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void start() {
		// Gibt dem Model den Auftrag zur Zustandsänderung
		for (int i = 0; i < 10; i++) {
			this.model.wertUmEinsErhöhen();
		}
	}

	// Teilt der View den Abschluss der Änderung mit
	public void ausgeführt() {
		System.out.println("Anweisung abgeschlossen.");
		this.view.aenderung();
	}
}