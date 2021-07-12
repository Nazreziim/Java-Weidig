package alt.aufgaben.events.snake.v4.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import alt.aufgaben.events.snake.v4.server.Board;

public class MainClient extends Thread {
	
	private int nr;
	private Board b;
	private PrintWriter out;
	private ObjectInputStream in;
	private Socket serverSocket;
	
	public MainClient() {
		socketStart();
	}
	
	/**
	 * Verbindungsaufbau
	 */
	private void socketStart() {
		String hostName = "127.0.0.1";
        int portNumber = 1234;
 
        try  {
        	serverSocket = new Socket(hostName, portNumber);
        	out = new PrintWriter(serverSocket.getOutputStream(), true);
        	in = new ObjectInputStream(serverSocket.getInputStream());
        	
        	// Anmelden als neue Schlange
        	out.println("NEW CLIENT");
        	nr = in.readInt();        	        
        	System.out.println(nr + " angemeldet");        	
        	
//        	String fromServer;
//            if ((fromServer = in.readLine()) != null) {
//                System.out.println("Server: " + fromServer);
//                this.nr = Integer.parseInt(fromServer);
//
//            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
	}
	
	@Override
	public void run() {
		while (true) {
        	try {
				this.b = (Board)in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
			

	public void sendTurnDown() {
		out.println(nr + " TURN DOWN");
		
	}

	public void sendTurnLeft() {
		out.println(nr + " TURN LEFT");
		
	}

	public void sendTurnUp() {
		out.println(nr + " TURN UP");
		
	}

	public void sendTurnRight() {
		out.println(nr + " TURN RIGHT");
		
	}

//	public void sendGameStep() {
//		out.println(nr + " NEXT STEP");
//		try {
//			this.b = (Board)in.readObject();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public Board getBoard() {
		return this.b;
	}
	
	public static void main(String[] args) {
		MainClient c = new MainClient();
		new FrameSnake(c);
		c.start();
		
	}

}
