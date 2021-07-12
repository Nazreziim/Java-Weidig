package _02SimpleSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class _04SocketChannel {
	public static void main(String[] args) {
		try {
			// Öffnet den neuen Socket Channel
			SocketChannel socket = SocketChannel.open();

			// Verbindet ihn über die genannte Adresse
			socket.connect(new InetSocketAddress("127.0.0.1", 6666));

			/*
			 * Sorgt dafür, dass der Channel NICHT blockiert. Dies bedeutet auch, dass
			 * bereits Operationen ausgeführt werden könnten bevor die Verbindung wirklich
			 * hergestellt ist. Diesen Fall muss man also abfangen.
			 */
			socket.configureBlocking(true);

			while (socket.finishConnect()) {
				ByteBuffer buffer = ByteBuffer.allocate(8192);
				socket.read(buffer);

				System.out.println(new String(buffer.array()));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
