package _005EventsUndBindings;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class _06Dialogs extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		showTextInputDialog();
		showChoiceDialog();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void showTextInputDialog() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("TextInputTitel");
		dialog.setHeaderText("TextInputÜberschrift");
		dialog.setContentText("Hier Text eingeben:");

		Optional<String> result = dialog.showAndWait();

		// Gibt zurück ob in result überhaupt etwas drin ist
		if (result.isPresent()) {
			//Wert aus result holen
			System.out.println("Eigegebener Text: " + result.get());
		}

		// Lambda Version über if<<Present
		result.ifPresent(name -> System.out.println("Eingegebener Text: " + name));
	}
	
	private void showChoiceDialog() {
		ArrayList<String> choices = new ArrayList<>();
		choices.add("a");
		choices.add("b");
		choices.add("c");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("b", choices);
		dialog.setTitle("ChoiceDialogtitel");
		dialog.setHeaderText("ChoiceDialogÜberschrift");
		dialog.setContentText("Wähle aus:");

		Optional<String> result = dialog.showAndWait();
		
		// Inhalt über Lambda erhalten
		result.ifPresent(letter -> System.out.println("Auswahl: " + letter));
		
	}

}
