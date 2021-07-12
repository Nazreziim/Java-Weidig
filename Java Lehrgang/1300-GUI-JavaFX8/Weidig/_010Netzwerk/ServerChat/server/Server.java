package _010Netzwerk.ServerChat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(6666);
			serverSocket.setSoTimeout(1000);
			boolean running = true;

			while (running) {
				try {
					Socket clientSocket = serverSocket.accept();
					ClientThread client = new ClientThread(clientSocket);

				} catch (SocketTimeoutException e) {
					// nichts tun. Bedingung neu prüfen.
				}
			}

			serverSocket.close();
		} catch (IOException e) {
			System.err.println("The Port is not availlable.");
		}

	}

}
