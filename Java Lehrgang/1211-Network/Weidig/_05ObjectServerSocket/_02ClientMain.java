package _05ObjectServerSocket;

import java.io.IOException;
import java.io.ObjectOutputStream;
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
			ObjectOutputStream menschOutputStream = new ObjectOutputStream(client.getOutputStream());

			// Für Nutzereingaben
			Scanner sc = new Scanner(System.in);

			while (true) {
				
				System.out.println("Wie soll der neue Mensch heißen?");
				String name = sc.next();
				
				System.out.println("Wie alt ist der neue Mensch?");
				int alter = sc.nextInt();
				
				Mensch mensch = new Mensch(name, alter);
				menschOutputStream.writeObject(mensch);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
