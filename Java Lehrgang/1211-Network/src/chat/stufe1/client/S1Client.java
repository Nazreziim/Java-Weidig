package chat.stufe1.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class S1Client {

  public S1Client( String server, int port, String message ) {
    try (
            // Verbindung zum Server aufbauen
            Socket serverSocket = new Socket( server, port );

            // Writer erstellen
            PrintWriter out = new PrintWriter( serverSocket.getOutputStream(), true ); //
    ) {
      // Nachricht senden.
      out.println( message );

      // Verbindung schlieﬂen
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String... strings ) {
    // Test Client erstellen. Server = 127.0.0.1, Port = 80, Nachricht = Test Test, debug = true.
    new S1Client( "127.0.0.1", 80, "Test Test" );
  }
}
