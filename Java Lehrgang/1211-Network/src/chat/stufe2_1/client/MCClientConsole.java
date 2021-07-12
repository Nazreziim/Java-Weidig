package chat.stufe2_1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MCClientConsole {

  public MCClientConsole( String server, int port ) {
    try (
            // Verbindung zum Server herstellen
            Socket serverSocket = new Socket( server, port );
            // OutputStreeam
            PrintWriter out = new PrintWriter( serverSocket.getOutputStream(), true );
            // InputStream
            BufferedReader in = new BufferedReader( new InputStreamReader( serverSocket.getInputStream() ) );
            BufferedReader console = new BufferedReader( new InputStreamReader( System.in ) );//
    ) {
      System.out.println( "Verbindung hergestellt. Sie können jetzt mit dem Server kommunizieren." );
      System.out.println( "Zum Beenden sagen Sie: \"Bye\"" );

      String consoleLine;
      String inputLine;
      boolean connectionClosed = false;
      while ( !connectionClosed && ( consoleLine = console.readLine() ) != null ) {
        System.out.println( "Client: " + consoleLine );
        out.println( consoleLine );
        inputLine = in.readLine();
        System.out.println( "Server: " + inputLine );
        if ( inputLine.equalsIgnoreCase( "Bye Bye..." ) ) {
          connectionClosed = true;
        }
      }
    } catch ( IOException e ) {
      e.printStackTrace();
    }
    System.out.println( "Vernindung getrennt. Einen schönen Tag noch." );
  }

  public static void main( String... strings ) {
    // Test Client erstellen. Server = 127.0.0.1, Nachricht = Test Test, debug = true.
    new MCClientConsole( "127.0.0.1", 80 );
  }

}
