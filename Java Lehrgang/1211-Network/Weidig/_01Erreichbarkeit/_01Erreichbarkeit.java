package _01Erreichbarkeit;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _01Erreichbarkeit {
	public static void main(String[] args) {
		// KEIN HTTPS NUTZEN
		String hostName = "git.itsbw.cir";

		try {
			InetAddress adresse = InetAddress.getByName(hostName);

			// Gibt die IP Adresse aus
			System.out.println("Host: " + adresse.getHostAddress());

			// Gibt den festgelegten HostNamen aus
			System.out.println("HostName: " + adresse.getHostName());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
