package _003Medien;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class DerMediaPlayer extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = new Pane();
		Scene mainScene = new Scene(mainPane);

		// Je nach Auswahl entweder sound oder video
		File video = new File("Weidig/_003Medien/ressourcen/BeispielMP4.mp4");
		File sound = new File("Weidig/_003Medien/ressourcen/Schuss.mp3");

		// Media möchte einen URI String
		// --> Only HTTP, HTTPS, FILE, and JAR URLs are supported
		Media media = new Media(sound.toURI().toString());

		MediaPlayer player = new MediaPlayer(media);

		MediaView mV = new MediaView(player);

		// Möchte ich nichts Anzeigen muss ich es nicht zum Pane hinzufügen [z.B. bloßer
		// Sound]
		mainPane.getChildren().add(mV);
		// Die Größe des Panes sollte die genutzte Größe des Videos sein
		mainPane.setMinWidth(320);
		mainPane.setMinHeight(240);
		primaryStage.setScene(mainScene);
		primaryStage.show();

		// Startet den Player nachdem das Fenster geladen wurde
		player.play();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
