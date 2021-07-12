package _001LebenszyklusUndAufbau;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

//1. extends Application
public class _01Lebenszyklus extends Application {

	//Läuft auf dem Main Thread
	public static void main(String[] args) {
		System.out.println("Vor dem Launch");
		
		// 3. Diese Methode MUSS zum Starten der Applikation vorhanden sein
		launch(args);
		
		System.out.println("Nach dem Launch");

	}

	// Läuft auf dem JavaFX Launcher Thread, NICHT auf JavaFX Application Thread
	// Deshalb hier keine Stage, Scene etc. erstellen. Alle anderen
	// JavaFX Elemente sind erlaubt
	@Override
	public void init() throws Exception {
		System.out.println("Init Methode");
	}

	// 2. Diese Methode muss implementiert werden
	// Ab hier beginnt der Application Thread
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Ich befinde mich in der start Methode");
		
		//Application schließen --> stop() wird aufgerufen
		Platform.exit();
		
		//Prozess terminieren --> stop() wird nicht aufgerufen
	//	System.exit(1);
	}

	//Nach dem Aufruf dieser Methode stoppt der Application Thread
	@Override
	public void stop() throws Exception {
		System.out.println("Stop Methode");
	}

}
