package _06ObjectDatagramSocket;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class _01DatagramSocketEmpfänger {

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

				// ByteArrayStream für unseren byteBuffer (Zwischenspeicher) direkt in ein
				// ObjectStream
				ObjectInputStream menschObjectStream = new ObjectInputStream(new ByteArrayInputStream(byteBuffer));

				Mensch einMensch = (Mensch) menschObjectStream.readObject();

				System.out.println(einMensch.getName());
				System.out.println(einMensch.getAlter());

			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
