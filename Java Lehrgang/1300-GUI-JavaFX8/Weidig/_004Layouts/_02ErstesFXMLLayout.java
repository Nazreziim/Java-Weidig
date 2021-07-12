package _004Layouts;

import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class _02ErstesFXMLLayout extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ErsteAnwendung");
		primaryStage.getIcons().add(new Image("res/ITSBW.png"));
		primaryStage.setWidth(1280);
		primaryStage.setHeight(720);
		primaryStage.setResizable(false);

		/************** Möglichkeit 1 "Laden der FXML Datei" ************/
		
		// Wenn Fehler im FXML Dokument sind bricht es sofort
		// mit einer LoadException ab --> Ins fxml reingucken.
		// --> Scene Konstruktor betrachten warum es ein Parent ist und was load zurückgibt
		Parent fxmlScene = FXMLLoader.load(this.getClass().getResource("_02ErstesFXMLLayout.fxml"));

		//Hier wird initialize() des Controllers aufgerufen
		
		
		// ACHTUNG: Bei der Angabe des Controllers muss das package enthalten sein
		// [Files and Streams]
		
		/************** Möglichkeit 2 "Mehrschritt-Laden für Zugriff auf Controller" ************/
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("_02ErstesFXMLLayout.fxml"));
		Parent fxmlScene2 = loader.load();
		//Bis hierhin macht es dasselbe
		
		// So erhalte ich Zugriff auf den controller direkt
		_02ErstesFXMLLayoutController controller = loader.getController();

		// Wenn Zugriff auf den Controller stattfindet muss auch das entsprechende
		// Parent genutzt [fxmlScene2] werden
		Scene scene = new Scene(fxmlScene2);
		
		
		/*********** Manuelles Hinzufügen der CSS Datei ************/
		scene.getStylesheets().add(getClass().getResource("GreenBackground.css").toExternalForm());
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Beispielmethode hinzufügen und ausführen
		controller.farbenÄndern();

		/*********** Szenenwechsel ***************/
		System.out.println("Szenenwechsel? (J/N)");

		Scanner sc2 = new Scanner(System.in);
		String auswahl = sc2.next();

		if (auswahl.equals("J")) {
			//Ändere die aktuelle Scene zu Scene2
			Scene scene2 = new Scene(fxmlScene);
			primaryStage.setScene(scene2);
			
			//Öffne ein neues Fenster mit der alten Scene [zum Vergleich]
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}

		sc2.close();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
