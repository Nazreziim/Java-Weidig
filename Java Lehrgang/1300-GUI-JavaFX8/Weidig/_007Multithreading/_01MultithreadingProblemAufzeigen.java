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
		 * 1. Platform.runLater Setzt das Runnable in eine Queue und f�hrt es
		 * "irgendwann" [ja] bzw. sobald der FX Thread dies freigibt das runnable aus.
		 * [z.B. wenn gerade nichts anderes auf den FX Thread zugreift]
		 * 
		 * Dies w�re f�r kleine Probleme eine gute L�sung. Also geringe Anzahl,
		 * jedoch nicht f�r viele Wiederholungen, da die Runnables unseren
		 * GUI Thread zu lange blockieren w�rden. 
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

	/******** 1. Aufzeigem�glichkeit wo die Probleme liegen ********/
	public void stageNonThread(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Multithreading");
		primaryStage.getIcons().add(new Image("res/ITSBW.png"));
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("_01Multithreading.fxml"));
		Parent fxmlScene = loader.load();

		_01MultithreadingController controller = loader.getController();
		Label threadLabel = controller.getFxThreadLabel();

		/*
		 * Es wird jetzt bis zur gegebenen Zahl hochz�hlen und erst dann die Stage
		 * anzeigen --> DAS will man nat�rlich nicht
		 */
		while (Integer.valueOf(threadLabel.getText()) < 1000000000) {
			System.out.println(threadLabel.getText());
			threadLabel.setText(String.valueOf(Integer.valueOf(threadLabel.getText()) + 1));
		}

		/*
		 * Dies wird den Thread zwar starten, jedoch die Zahl hochz�hlen BIS der
		 * GUIThread aktiv ist und somit plump gesagt die Oberhand hat. Die Zahl wird
		 * weiter erh�ht jedoch wird der GUI Thread nicht ver�ndert, somit ist die
		 * Ver�nderung f�r den Nutzer nicht sichtbar ab einem speziellen Punkt. --> Das
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
