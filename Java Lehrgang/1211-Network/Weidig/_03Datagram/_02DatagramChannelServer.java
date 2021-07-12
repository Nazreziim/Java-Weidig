package _03Datagram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class _02DatagramChannelServer {
	public static void main(String[] args) {

		try {
			/*************** Initialisieren ***************/
			InetSocketAddress serverAdresse = new InetSocketAddress("localhost", 6666);
			DatagramChannel dataChannel = DatagramChannel.open();

			// Wir binden unseren channel an die Adresse, welche "abgehört" wird
			dataChannel.bind(serverAdresse);

			System.out.println("Server gestartet auf " + serverAdresse);

			/*************** Auslesen ***************/
			// 8192 ~8kb ist eine gängige Paketgröße für Netzwerkpakete
			ByteBuffer buffer = ByteBuffer.allocate(8192);

			// Nutzt eine SocketAdress um die die Daten zu empfangen und im Buffer abzulegen
			// Es ist nicht nötig die SocketAdress zwischenzuspeichern [Zuweisung löschen und zeigen]
			SocketAddress channelAdresse = dataChannel.receive(buffer);

			// Setzt den Zeiger quasi wieder an die Anfangsstelle, falls bereits aus dem
			// Buffer gelesen wurde
			buffer.flip();

			// Hier werden die empfangenen Bytes abgelegt. Die Größe entspricht der noch
			// übrigen Menge an Bytes im Buffer
			byte[] byteMsg = new byte[buffer.remaining()];

			// Nimmt die gespeicherten BufferBytes und legt sie in unser byte Array
			buffer.get(byteMsg);

			// Nunn lesen wir unsere Nachricht aus
			String nachricht = new String(byteMsg);

			System.out.println(nachricht);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
