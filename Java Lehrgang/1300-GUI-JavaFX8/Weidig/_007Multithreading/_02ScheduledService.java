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
		 * Der ScheduledService führt gem. der festgelegten Zeit einen Task aus. Wichtig
		 * ist, dass Änderungen auf dem GUI Thread hier über Platform.runlater
		 * ausgeführt werden sollten, da die Änderung sonst im Service Thread statt auf
		 * dem GUI Thread passieren und dies dann eine Exception wirft.
		 */
		ScheduledService<String> service = new ScheduledService<String>() {

			@Override
			protected Task<String> createTask() {
				Task<String> zählerTask = new Task<String>() {

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
				return zählerTask;
			}
		};

		/*
		 * Festgelegte Aktualisierungszeit Zeigen wie die Aktualisierung ist wenn man es
		 * auf eine Sekunde ändert.
		 * 
		 * ACHTUNG: Sensibilisieren für Performance (Task Manager zeigen)
		 * 
		 * Deswegen sollte man für reine Bewegungen oder Prozesse, welche für den Nutzer
		 * sichtbar passieren immer Animationen nutzen, da diese anders verarbeitet
		 * werden. Bindings, Listener etc. sind ebenfalls effizienter als parallel
		 * abfragende Tasks.
		 * 
		 * Klassische Anwendungsfälle: Serververbindung aufrecht erhalten, Informationen
		 * zwischen Client und Server senden.
		 */

		service.setPeriod(Duration.millis(1));
		service.start();

		// Einmal über Autovervollständigung die Liste der Methoden zeigen um zu zeigen
		// welche Möglichkeiten man hier nutzen kann

	}
}
