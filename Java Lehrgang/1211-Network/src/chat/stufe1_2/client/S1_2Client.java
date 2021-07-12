package chat.stufe1_2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class S1_2Client {

  public S1_2Client( String server, int port, String message ) {
    try (
            // Verbindung zum Server herstellen
            Socket serverSocket = new Socket( server, port );
            // OutputStreeam
            PrintWriter out = new PrintWriter( serverSocket.getOutputStream(), true );
            // InputStream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( serverSocket.getInputStream() ) ); ) {
      // Nachricht senden
      out.println( message );
      System.out.println( "Client: " + message );

      // Antwort empfangen
      String inputLine = in.readLine();
      System.out.println( "Server: " + inputLine.toString() );
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String... strings ) {
    // Test Client erstellen. Server = 127.0.0.1, Nachricht = Test Test, debug = true.
    new S1_2Client( "127.0.0.1", 80, "Test Test" );
  }
}
