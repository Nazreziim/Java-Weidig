package chat.stufe1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class S1Server {

  public S1Server( int port ) {
    try (
            // Server starten. Horcht auf angegebenen Port
            ServerSocket serverSocket = new ServerSocket( port );

            // Server wartet auf eine Verbindung
            Socket clientSocket = serverSocket.accept();

            // InputStream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( clientSocket.getInputStream() ) ); ) {

      // Server wartet auf eine Nachricht.
      String inputLine = in.readLine();
      // Empfangene Nachricht ausgeben.
      System.out.println( "Nachricht: '" + inputLine + "' erhalten." );

      // Verbindung schlieﬂen
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String... strings ) {
    // TestServer. Horcht auf Port 80. Debug = true.
    new S1Server( 80 );
  }
}
