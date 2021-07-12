package _007Multithreading;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

public class _02ScheduledService extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Zeugs laden und initialisieren
		primaryStage.setTitle("Multithreading");
		primaryStage.getIcons().add(new Image("res/ITSBW.png"));
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("_01Multithreading.fxml"));
		Parent fxmlScene = loader.load();
		_01MultithreadingController controller = loader.getController();
		Label threadLabel = controller.getFxThreadLabel();
		Label buttonLabel = controller.getFxButtonLabel();

		Scene scene = new Scene(fxmlScene);
		primaryStage.setScene(scene);
		primaryStage.show();

		/*
		 * Der ScheduledService f�hrt gem. der festgelegten Zeit einen Task aus. Wichtig
		 * ist, dass �nderungen auf dem GUI Thread hier �ber Platform.runlater
		 * ausgef�hrt werden sollten, da die �nderung sonst im Service Thread statt auf
		 * dem GUI Thread passieren und dies dann eine Exception wirft.
		 */
		ScheduledService<String> service = new ScheduledService<String>() {

			@Override
			protected Task<String> createTask() {
				Task<String> z�hlerTask = new Task<String>() {

					@Override
					protected String call() throws Exception {
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								threadLabel.setText(buttonLabel.getText());

							}
						});

						return threadLabel.getText();
					}
				};
				return z�hlerTask;
			}
		};

		/*
		 * Festgelegte Aktualisierungszeit Zeigen wie die Aktualisierung ist wenn man es
		 * auf eine Sekunde �ndert.
		 * 
		 * ACHTUNG: Sensibilisieren f�r Performance (Task Manager zeigen)
		 * 
		 * Deswegen sollte man f�r reine Bewegungen oder Prozesse, welche f�r den Nutzer
		 * sichtbar passieren immer Animationen nutzen, da diese anders verarbeitet
		 * werden. Bindings, Listener etc. sind ebenfalls effizienter als parallel
		 * abfragende Tasks.
		 * 
		 * Klassische Anwendungsf�lle: Serververbindung aufrecht erhalten, Informationen
		 * zwischen Client und Server senden.
		 */

		service.setPeriod(Duration.millis(1));
		service.start();

		// Einmal �ber Autovervollst�ndigung die Liste der Methoden zeigen um zu zeigen
		// welche M�glichkeiten man hier nutzen kann

	}
}
