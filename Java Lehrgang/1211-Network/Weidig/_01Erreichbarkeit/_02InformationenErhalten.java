package _01Erreichbarkeit;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class _02InformationenErhalten {

	public static void main(String[] args) {

		try {
			// Erhalte den Localhost
			InetAddress host = InetAddress.getLocalHost();

			// In NI speichern um so Zugriff auf mehr Informationsmethoden zu erhalten
			NetworkInterface ni = NetworkInterface.getByInetAddress(host);

			// Host und DisplayName
			System.out.println("Hostname: " + host.getHostName());
			System.out.println("Gerätename: " + ni.getDisplayName());

			// MacAdresse

			// Hier noch in Bytes
			byte[] adresse = ni.getHardwareAddress();
			String macAdresse = "";
			
			//Alle Bytes zu einem String machen
			for (byte einByte : adresse) {
				// %x formatiert automatisch einen Byte in einen entssprechenden Char
				macAdresse += String.format("%x:", einByte);
			}

			//Schneidet den letzten Doppelpunkt weg
			macAdresse = macAdresse.toLowerCase().substring(0, macAdresse.length() - 1);
			
			System.out.println("Mac Adresse: " + macAdresse);
			
			//Alle zugehörigen Adressen ( IPv4/6) ohne Subnetzmaske
			InetAddress[] alleAdressen = InetAddress.getAllByName(host.getHostName());
			for(InetAddress eineAdresse : alleAdressen) {
				System.out.println("Adresse: " + eineAdresse);
			}
			

		} catch (UnknownHostException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
