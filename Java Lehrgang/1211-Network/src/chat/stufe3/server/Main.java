package chat.stufe3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {

		boolean running = true;
		ChatRoom chat = new ChatRoom();
		try {
			int port = 80;

			ServerSocket serverSocket = new ServerSocket(port);

			while (running) {
				Socket clientSocket = serverSocket.accept();
				ClientThread clientThread = new ClientThread(chat, clientSocket);
				clientThread.start();
			}

			serverSocket.close();

		} catch (NumberFormatException e) {
			System.err.println("The Port has to be an Integer.");
		} catch (IOException e) {
			System.err.println("The Port is not availlable.");
		}
	}

}
