package simple.client_server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientThread extends Thread {
	private Socket client;
	private final int cnt;

	public ClientThread(Socket s, int id) {
		this.client = s;
		this.cnt = id;

	}

	public void run() {
		try {// Erstellen einer Ausgabe
			String s = "Nachricht von "
					+ client.getInetAddress().getHostAddress() + ":\n";

			// Über InputStream kommt Nachricht vom Client rein
			InputStream in;

			in = client.getInputStream();

			// Buffer für Nachricht
			byte[] income = new byte[100];

			// Kleines Protokol: solange Lesen bis in Nachricht ein \n
			// kommt. b wird false wenn
			// eingelesenes Zeichen '\n' ist
			boolean b = true;
			while (b) {
				// Einlesen der ersten 100 bytes
				int len = in.read(income);
				for (int i = 0; i < len; i++) {
					char c = (char) income[i];
					// Prüfen, ob letztes Zeichen '\n' ist
					b = c != '\n';
					if (b) {
						s += c;
					}
				}
			}
			// Ausgabe der Client -Nachricht und -Adresse
			System.out.println("Thread "+ this.cnt +" bearbeitete folgende Anfrage:\n"+ s);

			// Nachricht an Client, hier über PrintWriter
			PrintWriter outStream = new PrintWriter(new BufferedOutputStream(
					client.getOutputStream()));
			outStream.println("Die Nachricht wurde vom Server angenommen");
			outStream.flush();

			// Trennen der Verbindung
			outStream.close();
			//in.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
