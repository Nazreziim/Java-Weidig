package _03Datagram;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class _02DatagramChannelClient {

	public static void main(String[] args) {

		try {
			/*************** Initialisieren ***************/
			// Kombination aus Socked und Adresse
			InetSocketAddress serverAdresse = new InetSocketAddress("localhost", 6666);

			// Öffnet einen neuen Channel
			DatagramChannel dataChannel = DatagramChannel.open();

			// Nachricht die wir übers Netzwerk versenden wollen
			String testNachricht = "Hallo!!";

			//Java NIO Klasse um ein ByteArray in einem Buffer weiterzuverarbeiten
			ByteBuffer buffer = ByteBuffer.wrap(testNachricht.getBytes());

			//Java NIO Klasse um ByteBuffer Daten über das Netzwerk zu senden 
			dataChannel.send(buffer, serverAdresse);

			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
