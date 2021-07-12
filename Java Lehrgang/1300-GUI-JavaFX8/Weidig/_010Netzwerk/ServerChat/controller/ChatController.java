package _010Netzwerk.ServerChat.controller;

import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import _010Netzwerk.ServerChat.Client.ClientReceiver;
import _010Netzwerk.ServerChat.model.ChatCell;
import _010Netzwerk.ServerChat.model.Nachricht;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ChatController implements Initializable {
	@FXML
	private ListView<Nachricht> fxChat;
	@FXML
	private TextField fxEingabeFeld;
	@FXML
	private Button fxSendeButton;
	@FXML
	private ListView<String> fxNutzerliste;

	private String nutzername;
	
	private Socket client;

	private ClientReceiver receiver;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initEvents();
		fxChat.setCellFactory(cell -> new ChatCell());
	}

	public void chatRun(Socket client) {
		this.client = client;
		receiver = new ClientReceiver(this.fxChat, this.fxNutzerliste, client);
		receiver.start();
	}

	private void initEvents() {
		// Wenn Enter gedrückt wird auf dem Eingabefeld
		this.fxEingabeFeld.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			if (event.getCode() == KeyCode.ENTER) {
				nachrichtSenden();
			}
		});

		// Wenn der Button irgendwie betätigt wird
		this.fxSendeButton.setOnAction(event -> nachrichtSenden());

		// Sorgt dafür, dass alle Events im Bereich des ListViews (Chat) abgefangen
		// werden -> Markieren etc. alles nicht möglich dadurch
		this.fxChat.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> event.consume());
	}

	public void nachrichtSenden() {
		if(!this.fxEingabeFeld.getText().equals("/command leave")) {
			constructMessage();
		} else {
			constructMessage();
			Platform.exit();
		}
		
	}
	
	public void constructMessage() {
		
	}

	public void setNutzername(String nutzername) {
		this.nutzername = nutzername;
	}

	public String getNutzername() {
		return nutzername;
	}
}
