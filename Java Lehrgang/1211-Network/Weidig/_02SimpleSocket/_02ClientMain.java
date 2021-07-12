package _02SimpleSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class _02ClientMain {

	public static void main(String[] args) {
		// HINWEIS: Sockets immer schließen [außerhalb des Try deklarieren und über
		// finally schließen oder AutoClosable nutzen mittels Try-With-Ressources

		String serverAdresse = "127.0.0.1";

		try {
			// Auf welche Adresse, welchen Port soll ich mich "einloggen"
			Socket client = new Socket(serverAdresse, 666);

			// Hier können wir autoflush nutzen da unsere Nutzereingaben ja direkt in den
			// OutputStream gelegt werden sollen
			PrintStream dasGehtRaus = new PrintStream(client.getOutputStream(), true);

			// Hier hollen wir uns alles was denn so bei uns ankommt
			BufferedReader dasKommtRein = new BufferedReader(new InputStreamReader(client.getInputStream()));

			// Für Nutzereingaben
			Scanner sc = new Scanner(System.in);

			// Achtung .readLine springt zur nächsten Linie egal ob .readLine beim Server
			// oder beim Client aufgerufen wurde
			while (true) {
				String text = sc.next();
				dasGehtRaus.println(text);
				System.out.print("Server so: " + dasKommtRein.readLine());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
