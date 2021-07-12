package _02SimpleSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _01ServerMain {

	public static void main(String[] args) {
		// HINWEIS: Sockets immer schlie�en [au�erhalb des Try deklarieren und �ber
		// finally schlie�en oder AutoClosable nutzen mittels Try-With-Ressources

		try {
			// Initialisierung
			ServerSocket serverSocket = new ServerSocket(666);
			Socket einClient = serverSocket.accept();

			// Alles was ankommt an Infos
			BufferedReader dasKommtRein = new BufferedReader(new InputStreamReader(einClient.getInputStream()));

			// Alles was rausgeht an Infos
			PrintStream dasGehtRaus = new PrintStream(einClient.getOutputStream());

			// Solange etwas reinkommt
			while (true) {
				// Was schickt der Client?
				// System.out.println("Client so: " + dasKommtRein.readLine());

				// Gebe das was reinkommt wieder zur�ck
				dasGehtRaus.println(dasKommtRein.readLine());

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
