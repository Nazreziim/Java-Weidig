package topfSpiel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import topfSpiel.server.BeaconThread;
import topfSpiel.server.SpielThread;

public class ServerMain {

  public static void main( String[] args ) {
    final int MULTICAST_PORT = 666;

    if ( args.length == 1 ) {
      boolean running = true;
      try {
        int port = Integer.parseInt( args[ 0 ] );

        ServerSocket serverSocket = new ServerSocket( port );
        BeaconThread beacon = new BeaconThread( port, "TopfSpiel", "224.0.11.60", MULTICAST_PORT );
        beacon.start();

        while ( running ) {
          Socket clientSocket1 = serverSocket.accept();
          Socket clientSocket2 = serverSocket.accept();

          SpielThread spielThread = new SpielThread( clientSocket1, clientSocket2 );
          spielThread.start();
        }
        
        beacon.shutdown();
        serverSocket.close();

      } catch ( NumberFormatException e ) {
        System.err.println( "The Port has to be an Integer." );
      } catch ( IOException e ) {
        System.err.println( "The Port is not availlable." );
      }
    }
  }

}
