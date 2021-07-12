package aufgaben.events.snake.v4.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Ein ClientSocketThread dient der 1:1 Kommunikation zwischen Server und Client
 * Hier werden die String-Kommandos entgegengenommen und verarbeitet, die von den einzelnen
 * Clients über die GUI ausgesendet werden können.
 * @author LGerhard
 *
 */
public class ClientSocketThread extends Thread{
	private Socket clientSocket;
	private Board b;
	private boolean stopNow = false;
	
	
	public ClientSocketThread(Socket s, Board b) {
		this.clientSocket = s;
		this.b = b;
	}
	
	public void run() {
		try (
			// Streams zur Kommunikation
			// Input: Strings mit Steuerkommandos: NEW CLIENT, TURN LEFT, NEXT STEP,...
			// Output: Für den Anfang mal das komplette Board! - daher ObjectOutputStream
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			ObjectOutputStream out  =  new ObjectOutputStream(clientSocket.getOutputStream());
			){
			
			String inputLine ="";
			while (!stopNow) {
				while ((inputLine = in.readLine()) != null) {
	            	System.out.println("Server: " + inputLine);
	            	
	            	// NEW CLIENT:
	            	// Anlegen einer Schlange auf dem Board, Rückgabe der Schlangen-ID, Rückgabe des Boards
	            	if (inputLine.startsWith("NEW CLIENT")) {
	            		int id = b.addSnake();
	            		System.out.println("Server: " + id + " angemeldet");	            		
	            		out.writeInt(id);
	            		
	            	}
	            	
	            	if (inputLine.startsWith("GAME OVER")) {
	            		stopNow = true;
	            		System.out.println("Server: game over");
	            	}
	            	
//	            	if (inputLine.endsWith("NEXT STEP")) {
//	            		String[] arr = inputLine.split(" ");
//	            		int nr = Integer.parseInt(arr[0]);	            		
//	            		System.out.println(nr);
//	            		b.gameStep();
//	            		out.writeObject(b);
//	            		
//	            		try {
//							this.sleep(50);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//	            	}
	            	out.writeObject(b);
	            	out.flush();
				}
			}
				
			
			// Aufräumen
			out.close();
			in.close();
			clientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
