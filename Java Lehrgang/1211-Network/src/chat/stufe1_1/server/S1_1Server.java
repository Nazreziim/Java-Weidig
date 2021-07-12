package chat.stufe1_1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class S1_1Server {

  public S1_1Server( int port ) {
    try (
            // Server starten
            ServerSocket serverSocket = new ServerSocket( port );
            // Auf Client Verbindung warten
            Socket clientSocket = serverSocket.accept();
            // InputStream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( clientSocket.getInputStream() ) );
            // OutputStream
            PrintWriter out = new PrintWriter( clientSocket.getOutputStream(), true ); ) {

      String inputLine = in.readLine();
      // Empfangene Nachricht ausgeben.
      System.out.println( "Nachricht: '" + inputLine + "' erhalten." );

      out.println( inputLine );
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String... strings ) {
    // TestServer. Horcht auf Port 80. Debug = true.
    new S1_1Server( 80 );
  }
}
