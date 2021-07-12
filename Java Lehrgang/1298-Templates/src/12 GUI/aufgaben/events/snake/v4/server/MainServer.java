package aufgaben.events.snake.v4.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.Timer;



/**
 * Der Server erstellt das Spielbrett (@see Board) und wartet auf Anfragen übers Netzwerk.
 * Bei Bedarf wird für jede Anfrage ein @see ClientSocketThread erstellt und gestartet.
 * @author LGerhard
 *
 */
public class MainServer {

	private Board b;
	
	public MainServer() {
		this.b = new Board(50,50);
		serverStart();
	}
	
	private class TimerActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println("Server: GAMESTEP");
			b.gameStep();
//			System.out.println(b.getSnake(0).getX(0));

		}
	}
	
	private void serverStart() {

			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(1234);
				int zaehler = 0;		
				while (zaehler < 2) {
					Socket clientSocket = serverSocket.accept();
					ClientSocketThread ct = new ClientSocketThread(clientSocket,b);
					ct.start();
					zaehler++;
				}
				Timer timer = new Timer(140, new TimerActionListener());
				timer.start();
//				while (b.isInGame()) {
//					b.gameStep();
//				}
				
				
			} catch (IOException e) {
				System.out.println("Exception caught when trying to listen on port "
		                + "1234" + " or listening for a connection");
		            System.out.println(e.getMessage());
			}
	}
	
	
	
	public static void main(String[] args) { 
		new MainServer();
	}	
	

}
