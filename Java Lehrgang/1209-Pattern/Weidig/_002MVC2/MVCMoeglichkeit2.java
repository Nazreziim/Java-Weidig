package _002MVC2;


//Erklärung nach Möglichkeit1 selbsterklärend in Verbindung mit der MVC.ppt
public class MVCMoeglichkeit2 {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model);
		
		
		model.setView(view);
		
		controller.start();
	}

}

class Model {
	private int wert;

	private View view;

	public void wertUmEinsErhöhen() {
		this.wert++;
		
		//Benachrichtig View über Änderung
		this.view.aenderung();
		
	}

	// GETTER UND SETTER
	public void setView(View view) {
		this.view = view;
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
		//Holt sich die neuen Informationen aus dem Model
		System.out.println("Neuer Wert: " + this.model.getWert());
	}
}

class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	public void start() {
		//Gibt dem Model den Auftrag zur Zustandsänderung
		for(int i = 0; i < 10; i++) {
			this.model.wertUmEinsErhöhen();
		}
	}
}