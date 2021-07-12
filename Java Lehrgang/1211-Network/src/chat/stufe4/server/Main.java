package chat.stufe4.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

  public static void main( String[] args ) {
    final int MULTICAST_PORT = 666;

    if ( args.length == 1 ) {
      boolean running = true;
      ChatRoom chat = new ChatRoom();
      try {
        int port = Integer.parseInt( args[ 0 ] );

        ServerSocket serverSocket = new ServerSocket( port );
        BeaconThread beacon = new BeaconThread( port, "TestServer", "224.0.11.60", MULTICAST_PORT );
        beacon.start();

        while ( running ) {
          Socket clientSocket = serverSocket.accept();
          ClientThread clientThread = new ClientThread( chat, clientSocket );
          clientThread.start();
        }

        serverSocket.close();

      } catch ( NumberFormatException e ) {
        System.err.println( "The Port has to be an Integer." );
      } catch ( IOException e ) {
        System.err.println( "The Port is not availlable." );
      }
    }
  }

}
