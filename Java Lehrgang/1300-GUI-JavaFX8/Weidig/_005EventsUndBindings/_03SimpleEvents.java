package _005EventsUndBindings;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class _03SimpleEvents extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		/*********************************************/
		/***************** KeyEvent ******************/
		/*********************************************/

		TextField textField = new TextField("HIER STEHT GANZ VIEL TEXT");

		/*
		 * Welches Node soll ein Event haben? --> TextField Was f�r ein Event ist das?
		 * --> Eine Taste wird gedr�ckt Wer k�mmert sich um das Event? --> neuer
		 * EventHandler mit Typen KeyEvents
		 * 
		 * ACHTUNG: Das Event muss nat�rlich irgendwie �berhaupt ausl�sbar sein. Ein
		 * Tastendruck auf einem Pane, einem Label o.�. wird nicht registriert.
		 */
		textField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				System.out.println("KeyCode: " + event.getCode());
				System.out.println("EingabeText: " + event.getText());

			}

		});
		
		//Lambda
		textField.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			{
				System.out.println("KeyCode: " + event.getCode());
				System.out.println("EingabeText: " + event.getText());
			}
		});

		/*
		 * !!! M�chte ich den gleichen EventHandler wieder verwenden muss ich diesen
		 * (logischerweise) als Objekt o.�. externalisieren !!!
		 */

		// Lambda M�glichkeit - Mehrzeilig
		textField.setOnKeyPressed(event -> {
			System.out.println("EingabeText: " + event.getText());
			System.out.println("KeyCode: " + event.getCode());
		});

		// Lambda M�glichkeit - Einzeilig
		textField.setOnKeyReleased(event -> System.out.println("Taste wurde losgelassen"));

		/*********************************************/
		/***************** MouseEvent ****************/
		/*********************************************/

		textField.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// Zeigt die Anzahl der Klicks an und resettet sich nach einer Zeit
				// Hiermit wird z.B. ein Doppeltklick registriert
				System.out.println("Anzahl Klicks: " + event.getClickCount());

				// Gibt die Mausposition bezogen auf das darunterliegende Element aus.
				System.out.println("Position der Maus: " + event.getScreenX() + " / " + event.getSceneY());

				System.out.println("Position der Maus: " + event.getScreenX() + " / " + event.getScreenY());

			}
		});

		Scene scene = new Scene(textField);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
