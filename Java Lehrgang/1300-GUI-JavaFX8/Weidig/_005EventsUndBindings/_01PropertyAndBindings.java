package _005EventsUndBindings;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class _01PropertyAndBindings extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();

		// 2.Funktionen erzeugen und erklären
		// Fügt ein TextLabel mit dem jeweiligen String hinzu
		Label label = new Label("TEST");
		pane.getChildren().add(label);

		/*********** Binding **************/
		// Nur eine der beiden Methoden

		// CHANGELISTENER METHODE
		Properties prop = new Properties();
		// Typ vom ChangeListener = Object --> Variabel
		// Anforderung an Listener: extends Number
		prop.getWertProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				// Prüfen ob der geänderte Wert auch ein IntegerProperty ist
				label.setText(String.valueOf(prop.getWert()));

			}
		});

		// BIND METHODE
//		label.textProperty().bind(prop.getWertProperty().asString());

		/*********** Binding **************/

		/********** Erstes Event *********/
		Button button = new Button("Buttonbeschreibung");
		// verschiebt den Button
		button.setLayoutY(50);
		pane.getChildren().add(button);

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				prop.setWert(prop.getWert() + 1);

			}
		});

		/*
		 * ACHTUNG: Dies hier funktioniert nur bei einem Mausklick. setOnAction
		 * funktioniert bei allen interagierenden Events z.B. nach Auswahl des Buttons
		 * auch durch Nutzen der Leertaste
		 */
//		button.setOnMouseClicked(event -> prop.setWert(prop.getWert() + 1));
		/********** Erstes Event *********/

		/********* Wechselseitige Bindung *******/
		// Für eine wechselseitige Bindung benötigen wir natürlich einen 2. Faktor
		Slider slider = new Slider();
		slider.setLayoutY(25);
		pane.getChildren().add(slider);

		// Anfangswert
		slider.setValue(50);

		// Bindet zusätzlich an das IntegerProperty eine beidseitige Abhängigkeit
		// SCHÖN: Man sieht, dass dadurch der Wert verändert wird und dies Einfluss
		// auf das Label gleichzeitig hat [Somit eigentlich sogar 3 Abhängigkeiten]
		prop.getWertProperty().bindBidirectional(slider.valueProperty());

		/********* Wechselseitige Bindung *******/

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

//1. Nur Klasse Erstellen
class Properties {
	/*
	 * Klasse IntegerProperty anschauen: Implementiert an irgendeiner Stelle
	 * Oberservable Werte
	 */
	private IntegerProperty wert;

	public int getWert() {
		if (this.wert != null) {
			// .get() holt sich den dahinterliegenden Wert
			return wert.get();
		} else {
			return 0;
		}
	}

	public IntegerProperty getWertProperty() {
		if (this.wert == null) {
			/*
			 * "The constructor of IntegerProperty" Erzeugt das Standard Integer Property
			 * und weist ihm einen Wert zu.
			 * 
			 * --> Aufzeigen was passiert wenn man new IntegerProperty macht
			 */

			wert = new SimpleIntegerProperty(0);
		}

		return wert;
	}

	public void setWert(int wert) {
		// Legt das Property fest
		this.wert.set(wert);
	}
}
