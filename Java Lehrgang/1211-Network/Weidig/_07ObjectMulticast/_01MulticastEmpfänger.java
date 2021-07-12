package _07ObjectMulticast;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class _01MulticastEmpfänger {

	public static void main(String[] args) {
		try {
			// Multicast Adresse: 224.0.0.0 bis 239.255.255.255
			InetAddress multicastAdress = InetAddress.getByName("224.0.0.0");
			MulticastSocket multiSocket = new MulticastSocket(6666);

			// Gem. _04Multicast - _01MulticastSocket
			multiSocket.setReuseAddress(true);
			multiSocket.joinGroup(multicastAdress);

			byte[] byteBuffer = new byte[8192];
			
			DatagramPacket packet = new DatagramPacket(byteBuffer, byteBuffer.length);
			
			while(true) {
				multiSocket.receive(packet);
				
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
