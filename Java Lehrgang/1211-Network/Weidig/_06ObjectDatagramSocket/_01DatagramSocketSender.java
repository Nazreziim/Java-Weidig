package _06ObjectDatagramSocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class _01DatagramSocketSender {

	public static void main(String[] args) {

		try {
			// Adresse auf den lokalen Horst setzen zu Testzwecken
			InetAddress adresse = InetAddress.getByName("localhost");

			// Erzeugen des DatagramSockets
			DatagramSocket socket = new DatagramSocket();

			// Information die wir senden wollen
			Mensch mensch = new Mensch("Bernd", 20);
			
			//Stream aus dem wir uns die späteren reingelegten Informationen holen wollen
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			
			//Hier legen wir unser Objekt rein und flushen es später zum byteStream
			ObjectOutputStream menschOutputStream = new ObjectOutputStream(byteStream);
			
			//Jetzt ist unser MenschObjekt im ObjectStream
			menschOutputStream.writeObject(mensch);
			
			//Jetzt ist es im Bytestream
			menschOutputStream.flush();
			
			//Jetzt legen wir unser Menschobject aus dem ByteArrayStream in ein ByteArray
			byte[] menschBytes = byteStream.toByteArray();

			// Erzeugen des Pakets für die Information die wir senden wollen
			DatagramPacket packet = new DatagramPacket(menschBytes, menschBytes.length, adresse, 6666);

			// Paket senden und den Socket schließen
			socket.send(packet);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
