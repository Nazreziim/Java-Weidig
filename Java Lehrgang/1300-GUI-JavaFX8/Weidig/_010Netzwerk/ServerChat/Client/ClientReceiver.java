package _010Netzwerk.ServerChat.Client;

import java.net.Socket;

import _010Netzwerk.ServerChat.model.Nachricht;
import javafx.scene.control.ListView;

public class ClientReceiver extends Thread {

	private ListView<Nachricht> fxChat;
	private ListView<String> fxNutzerliste;
	private Socket client;

	public ClientReceiver(ListView<Nachricht> fxChat, ListView<String> fxNutzerliste, Socket client) {
		this.fxChat = fxChat;
		this.fxNutzerliste = fxNutzerliste;
		this.client = client;
	}

	@Override
	public void run() {

	}

}
