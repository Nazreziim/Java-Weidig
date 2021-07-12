package chat.stufe2_1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MCClient {

  private static long counter = 0;

  private long id;

  public MCClient( String server, int port ) {
    this.id = ++MCClient.counter;
    try (
            // Verbindung zum Server herstellen
            Socket serverSocket = new Socket( server, port );
            // OutputStreeam
            PrintWriter out = new PrintWriter( serverSocket.getOutputStream(), true );
            // InputStream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( serverSocket.getInputStream() ) ); ) {
      // Nachricht senden
      String message = "Hi, this is: MCClient #" + this.id + " on Thread: "
              + Thread.currentThread().getName() + ".";
      out.println( message );
      System.out.println( "Client: " + message );

      // Antwort empfangen
      String inputLine = in.readLine();
      System.out.println( "Server: " + inputLine.toString() );

      message = "Am I talking to echo?";
      out.println( message );
      System.out.println( "Client: " + message );

      inputLine = in.readLine();
      System.out.println( "Server: " + inputLine.toString() );

      message = "Do you understand me?";
      out.println( message );
      System.out.println( "Client: " + message );

      inputLine = in.readLine();
      System.out.println( "Server: " + inputLine.toString() );

      message = "Maybe wrong connection?";
      out.println( message );
      System.out.println( "Client: " + message );

      inputLine = in.readLine();
      System.out.println( "Server: " + inputLine.toString() );

      message = "Bye";
      out.println( message );
      System.out.println( "Client: " + message );

      inputLine = in.readLine();
      System.out.println( "Server: " + inputLine.toString() );

    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public static void main( String... strings ) {
    // Test Client erstellen. Server = 127.0.0.1, Nachricht = Test Test, debug = true.
    new MCClient( "127.0.0.1", 80 );
  }

}
