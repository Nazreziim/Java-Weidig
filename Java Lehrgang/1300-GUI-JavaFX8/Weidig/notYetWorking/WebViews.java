package notYetWorking;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViews extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Erzeugt mein WebView Pane auf dem Seiten dargestellt werden können
		WebView view = new WebView();

		// Ausgetestet: Verhältnisse festlegen -> Nicht sichtbar
		view.setMinWidth(600);
		view.setMinHeight(600);
		// Ausgetestet: Verhältnisse festlegen -> Nicht sichtbar

		WebEngine engine = view.getEngine();

		// Http oder Https probiert -> Nicht sichtbar
		engine.load("http://www.google.com");

		// Anzeige ob der Worker Thread überhaupt läuft --> value = false
		engine.getLoadWorker().runningProperty().addListener(laeuft -> System.out.println(laeuft));

		// Versucht das WebView zu schachteln --> Nicht sichtbar
		VBox vbox = new VBox(view);

		// Ausgetestet: Verhältnisse festlegen -> Nicht sichtbar
		Scene scene = new Scene(vbox, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

		// Dieser Code funktioniert auf dem Privatrechner. Jedoch nicht hier.

		/*
		 * 3.2.3 Built-In Proxy Support
		 * 
		 * Properly packaged JavaFX application have proxy settings initialized
		 * according to Java Runtime configuration settings. By default, this means
		 * proxy settings will be taken from the current browser if the application is
		 * embedded into a web page, or system proxy settings will be used. Proxy
		 * settings are initialized by default in all execution modes.
		 * 
		 * --> Möglicherweise gleicher Zusammenhang wie Zugriff auf marketplace?
		 */
	}

	public static void main(String[] args) {
		launch(args);
	}

}
