package _006Controls.standard;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DirectoryChoosers extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Bildschirm
		Button button = new Button("Verzeichnis ausw�hlen");
		VBox vBox = new VBox(button);
		Scene scene = new Scene(vBox);
		primaryStage.setScene(scene);
		primaryStage.show();
		// Bildschirm

		// Chooser ausw�hlen
		DirectoryChooser chooser = new DirectoryChooser();

		button.setOnAction(e -> {

			// Dialog anzeigen lassen. showDialog gibt ebenfalls die ausgew�hlte File
			// zur�ck.
			File ausgewaehltesVerzeichnis = chooser.showDialog(primaryStage);

			System.out.println(ausgewaehltesVerzeichnis.getAbsolutePath());
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}
