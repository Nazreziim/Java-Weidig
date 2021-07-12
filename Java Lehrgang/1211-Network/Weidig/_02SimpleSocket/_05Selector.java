package _02SimpleSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class _05Selector {

	/*
	 * ENORMER NIO VORTEIL: EIN Thread kann mehrere Channels bzw. mehrere
	 * Netzwerkverbindungen gleichzeitig verarbeiten / bearbeiten
	 */

	public static void main(String[] args) {
		try {
			// Selector öffnen (ähnliches Verhalten wie Channel)
			Selector selector = Selector.open();
			SocketChannel channel1 = SocketChannel.open();
			SocketChannel channel2 = SocketChannel.open();
			channel1.connect(new InetSocketAddress("127.0.0.1", 6666));
			channel2.connect(new InetSocketAddress("127.0.0.1", 6666));

			/*
			 * Die Channels MÜSSEN im non-Blocking Modus sein um einem Selector zugeordnet
			 * zu werden, da dieser ansonsten permanent geblockt wäre [nicht zulässig]
			 */
			channel1.configureBlocking(false);
			channel2.configureBlocking(false);
			
			/*
			 * SelectionKeys definieren die benötigte Möglichkeit der zugewiesenen
			 * Channels und wie sie auf dem Selector registriert sind: 
			 * - Connect: Ein Channel der bereit ist sich mit einem anderen Server
			 * zu verbinden ist "Connect-Ready" 
			 * - Accept: Ein ServerSocketChannel welcher die Verbindung eines neuen 
			 * Channels akzeptiert ist "Accept-Ready" 
			 * - Read: Lesebereiter Channel ist "Ready-Ready" 
			 * - Write: Schreibbereiter Channel ist "Write-Ready"
			 */
			SelectionKey key1 = channel1.register(selector, SelectionKey.OP_READ);
			SelectionKey key2 = channel2.register(selector, SelectionKey.OP_WRITE);
			
			
			/*************** Was kann dieser Key? ***************/
			
			// 1. Die Interessen - Gibt den Zahlwert zurück, der festgelegt ist entsprechend
			// der statischen Auswahl [interesse = 1 -> ...OP_READ hat den Zahlwert 1]
			int interesse = key1.interestOps();
			
			System.out.println("Interessen Key1:");
			System.out.println(interesse);
			System.out.println(interesse = SelectionKey.OP_ACCEPT);
			System.out.println(interesse = SelectionKey.OP_CONNECT);
			System.out.println(interesse = SelectionKey.OP_READ);
			System.out.println(interesse = SelectionKey.OP_WRITE);

			System.out.println("Interessen Key2:");
			int interesse2 = key2.interestOps();
			System.out.println(interesse2);
			System.out.println(interesse = SelectionKey.OP_ACCEPT);
			System.out.println(interesse = SelectionKey.OP_CONNECT);
			System.out.println(interesse = SelectionKey.OP_READ);
			System.out.println(interesse = SelectionKey.OP_WRITE);
			
			//2. Ein Objekt anhängen [JA EIN OBJEKT]
			key1.attach(new String("Ich bin das Objekt von Key1"));
			key2.attach(new String("Ich bin das Objekt von Key2"));
			
			System.out.println((String) key1.attachment());
			System.out.println((String) key2.attachment());
			
			// 3. Auswahl der entsprechenden Channels (?)
			/*
			 * SelectMethoden:
			 * - select() --> blockt solange bis irgendein Channel für das registrierte Event bereit ist
			 * - select(long timeout) --> blockt für eine maximale Zeit
			 * - selectNow() --> blockt NICHT und liefert sofort alle bereiten Channels zurück
			 */
			
			System.out.println("Menge bereiter Channels: " + selector.selectNow());
			
			Set<SelectionKey> registrierteKeys = selector.selectedKeys();

			for (SelectionKey einKey : registrierteKeys) {
				if (einKey.isAcceptable()) {
					System.out.println("Eine Verbindung wurde durch einen ServerSocketChannel akzeptiert.");

				} else if (einKey.isConnectable()) {
					System.out.println("Jemand at sich erfolgreich mit einem ServerSocketChannel verbunden.");

				} else if (einKey.isReadable()) {
					System.out.println("Ein Channel ist bereit zum Lesen.");

				} else if (einKey.isWritable()) {
					System.out.println("Ein Channel ist bereit zum Schreiben.");
				}
			}
			
//			Iterator<SelectionKey> keyIterator = registrierteKeys.iterator();
//
//			while(keyIterator.hasNext()) {
//			    
//			    SelectionKey key = keyIterator.next();
//
//			    if (key.isAcceptable()) {
//					System.out.println("Eine Verbindung wurde durch einen ServerSocketChannel akzeptiert.");
//
//				} else if (key.isConnectable()) {
//					System.out.println("Jemand at sich erfolgreich mit einem ServerSocketChannel verbunden.");
//
//				} else if (key.isReadable()) {
//					System.out.println("Ein Channel ist bereit zum Lesen.");
//
//				} else if (key.isWritable()) {
//					System.out.println("Ein Channel ist bereit zum Schreiben.");
//				}
//
//			    keyIterator.remove();
//			}
			
			
			selector.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
