package _010Netzwerk.LocalChat.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.URL;
import java.util.ResourceBundle;

import _010Netzwerk.LocalChat.client.ClientReceiver;
import _010Netzwerk.LocalChat.model.ChatCell;
import _010Netzwerk.LocalChat.model.Nachricht;
import javafx.application.Platform;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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

	private ClientReceiver receiver;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initEvents();
		fxChat.setCellFactory(cell -> new ChatCell());
	}

	public void chatRun() {
		receiver = new ClientReceiver(this.fxChat, this.fxNutzerliste);
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
		try {
			// Multicast Adresse: 224.0.0.0 bis 239.255.255.255
			InetAddress multicastAdress = InetAddress.getByName("224.0.0.0");
			MulticastSocket multiSocket = new MulticastSocket(6666);

			// Gem. _04Multicast - _01MulticastSocket
			multiSocket.setReuseAddress(true);
			multiSocket.joinGroup(multicastAdress);

			// Nachricht zu ByteArray gem. _06ObjectDatagramSocket - _01DatagramSocketSender
			Nachricht msg = new Nachricht(this.nutzername, this.fxEingabeFeld.getText());
			ByteArrayOutputStream msgByteStream = new ByteArrayOutputStream();
			ObjectOutputStream msgStream = new ObjectOutputStream(msgByteStream);
			msgStream.writeObject(msg);
			msgStream.flush();
			byte[] msgBytes = msgByteStream.toByteArray();

			// Paket erzeugen und senden
			DatagramPacket paket = new DatagramPacket(msgBytes, msgBytes.length, multicastAdress, 6666);

			multiSocket.send(paket);
			this.fxEingabeFeld.setText("");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setNutzername(String nutzername) {
		this.nutzername = nutzername;
	}

	public String getNutzername() {
		return nutzername;
	}
}
