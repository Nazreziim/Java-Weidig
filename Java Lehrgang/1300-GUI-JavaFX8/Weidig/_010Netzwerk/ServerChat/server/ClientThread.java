package _010Netzwerk.ServerChat.server;

import java.net.Socket;

public class ClientThread extends Thread {
	Socket client = null;
	
	public ClientThread(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		
	}
}
