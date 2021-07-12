
package simple.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

public class Client {

	/**
	 * 1.) Verbindungsaufbau über Socket
	 */
	public void socketStart() {
		try {
			// 1.) Hostname festlegen
			InetAddress adresse = InetAddress.getByName("www.it-training.fus");
			
			// 2.) Socket für die Verbindung erstellen
			Socket socke = new Socket(adresse, 80);
			
			// 3.) Anfrage stellen - dafür OutputStream
			OutputStream out = socke.getOutputStream();			
			//String anfrage = "Hallo? Du da?"; 
			String anfrage = "GET / HTTP/1.1 \r\nHost: www.it-training.fus\r\n\r\n";
			out.write(anfrage.getBytes());
			System.out.println("Anfrage gesendet!");
			
			//4.) Stream für die Antwort des Servers: InputStream
			InputStream in = socke.getInputStream();
			
			//5.) Antwort auslesen
			byte[] buffer = new byte[2048];
			String gelesen = "";						
			int len = in.read(buffer);
			while (len != -1) {
				for (int i = 0; i < len; i++) {
					gelesen += (char)buffer[i];
				}				 
				len = in.read(buffer);
			}
			
			// 6.) Antwort ausgeben
			System.out.println(gelesen);
			
			// 7.) Verbindungsabbau
			in.close();
			out.close();
			socke.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 2.) Verbindungsaufbau über URL-Objekt
	 */
	public void urlStart() {
		try {
			// 1.) URL-Objekt anlegen
			URL url = new URL("http", "www.it-training.fus", 80, "");
			
			// 2.) Verbindung zur URL öffnen
			URLConnection conn = url.openConnection();
									
			// 3.) Stream für die Antwort des Servers: InputStream
			InputStream in = conn.getInputStream();
			
			// 4.) Antwort auslesen
			byte[] buffer = new byte[2048];
			String gelesen = "";						
			int len = in.read(buffer);
			while (len != -1) {
				for (int i = 0; i < len; i++) {
					gelesen += (char)buffer[i];
				}				 
				len = in.read(buffer);
			}
			
			// 5.) Antwort ausgeben
			System.out.println(gelesen);
			
			// 6.) Verbindungsabbau
			in.close();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 3.) Verbindungsaufbau ins Internet mit Proxy
	 */
	public void internetStart() {
		try {
			// 0.) Proxy einstellen (für FüUstgSBw)
			SocketAddress proxyAddr = new InetSocketAddress("192.168.4.200", 3128);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddr);
			
			// 1.) URL-Objekt anlegen
			URL url = new URL("http", "spiegel.de", 80, "");
			
			// 2.) Verbindung zur URL öffnen mit Proxy
			URLConnection conn = url.openConnection(proxy);
									
			// 3.) Stream für die Antwort des Servers: InputStream
			InputStream in = conn.getInputStream();
			
			// 4.) Antwort auslesen
			byte[] buffer = new byte[2048];
			String gelesen = "";						
			int len = in.read(buffer);
			while (len != -1) {
				for (int i = 0; i < len; i++) {
					gelesen += (char)buffer[i];
				}				 
				len = in.read(buffer);
			}
			
			// 5.) Antwort ausgeben
			System.out.println(gelesen);
			
			// 6.) Verbindungsabbau
			in.close();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Client c = new Client();
//		c.socketStart();
//		c.urlStart();
		c.internetStart();

		

	}

}
