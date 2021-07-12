package chat.stufe2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;

public class S2Server {

  private List< ClientThread > clients;

  public S2Server( int port ) {
    clients = new LinkedList< ClientThread >();
    try (
            // Server starten
            ServerSocket serverSocket = new ServerSocket( port ); ) {

      while ( clients.size() < 10 ) {
        ClientThread client = new ClientThread( serverSocket.accept() );
        clients.add( client );
        client.start();
      }

    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String... strings ) {
    new S2Server( 80 );
  }
}
