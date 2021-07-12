package aufgaben.chat.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class ChatModel extends Observable implements Runnable {
	// Konstanten für Verbindungsstatus
	public final static int NULL = 0;
	public final static int DISCONNECTED = 1;
	public final static int DISCONNECTING = 2;
	public final static int BEGIN_CONNECT = 3;
	public final static int CONNECTED = 4;

	public final static String END_CHAT_SESSION = new Character((char) 0)
			.toString(); // Markiert das Ende einer Übertragung
	private boolean isServer = true;

	// Parameter für die Verbindung
	public static String hostIP = "localhost";
	public static int port = 1234;
	public static int connectionStatus = DISCONNECTED;

	// TCP Components
	public static ServerSocket hostServer = null;
	public static Socket socket = null;
	public static BufferedReader in = null;
	public static PrintWriter out = null;

	private String received;
	private static StringBuffer toAppend = new StringBuffer("");
	private static StringBuffer toSend = new StringBuffer("");

	public ChatModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		while (true) {
			try { // Poll every ~10 ms
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

			switch (this.getConnectionStatus()) {
			case BEGIN_CONNECT:
				try {
					// Try to set up a server if host
					if (isServer) {
						System.out.println("Server: Bin Server");
						hostServer = new ServerSocket(port);
						System.out
								.println("Server: Warte auf eingehende Verbindung: "
										+ hostServer.getInetAddress()
										+ hostServer.getLocalPort());
						socket = hostServer.accept();
						System.out.println("Verbindung aufgebaut: "
								+ socket.getInetAddress() + socket.getPort());
					}

					// If guest, try to connect to the server
					else {
						socket = new Socket(hostIP, port);
						System.out.println("Bin Gast "
								+ socket.getInetAddress() + socket.getPort());
					}

					this.setConnectionStatus(CONNECTED);
					// changeStatusTS(CONNECTED, true);
				}
				// If error, clean up and output an error message
				catch (IOException e) {
					// cleanUp();
					this.setConnectionStatus(DISCONNECTED);
				}
				break;

			case CONNECTED:
				try {
					// Senden
					out = new PrintWriter(socket.getOutputStream(), true);
					if (this.toSend.length() != 0) {
						System.out.println("Sende Daten: " + toSend.toString());
						toSend.append("\n");
						out.print(this.toSend);
						out.flush();
						this.toSend.setLength(0);
						System.out.println("Gesendet!");
						//this.setConnectionStatus(NULL);
					}

					// Empfangen
					in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					if (in.ready()) {
						String s = "";
						s += in.readLine();						
						if ((s != null) && (s.length() != 0)) {
							// Auf Ende der Übertragung prüfen
							if (s.equals(END_CHAT_SESSION)) {
								this.setTextReceived(toAppend.toString());
								this.setConnectionStatus(DISCONNECTING);
							}

							// Text zusammenstellen und an Setter übergeben
							else {
								//System.out.print("Empfange Daten: " + s);
								this.toAppend.append(s);
								this.setTextReceived("INCOMING: "
										+ toAppend.toString() + "\n");
								//this.setConnectionStatus(NULL);
							}
						}
					}
				}

				catch (IOException e) {
					// cleanUp();
					this.setConnectionStatus(DISCONNECTED);
				}
				break;
				
			case DISCONNECTING:
				// Tell other chatter to disconnect as well
				out.print(END_CHAT_SESSION);
				out.flush();

				// Clean up (close all streams/sockets)
				// cleanUp();
				this.setConnectionStatus(DISCONNECTED);
				break;
				
			default:
				break;
			}
		}

	}

	private void setTextReceived(String send) {
		this.received = send;
		this.toAppend = new StringBuffer("");
		this.setChanged();
		this.notifyObservers();
	}

	public String getTextReceived() {
		return this.received;
	}

	public void setSendString(String s) {
		this.toSend.append(s);

	}

	public void setConnected() {
		this.setChanged();
		this.notifyObservers();
	}

	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
		this.setChanged();
		this.notifyObservers();

	}

	public void setPort(int port) {
		this.port = port;
		this.setChanged();
		this.notifyObservers();

	}

	public int getConnectionStatus() {
		return this.connectionStatus;
	}

	public int getPort() {
		return port;
	}

	public String getHostIP() {
		return this.hostIP;
	}

	public void setConnectionStatus(int newConnectStatus) {
		this.connectionStatus = newConnectStatus;
		this.setChanged();
		this.notifyObservers();

	}

	public void setServer(boolean b) {
		this.isServer = b;
	}

	public boolean isServer() {

		return isServer;
	}

}
