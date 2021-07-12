package chat.stufe3.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) {

		try {

			byte[] addrBytes = new byte[4];
			addrBytes[0] = 127;
			addrBytes[1] = 0;
			addrBytes[2] = 0;
			addrBytes[3] = 1;
			InetAddress addr = InetAddress.getByAddress(addrBytes);

			Socket server = new Socket(addr, 80);

			Thread inputThread = new ClientInputThread(server);
			Thread outputThread = new ClientOutputThread(server);
			inputThread.start();
			outputThread.start();
		} catch (UnknownHostException e) {
			System.err.println("IPv4 address broken.");
		} catch (NumberFormatException e) {
			System.err.println("The Port has to be an Integer.");
		} catch (IOException e) {
			System.err.println("The Server does not respond");
		}
	}

}
