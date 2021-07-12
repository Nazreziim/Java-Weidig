package _007Multithreading;

import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class _01MultithreadingProblemAufzeigen extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Szene: NonThread(1) / MultiThread(2)");
		Scanner sc = new Scanner(System.in);

		String auswahl = sc.next();

		if (auswahl.equals("1")) {
			stageNonThread(primaryStage);
		} else {
			stageThread(primaryStage);
		}

		sc.close();

	}

	private void stageThread(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Multithreading");
		primaryStage.getIcons().add(new Image("res/ITSBW.png"));
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("_01Multithreading.fxml"));
		Parent fxmlScene = loader.load();
		_01MultithreadingController controller = loader.getController();
		Label threadLabel = controller.getFxThreadLabel();

		Scene scene = new Scene(fxmlScene);
		primaryStage.setScene(scene);
		primaryStage.show();

		/*
		 * 1. Platform.runLater Setzt das Runnable in eine Queue und führt es
		 * "irgendwann" [ja] bzw. sobald der FX Thread dies freigibt das runnable aus.
		 * [z.B. wenn gerade nichts anderes auf den FX Thread zugreift]
		 * 
		 * Dies wäre für kleine Probleme eine gute Lösung. Also geringe Anzahl,
		 * jedoch nicht für viele Wiederholungen, da die Runnables unseren
		 * GUI Thread zu lange blockieren würden. 
		 * 
		 * Man kann sich dies wie eine kurzzeitige Abzweigung aus dem GUI Thread
		 * vorstellen. Ist man zu lange in der Abzweigung ist der Hauptthread
		 * quasi blockiert.
		 */

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						while (Integer.valueOf(threadLabel.getText()) < 10000) {
							System.out.println(threadLabel.getText());
							threadLabel.setText(String.valueOf(Integer.valueOf(threadLabel.getText()) + 1));
						}

					}
				});

			}
		});

		thread.start();

	}

	public static void main(String[] args) {
		launch(args);
	}

	/******** 1. Aufzeigemöglichkeit wo die Probleme liegen ********/
	public void stageNonThread(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Multithreading");
		primaryStage.getIcons().add(new Image("res/ITSBW.png"));
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("_01Multithreading.fxml"));
		Parent fxmlScene = loader.load();

		_01MultithreadingController controller = loader.getController();
		Label threadLabel = controller.getFxThreadLabel();

		/*
		 * Es wird jetzt bis zur gegebenen Zahl hochzählen und erst dann die Stage
		 * anzeigen --> DAS will man natürlich nicht
		 */
		while (Integer.valueOf(threadLabel.getText()) < 1000000000) {
			System.out.println(threadLabel.getText());
			threadLabel.setText(String.valueOf(Integer.valueOf(threadLabel.getText()) + 1));
		}

		/*
		 * Dies wird den Thread zwar starten, jedoch die Zahl hochzählen BIS der
		 * GUIThread aktiv ist und somit plump gesagt die Oberhand hat. Die Zahl wird
		 * weiter erhöht jedoch wird der GUI Thread nicht verändert, somit ist die
		 * Veränderung für den Nutzer nicht sichtbar ab einem speziellen Punkt. --> Das
		 * will man erst Recht nicht!
		 */
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (Integer.valueOf(threadLabel.getText()) < 1000000000) {
					System.out.println(threadLabel.getText());
					threadLabel.setText(String.valueOf(Integer.valueOf(threadLabel.getText()) + 1));
				}
			}
		});

		thread.start();

		Scene scene = new Scene(fxmlScene);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
