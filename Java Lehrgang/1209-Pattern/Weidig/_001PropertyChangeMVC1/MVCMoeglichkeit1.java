package _001PropertyChangeMVC1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MVCMoeglichkeit1 {
	// Immer eine Klasse die über die Main Methode zum Starten verfügt

	public static void main(String[] args) {
		// Wir müssen einmal alle benötigten Klassen erstellen. Damit die
		// Konstruktoraufrufe auch stattfinden. Selbst wenn diese selbst nicht genutzt
		// werden.
		Model model1 = new Model();
		View view1 = new View(model1);

		Controller c = new Controller(model1, view1);
		c.start();

	}

}

class Model {
	/*****
	 * Model ****** - Komplette Fachlogik - Algorithmen für Zustandsänderungen
	 * Beispiel (Schiffe versenken): - Setzen von Schiffen - Schießen auf Koordinate
	 ******************/

	// Kommuniziert über PCS mit der View ohne diese zu kennen
	private int wert = 0;
	private PropertyChangeSupport pcs;

	public Model() {
		// Gibt an für wen der "PropertyChangeSupport" vorhanden sein soll. In diesem
		// Fall für "diese" (this) Klasse
		this.pcs = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}

	public void wertUmEinsErhöhen() {
		// aktuellen Zustand zwischenspeichern
		int alterWert = this.wert;

		// Zustandsänderung
		this.wert++;

		// "Feuert" ein PropertyChangeEvent
		this.pcs.firePropertyChange("Methode: wertUmEinsErhöhen", alterWert, this.wert);
	}
	
	public void funktioniert() {
		System.out.println("Zugriff hat funktioniert.");
	}

	// GETTER UND SETTER
	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

}

class View implements PropertyChangeListener {
	/*****
	 * View ****** - Darstellung eines Models - Muss sich immer dann ändern, wenn
	 * sich der Zustand des Models geändert hat Beispiel (Schiffe versenken) -
	 * Setzen eines Schiffes = Anzeige des Schiffes - Zerstören eines Schiffes =
	 * Keine Anzeige des zerstören Schiffs
	 ******************/
	// Besitzt das Model das angezeigt werden soll
	private Model model;

	// Zuweisen des zuständigen Models im Konstruktor
	public View(Model model) {
		this.model = model;

		// Dem Model einen PropertyChangeListener zuweisen
		// [Die Klasse in der das passiert ist egal. Es geht um den Zugriff auf die
		// Funktionalität]
		// ACHTUNG: Darauf hinweisen, dass PCL ein Interface ist
		// --> Mit strg + Linksklick aufzeigen welche Methoden im PCL Interface sind
		this.model.addPropertyChangeListener(new PropertyChangeListener() {

			/*
			 * Möglichkeit 1: nur für diesen Zustand innerhalb der Klasse die Methode zu
			 * implementieren --> DIES NENNT MAN ANONYME KLASSE Interessant: Man kann auf
			 * Methoden der erzeugenden Klasse etc. zugreifen, obwohl man meinen könnte es
			 * wäre eine externe Instanz.
			 */
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// MAN DARF KEIN this. benutzen!
				// Dies wäre eine Referenz auf Werte der anonymen Klasse
				
				//Gibt den vorher zugewiesenen Namen zum firePropertyChange
				System.out.println("Eventursprung: "+evt.getPropertyName());
				
				//Gibt die Inhalte des Events
				System.out.println("Alter Wert: " +evt.getOldValue());
				System.out.println("Neuer Wert: " +evt.getNewValue());
				
				//Ich kann das Quellobjekt erhalten und dieses nutzen
				Model model = (Model) evt.getSource();
				model.funktioniert();
				
				//Methode aus der Definitionsklasse nutzen
				show();
				

			}
		});

		// Zu Möglichkeit 3:
		// this.model.addPropertyChangeListener(this);
	}

	public void showStart() {
		System.out.println("Herzlich willkommen! Die Zahl des Models beträgt aktuell: " + model.getWert());
	}

	public void showEnd() {
		System.out.println("Das Ende ist erreicht! Die Zahl des Models beträgt zum Ende: " + model.getWert());
	}

	// Irgendeine Methode die für die Anzeige zuständig ist
	public void show() {
		System.out.println(model.getWert());
	}

	/*
	 * Möglichkeit 3: Das Interface PCL implementieren, die Methode überschreiben
	 * und überall wo ein PCL gebraucht wird this angeben.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// Hier ist this. natürlich wieder möglich
		this.show();

	}

}

//Möglichkeit 2: Ein Interface zu erstellen, dass PCL erbt [somit auch einer ist]
//ACHTUNG: Wichtige Methoden werden einem dann nicht angezeigt sondern müssen
//entweder im Interface als default überschrieben werden oder dann in der Klasse
//wie beim normalen Interface implementiert werden.
interface VPCL extends PropertyChangeListener {

}

class Controller {
	/*****
	 * Controller ****** - Steuerung des Fachsystems - Gibt z.B. Model Anstoß zur
	 * Zustandsänderung Beispiel (Schiffe versenken): - Aufforderung an Spieler neue
	 * Zielkoordinate einzugeben --> ACHTUNG: Nur den Aufruf der Methode. Die
	 * Anzeige, die den Spieler dazu aufruft befindet sich in der View.
	 ******************/

	// Controller kennt model und view
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void start() {
		view.showStart();
		for (int i = 0; i < 10; i++) {
			this.model.wertUmEinsErhöhen();
			// Ohne den Propertychange müssten wir hiernach der View erst mitteilen, dass
			// sich jetzt etwas geändert hat
		}

		view.showEnd();
	}

}