package _04Multicast;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class _01MulticastSocket {

	/*
	 * Multicast erlaubt es mehreren Netzwerkendpunkten untereinander zu
	 * kommunizieren. Ein an eine Multicast Adresse zugestelltes Netzwerkpaket
	 * erreicht alle Endpunkte, die sich auf diese Adresse registriert haben. Das
	 * hierbei verwendete Transportprotokoll ist UDP (User Datagram Protocol). Es
	 * enthält keine Flusskontrolle, das heißt es gibt keine Rückmeldung an den
	 * Sender des Pakets, ob es bei allen Empfängern angekommen ist. Insbesondere
	 * muss der Sender auch gar nicht alle seine Empfänger kennen. Im Gegensatz dazu
	 * läuft der Großteil der Kommunikation im Internet - zum Beispiel HTTP - per
	 * Unicast ab und verwendet das Transportprotokoll TCP. Hierbei besteht eine
	 * Netzwerkverbindung immer genau aus zwei Teilnehmeŕn (Client und Server) und
	 * es erfolgt eine Quittierung jedes einzelnen empfangenen Pakets zur
	 * Flusskontrolle.
	 */

	/*
	 * Am Beispiel von SSDP (Service Discovery Protocol) welches zur Suche nach UPnP
	 * (Universal Plug and Play) Geräten dient wird der Port 1900 genutzt. Die
	 * zugehörige Adresse ist die Multicast Adresse 239.255.255.250
	 */

	public static void main(String[] args) {
		try {
			/************************************************/
			/********** Multicast Initialisieren ************/
			/************************************************/

			//Multicast Adresse: 224.0.0.0 bis 239.255.255.255
			InetAddress multicastAdresse = InetAddress.getByName("239.255.255.250");
			MulticastSocket multiSocket = new MulticastSocket(1900);

			// Erlaubt es mehreren Sockets sich an eine Adresse anzumelden
			multiSocket.setReuseAddress(true);

			// Maximaler Timeout in ms
			multiSocket.setSoTimeout(15000);

			// Fügt den Socket zur Multicast Adresse hinzu
			multiSocket.joinGroup(multicastAdresse);

			/************************************************/
			/********** Senden und Empfangen ****************/
			/************************************************/

			/*
			 * Um alle Geräte im Netzwerk möglichst schnell zu erkennen wird ein SSDP
			 * Discover Paket (DatagramPacket) versendet, welches von den Geräten empfangen
			 * wird
			 */

			/***************** Senden ****************/
			
			/*
			 * Das hier ist der String um die sogenannte SSDP Discover Message festzulegen
			 * und somit ein HTTP Request zu erzeugen. Durch googlen findet man
			 * Protokollspezifische Messages, welche zu nutzen sind.
			 * Dieser sollte auf keinen Fall verändert werden.
			 */
			final String DISCOVER_MESSAGE_ROOTDEVICE =
				    "M-SEARCH * HTTP/1.1\r\n" +
				    "ST: upnp:rootdevice\r\n" +
				    "MX: 3\r\n" +
				    "MAN: `ssdp:discover`\r\n".replace('`', '"') +
				    "HOST: 239.255.255.250:1900\r\n\r\n";

			byte[] sendBuffer = DISCOVER_MESSAGE_ROOTDEVICE.getBytes("UTF-8");

			// Ein Paket, dass einmal angibt welches Paket versendet wird, wie lang dieses
			// ist, auf welcher Adresse mit welchem Port es gesendet werden soll
			DatagramPacket paket = new DatagramPacket(sendBuffer, sendBuffer.length, multicastAdresse, 1900);

			// Sendet das Paket über den Socket
			multiSocket.send(paket);

			/*************** Empfangen ***************/
			//Wir wollen permanent empfangen. Wird nichts empfangen tritt eine TimeOutException nach 15s ein
			while (true) {

				// 8192 ~8kb ist eine gängige Paketgröße für Netzwerkpakete
				byte[] receiveBuffer = new byte[8192];

				// Hier werden unsere Daten reingelegt
				DatagramPacket empfängerPaket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

				// Erhalten unserer Daten und ablegen im empfängerPaket
				multiSocket.receive(empfängerPaket);

				/*************** Auslesen ***************/
				InetAddress empfangeneAdresse = empfängerPaket.getAddress();
				System.out.println("Antwort von: " + empfangeneAdresse);

				// Nimmt die empfangenen Daten. Setzt den Zeiger auf 0 [Startpunkt] und lässt
				// maximal die festgelegte Länge des Pakets an Daten zu.
				ByteArrayInputStream in = new ByteArrayInputStream(empfängerPaket.getData(), 0,
						empfängerPaket.getLength());

				
				String fertigerText = "";
				int zeichen;
				while ((zeichen = in.read()) != -1) {
					fertigerText += (char) zeichen;
				}

				System.out.println(fertigerText);
				
				
				//Kurzschreibweise
				//Nimmt alle Daten des Packets, speichert diese in einem neuen String und liest diese aus
				System.out.println(new String(empfängerPaket.getData(), 0, empfängerPaket.getLength()));
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
