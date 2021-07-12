package _005EventsUndBindings;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class _04EventHandlerAndFilter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();

		Circle kreis = new Circle(300, 150, 25, Color.GREEN);
		kreis.setStrokeWidth(20);

		/*********************************************/
		/********* EigeneEventHandler ****************/
		/*********************************************/

		// Anonyme Klasse
		EventHandler<MouseEvent> mouseEventHandlerBlue = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				kreis.setFill(Color.BLUE);
				System.out.println("Kreis: Kreis in Blau");
			}
		};

		// Lambda Ausdruck
		EventHandler<MouseEvent> mouseEventHandlerRed = event -> {
			kreis.setFill(Color.RED);
			System.out.println("Kreis: Kreis in Rot");
		};

		// Durch die Sysouts sieht man sehr schön, dass erst der Filter dann der Handler
		// ausgelöst wird
		kreis.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandlerRed);
		kreis.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventHandlerBlue);

		/*
		 * Zusätzlich den Klick auf den Pane mit anzeigen zur Veranschaulichung des
		 * Targets
		 */

		/*
		 * ACHTUNG: Je nachdem ob Handler oder Filter festgelegt wurde wird der das
		 * Event des Panes am Ende oder am Anfang aufgerufen
		 */
		pane.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
			kreis.setFill(Color.YELLOW);
			System.err.println("Pane: Kreis in Gelb");
			
			//Sorgt dafür, dass das Event aufgenommen wird und weitere Behandlugn verhindert wird
		//	event.consume();
		});
		

		pane.getChildren().add(kreis);
		Scene scene = new Scene(pane, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}

}
