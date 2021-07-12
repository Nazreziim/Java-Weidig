package simple.server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;


public class HttpServer {

	public static void main(String[] args) {
		//singleServerStart();
		multipleServerStart();
	}
	
	
	private static void multipleServerStart() {
			try {
				// 1.) ServerSocket erstellen
				ServerSocket  serverSocket = new ServerSocket(80);
				System.out.println("Warte auf Verbindungsaufbau...");
				int zaehler = 0;
				
				while (zaehler < 100) {
					Socket clientSocket = serverSocket.accept();
					ServerThread t = new ServerThread(clientSocket, zaehler);
					t.start();
					zaehler++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		
	}


	private static void singleServerStart() {
		try {
			// 1.) ServerSocket erstellen
			ServerSocket  serverSocket = new ServerSocket(80);			
			System.out.println("Warte auf Verbindungsaufbau...");
			
			// 2.) Auf Verbindung warten
			Socket clientSocket = serverSocket.accept();			
			System.out.println("Verbindung aufgebaut mit " + clientSocket.getInetAddress().getHostAddress());
			
			// 3.) InputStream des verbunden Teilnehmers anzeigen
			InputStream is = clientSocket.getInputStream();
			boolean weiter = true;
			byte[] income = new byte[1024];
			String gelesen ="";
			while (weiter) {
				//TODO: Nächste Zeile zwei Zeilen höher führt zu einer Verklemmung im Stream
				// Variante ohne dieses Problem in ServerThread
				int len = is.read(income);

				for (int i = 0; i < len; i++) {
					char c = (char) income[i];
					// Prüfen, ob letztes Zeichen '\n' ist
					if (c != '\n') {
						weiter = true;
						gelesen += c;
					} else {
						weiter = false;
					}
				}
			}
			
			// 4.) Anfrage ausgeben
			System.out.println(gelesen);
			JOptionPane.showMessageDialog(null, gelesen);
			
			// 5.) Antwort generieren und zurückgeben
			PrintWriter out = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()));
			out.println("Die Nachricht wurde angenommen");
			
			// 6.) Aufräumen
			out.flush();
			out.close();
			is.close();
			clientSocket.close();
			serverSocket.close();
			
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		
	}

}
