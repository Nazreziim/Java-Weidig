package chat.stufe1_1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import chat.stufe1_1.client.S1_1Client;
import chat.stufe1_1.server.S1_1Server;

public class S1_1ClientServer {
	public static void main(String... strings) {
		Thread server = new Thread(new Runnable() {
			@Override
			public void run() {
				new S1_1Server(80);
			}
		});
		server.start();

		Thread client = new Thread(new Runnable() {
			@Override
			public void run() {
				new S1_1Client("127.0.0.1", 80, "Stufe1_1 Client Server Test");
			}

		});
		client.start();

	}

}
