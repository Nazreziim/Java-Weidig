package _001LebenszyklusUndAufbau;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/*
 * Diese Datei bezugnehmend auf die start() Methode
 * von oben nach unten durchgehen. primaryStage.show()
 * entsprechend der Veranschaulichung verschieben.
 */


public class _02StageSceneNode extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("Init Methode");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Ich befinde mich in der start Methode");

		/**************** Stage *****************/

		/*
		 * Zusatzfunktionen
		 * 
		 * Alle Änderungen nachdem .show aufgerufen wurden passieren auch nach der
		 * eigentlichen Anzeige.
		 * 
		 * Alle Änderungen die davor passieren werden somit erst festgelegt und dann
		 * über .show angezeigt
		 * 
		 * [ACHTUNG: Kann Fehler verursachen wenn man nach .show nochmals die Stage
		 * ändert]
		 */

		// Nicht in Größe veränderbar [Aufzeigen, dass Größe der Stage = Größe des
		// nutzbaren Bereiches]
//		primaryStage.setResizable(false);

		// Titel festlegen
		primaryStage.setTitle("HelloWorld Fenster");

		// Jede neue Stage = komplett neues Fenster
//		Stage stage = new Stage();
//		stage.show();

		// Legt Höhe und Breite des kompletten Fensters fest
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);

		/* Styles 
		 * Es gibt verschiedene festgelegte Styles
		 * die über das ENUM StageStyle. aufgerufen
		 * werden können und systemabhängig sind.
		 */
		primaryStage.initStyle(StageStyle.DECORATED);
//		primaryStage.initStyle(StageStyle.UTILITY);

		

		/**************** Scene und Pane *****************/
		// Das Erzeugen der Scene erwartet eine Node, damit bekannt ist worauf die Scene
		// überhaupt etwas darstellt.
		Pane pane = new Pane(); // = Node
		pane.setMinSize(200, 200);
		
		//Möglichkeit 1 [Komplex]
		pane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		//Möglichkeit 2 [CSS]
		pane.setStyle("-fx-background-color: red");
		
		//Möglichkeit 3 [CSS mit rgba] --> So erreicht man auch transparenz
		//--> Google --> RGBA Generator
		//--> Aufzeigen wie Transparenz gezeigt wird [scene.setFill aktiviert und deaktiviert nebeneinander]
		pane.setStyle("-fx-background-color: rgba(255, 67, 213, 0.5)");
		
		Scene scene = new Scene(pane); // Scene
		scene.setFill(Color.RED); // Import der Color. von javax.scene.paint.Color
		
		//Hinzufügen der Scene zur Stage
		primaryStage.setScene(scene); 
		
		/* Aufzeigen:
		 * Unterschied .setScene nach .show und davor
		 */
		
		// Zeigt das Fenster an
		primaryStage.show();
	}

	// ACHTUNG: Aufzeigen, dass stop() erst aufgerufen wird wenn ALLE Fenster
	// geschlossen werden
	@Override
	public void stop() throws Exception {
		System.out.println("Stop Methode");
		super.stop();
	}

}
