package aufgaben.chat.v3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Server {
	private static int min = 1;
	private static int actual = min;
	private static int max = 50;
	private static boolean started = false;
	private static ArrayList<Socket> clientSockets = new ArrayList<>();
	
	private static void serverStart() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ServerSocket serverSocket = new ServerSocket(3214);
					while(actual < max) {
						Socket clientSocket = serverSocket.accept();
						System.out.println("Client " + clientSocket.getInetAddress().getHostName() + " @ " + clientSocket.getInetAddress().getHostAddress() + " connected");
						clientSockets.add(clientSocket);
						actual++;
						if (!started) {
							serverWork();
							started = true;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		th.start();
		System.out.println("Server started");
	}
	
	
	private static void serverWork() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				int removeClientWithIndex = 0;
				while(true) {
					if (removeClientWithIndex != 0) {
						clientSockets.remove(removeClientWithIndex);
						removeClientWithIndex = 0;
					} else {
						for (Socket socket : clientSockets) {
							BufferedReader in;
							try {
								in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								String s = "";
								while(in.ready()) {
									s+=in.readLine();
								}
								if (s.length() > 0) {
									if (s.equalsIgnoreCase("disconnect")) {
										clientSockets.remove(socket);
										int count = 1;
										for (Socket socketToCheckForRemove : clientSockets) {
											if (removeClientWithIndex == 0 && socket.equals(socketToCheckForRemove)) {
												removeClientWithIndex = count;
											}
											count++;
										}
									} else {
										sendAllClientsMessage(s);	
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("standing by...");	
					}
					
				}
			}
		});
		th.start();
		System.out.println("Server ready");
	}

	private static void sendAllClientsMessage(String nachricht) {
		for (Socket socket : clientSockets) {
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write(nachricht+"\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		serverStart();
	}
}
