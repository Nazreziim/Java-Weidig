package _03Datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class _03DatagramSocketEmpfänger {

	public static void main(String[] args) {
		try {
			// Öffnen unseres Sockets
			DatagramSocket socket = new DatagramSocket(6666);
			byte[] byteBuffer = new byte[8192];

			// Festlegen unseres Packets und zwischenspeichern des ByteBuffers der die Daten
			// erhält
			DatagramPacket packet = new DatagramPacket(byteBuffer, byteBuffer.length);

			// Damit permanent empfangen wird
			while (true) {
				// Daten empfangen und im Packet abspeichern
				socket.receive(packet);

				System.out.println(new String(packet.getData(), 0, packet.getLength()));
				socket.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
