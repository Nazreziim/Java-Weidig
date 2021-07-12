package simple.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket clientSocket;
	private final int id;
	
	public ServerThread(Socket s, int id) {
		this.clientSocket = s;
		this.id = id;		
	}
	
	public void run() {
		String s = "Eine Nachricht von " + clientSocket.getInetAddress().getHostAddress() + "\n";
		


		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String gelesen ="";
			String str;
			while (in.ready()) {
				gelesen += in.readLine();
			}
			System.out.println("Server-Thread " + id + " bearbeitete folgende Anfrage: " + gelesen);
			
								
			
			PrintWriter out = new PrintWriter(new BufferedOutputStream(clientSocket.getOutputStream()));
			out.println("Die Nachricht "+ gelesen + " wurde angenommen");
			
			out.flush();
			out.close();
			in.close();
			clientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
