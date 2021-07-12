package _005EventsUndBindings;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class _05Alerts extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Verschiedene Typen von Alert
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setAlertType(AlertType.CONFIRMATION);
//		alert.setAlertType(AlertType.ERROR);
//		alert.setAlertType(AlertType.WARNING);
//		alert.setAlertType(AlertType.NONE);

		// Zusätzliche Eigenschaften
		alert.setTitle("Informations-Dialog");
		alert.setHeaderText("Überschrift");
		alert.setContentText("Das ist der Inhalt des Alerts!");

		// Zusätzliche Buttons
		ButtonType buttonNr1 = new ButtonType("1");
		ButtonType buttonNr2 = new ButtonType("2");
		ButtonType buttonNr3 = new ButtonType("3");
		
		alert.getButtonTypes().addAll(buttonNr1, buttonNr2, buttonNr3);

		// Return von showAndWait beachten
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			System.out.println("Ok");
		} else if (result.get() == ButtonType.CANCEL) {
			System.out.println("Abbruch");
		} else if (result.get() == buttonNr1) {
			System.out.println("Button Nr. 1 gedrückt");
		} else if (result.get() == buttonNr2) {
			System.out.println("Button Nr. 2 gedrückt");
		} else if (result.get() == buttonNr3) {
			System.out.println("Button Nr. 3 gedrückt");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
