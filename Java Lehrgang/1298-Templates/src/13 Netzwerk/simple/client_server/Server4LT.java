package simple.client_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Dieser Server bedient mehrere Clients
 * @author dborkowitz
 *
 */
public class Server4LT {

	public static void serverStart() {
		int count = 0;
		try{
			System.out.println("Warte auf Lehrgangsteilnehmer auf Port 7...");
			ServerSocket server = new ServerSocket(7);
			//Ich bearbeite nur 100 Anfragen, dann is Feierabend
			while(count < 100){
				//Für jede Client-anfrage wird ein Thread erstellt, der die Kommunikation mit dem Client bearbeitet
				Socket client = server.accept();
				ClientThread t = new ClientThread(client, count);
				t.start();
				count++;
			}
		}catch (IOException e) {
			// TODO: handle exception
		}

	}

	public static void main(String args[]) {
		serverStart();
	}

}
