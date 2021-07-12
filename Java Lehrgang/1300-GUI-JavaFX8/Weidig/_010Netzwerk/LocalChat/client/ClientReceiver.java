package _010Netzwerk.LocalChat.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import _010Netzwerk.LocalChat.model.Nachricht;
import javafx.application.Platform;
import javafx.scene.control.ListView;

public class ClientReceiver extends Thread {

	private ListView<Nachricht> fxChat;
	private ListView<String> fxNutzerliste;

	public ClientReceiver(ListView<Nachricht> fxChat, ListView<String> fxNutzerliste) {
		super();
		this.fxChat = fxChat;
		this.fxNutzerliste = fxNutzerliste;
	}

	@Override
	public void run() {
		try {
			// Multicast Adresse: 224.0.0.0 bis 239.255.255.255
			InetAddress multicastAdress = InetAddress.getByName("224.0.0.0");
			MulticastSocket multiSocket = new MulticastSocket(6666);

			// Gem. _04Multicast - _01MulticastSocket
			multiSocket.setReuseAddress(true);
			multiSocket.joinGroup(multicastAdress);

			while (true) {
				byte[] byteBuffer = new byte[8192];

				DatagramPacket packet = new DatagramPacket(byteBuffer, byteBuffer.length);
				multiSocket.receive(packet);

				ObjectInputStream msgObjectStream = new ObjectInputStream(new ByteArrayInputStream(byteBuffer));

				Nachricht eineNachricht = (Nachricht) msgObjectStream.readObject();
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						//TODO: Provisorische command Möglichkeit überarbeiten
						if(!eineNachricht.getInhalt().equals("/command leave")) {
							fxChat.getItems().add(eineNachricht);

							// TODO: Extra Receiver für Nutzer, sobald Nutzer = Objekt
							boolean nutzerSuche = false;
							for (String nutzer : fxNutzerliste.getItems()) {
								// Falls es noch keinen Nutzer gibt der dem Sendernamen der Nachricht entspricht
								if (nutzer.equals(eineNachricht.getSenderName())) {
									nutzerSuche = true;
								}
							}
							
							if(!nutzerSuche) {
								fxNutzerliste.getItems().add(eineNachricht.getSenderName());
							}
						} else {
							fxNutzerliste.getItems().remove(eineNachricht.getSenderName());
						}
						
						
						

					}
				});

			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
