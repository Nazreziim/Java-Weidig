package _010Netzwerk.LocalChat.client;

import java.util.Optional;

import _010Netzwerk.LocalChat.controller.ChatController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ClientStart extends Application {
	public static void main(String[] args) {
		setUserAgentStylesheet(STYLESHEET_CASPIAN);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Hörsaalchat");
		primaryStage.getIcons().add(new Image("res/ITSBW.png"));
		primaryStage.setResizable(true);
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(900);

		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../view/Chat.fxml"));
		Parent fxmlScene = loader.load();

		
		ChatController controller = loader.getController();
		
		// Legt den Nutzernamen fest 
		controller.setNutzername(inputUsername());
		controller.chatRun();

		Scene scene = new Scene(fxmlScene);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public String inputUsername() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("");
		dialog.setHeaderText("Geben Sie ihren Nutzernamen ein");
		dialog.setContentText("Nutzername:");
		Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
		dialogStage.getIcons().add(new Image("res/ITSBW.png"));

		// Ergebnis holen
		Optional<String> result = dialog.showAndWait();

		// Warten bis irgendetwas eingegeben wurde
		while (!result.isPresent()) {
			result = dialog.showAndWait();
		}

		return result.get();

	}

}
