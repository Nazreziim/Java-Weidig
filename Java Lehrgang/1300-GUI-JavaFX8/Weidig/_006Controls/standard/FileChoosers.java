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
		Button button = new Button("Eine Datei auswählen");
		Button button2 = new Button("Mehrere Dateien auswählen");
		Button button3 = new Button("Eine Datei auswählen");
		VBox vBox = new VBox(button, button2, button3);
		Scene scene = new Scene(vBox);
		primaryStage.setScene(scene);
		primaryStage.show();
		// Bildschirm

		FileChooser chooser = new FileChooser();

		// Für eine Datei
		button.setOnAction(e -> {

			// Dialog anzeigen lassen. showDialog gibt ebenfalls die ausgewählte File
			// zurück.
			File ausgewaehlteDatei = chooser.showOpenDialog(primaryStage);

			if (ausgewaehlteDatei != null) {
				System.out.println(ausgewaehlteDatei.getAbsolutePath());
			}
		});

		// Für mehrere Dateien
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

			// Dialog anzeigen lassen. showDialog gibt ebenfalls die ausgewählte File
			// zurück.
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
				new FileChooser.ExtensionFilter("Verrückte Dateien", "*.verrückt"));

	}

	public static void main(String[] args) {
		launch(args);
	}

}
