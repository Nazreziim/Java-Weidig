package _006Controls.standard;

import java.io.File;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChoosers extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Bildschirm
		Button button = new Button("Eine Datei ausw�hlen");
		Button button2 = new Button("Mehrere Dateien ausw�hlen");
		Button button3 = new Button("Eine Datei ausw�hlen");
		VBox vBox = new VBox(button, button2, button3);
		Scene scene = new Scene(vBox);
		primaryStage.setScene(scene);
		primaryStage.show();
		// Bildschirm

		FileChooser chooser = new FileChooser();

		// F�r eine Datei
		button.setOnAction(e -> {

			// Dialog anzeigen lassen. showDialog gibt ebenfalls die ausgew�hlte File
			// zur�ck.
			File ausgewaehlteDatei = chooser.showOpenDialog(primaryStage);

			if (ausgewaehlteDatei != null) {
				System.out.println(ausgewaehlteDatei.getAbsolutePath());
			}
		});

		// F�r mehrere Dateien
		button2.setOnAction(e -> {
			List<File> ausgewaehlteDatei = chooser.showOpenMultipleDialog(primaryStage);

			if (ausgewaehlteDatei != null) {
				for (File f : ausgewaehlteDatei) {
					System.out.println(f.getAbsolutePath());
				}
			}
		});

		// Speichern
		button3.setOnAction(e -> {

			// Dialog anzeigen lassen. showDialog gibt ebenfalls die ausgew�hlte File
			// zur�ck.
			File ausgewaehlteDatei = chooser.showSaveDialog(primaryStage);

			// Macht genau das gleiche wie der OpenDialog. Sieht aber anders aus.
			if (ausgewaehlteDatei != null) {
				System.out.println(ausgewaehlteDatei.getAbsolutePath());
			}

		});

		chooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Alle Dateien", "*"),
				new FileChooser.ExtensionFilter("Text Dateien", "*.txt"),
				new FileChooser.ExtensionFilter("HTML Dateien", "*.html"),
				new FileChooser.ExtensionFilter("Verr�ckte Dateien", "*.verr�ckt"));

	}

	public static void main(String[] args) {
		launch(args);
	}

}
