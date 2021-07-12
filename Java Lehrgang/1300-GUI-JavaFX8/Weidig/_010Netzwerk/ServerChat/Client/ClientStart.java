package _010Netzwerk.ServerChat.Client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Optional;

import _010Netzwerk.ServerChat.controller.ChatController;
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
		controller.chatRun(inputAdress("Geben Sie die ServerAdresse an.\n[Format: 127.0.0.1:555]"));
		controller.setNutzername(inputUsername());

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

	public Socket inputAdress(String headerText) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("");
		dialog.setHeaderText(headerText);
		dialog.setContentText("Adresse:");
		Stage dialogStage = (Stage) dialog.getDialogPane().getScene().getWindow();
		dialogStage.getIcons().add(new Image("res/ITSBW.png"));

		// Ergebnis holen
		Optional<String> result = dialog.showAndWait();

		// Warten bis irgendetwas eingegeben wurde
		while (!result.isPresent() || result.get().equals("") || !result.get().contains(":")) {
			result = dialog.showAndWait();
		}

		char[] zwischenspeicher = result.get().toCharArray();
		String port = "";
		String adresse = "";
		boolean adressEnd = false;

		for (int i = 0; i < zwischenspeicher.length; i++) {
			if (zwischenspeicher[i] != ':' && !adressEnd) {
				adresse += zwischenspeicher[i];

			} else {
				adressEnd = true;
				port += zwischenspeicher[i];

			}
		}

		// Entfernt den Doppelpunkt
		port = port.substring(1);
		Socket socket = null;
		try {
			socket = new Socket(InetAddress.getByName(adresse), Integer.valueOf(port));
		} catch (NumberFormatException e) {
			inputAdress("Falsches Format!!\n[Format: 127.0.0.1:555]");
		} catch (UnknownHostException e) {
			inputAdress("Host nicht bekannt!!\n[Format: 127.0.0.1:555]");
		} catch (IOException e) {
			inputAdress("Server nicht erreichbar!!\n[Format: 127.0.0.1:555]");
		}

		return socket;

	}

}
