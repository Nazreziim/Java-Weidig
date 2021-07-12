package _03Datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class _03DatagramSocketSender {

	public static void main(String[] args) {

		try {
			// Adresse auf den lokalen Horst setzen zu Testzwecken
			InetAddress adresse = InetAddress.getByName("localhost");

			// Erzeugen des DatagramSockets
			DatagramSocket socket = new DatagramSocket();

			// Information die wir senden wollen
			String text = "Halloooo!";

			// Erzeugen des Pakets für die Information die wir senden wollen
			DatagramPacket packet = new DatagramPacket(text.getBytes(), text.length(), adresse, 6666);

			// Paket senden und den Socket schließen
			socket.send(packet);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
