package _02SimpleSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class _03ServerSocketChannel {
	public static void main(String[] args) {
		try {
			// �ffnet einen neuen ServerSocketChannel der das Bearbeiten von Channels
			// zul�sst
			ServerSocketChannel serverChannel = ServerSocketChannel.open();

			// Bindet den SChannel an eine unter den genannten Port
			serverChannel.bind(new InetSocketAddress(6666));

			/*
			 * Sorgt daf�r, dass der Channel nicht mehr blockiert. Bedeutet: Bei .accept
			 * wird auf die n�chste Verbindung gewartet. Stattdessen wird .accept immer
			 * aufgerufen und liefert null zur�ck wenn keine neue vorhanden ist. Somit muss
			 * man diesen Fall abfangen.
			 */
			serverChannel.configureBlocking(false);

			while (true) {
				SocketChannel socketChannel = serverChannel.accept();
				if (socketChannel != null) {
					ByteBuffer buffer = ByteBuffer.wrap(new String("Willkommen!").getBytes());
					socketChannel.write(buffer);

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
