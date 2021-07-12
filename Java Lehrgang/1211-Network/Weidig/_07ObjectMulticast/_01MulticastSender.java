package _07ObjectMulticast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class _01MulticastSender {

	public static void main(String[] args) {

		try {
			//Multicast Adresse: 224.0.0.0 bis 239.255.255.255
			InetAddress multicastAdress = InetAddress.getByName("224.0.0.0");
			MulticastSocket multiSocket = new MulticastSocket(6666);
			
			//Gem. _04Multicast - _01MulticastSocket
			multiSocket.setReuseAddress(true);
			multiSocket.joinGroup(multicastAdress);
			
			//Mensch zu ByteArray gem. _06ObjectDatagramSocket - _01DatagramSocketSender
			Mensch mensch = new Mensch("Bernd", 20);
			ByteArrayOutputStream menschByteStream = new ByteArrayOutputStream();
			ObjectOutputStream menschStream = new ObjectOutputStream(menschByteStream);
			menschStream.writeObject(mensch);
			menschStream.flush();
			byte[] menschBytes = menschByteStream.toByteArray();
			
			//Paket erzeugen und senden
			DatagramPacket paket = new DatagramPacket(menschBytes, menschBytes.length, multicastAdress, 6666);
			
			multiSocket.send(paket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
