package _05ObjectServerSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _01ServerMain {

	public static void main(String[] args) {
		// HINWEIS: Sockets immer schlieﬂen [auﬂerhalb des Try deklarieren und ¸ber
		// finally schlieﬂen oder AutoClosable nutzen mittels Try-With-Ressources

		try {
			// Initialisierung
			ServerSocket serverSocket = new ServerSocket(666);
			Socket einClient = serverSocket.accept();

			ObjectOutputStream menschOutputStream = new ObjectOutputStream(einClient.getOutputStream());
			
			ObjectInputStream menschInputStream = new ObjectInputStream(einClient.getInputStream());

			while (true) {
				try {
					Mensch mensch = (Mensch) menschInputStream.readObject();
					
					System.out.println(mensch.getName());
					System.out.println(mensch.getAlter());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
