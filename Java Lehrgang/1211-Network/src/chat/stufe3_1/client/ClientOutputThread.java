package chat.stufe3_1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientOutputThread extends Thread {

  private Socket server;
  private String name;
  private boolean running;

  public ClientOutputThread( Socket server, String name ) {
    this.server = server;
    this.running = true;
    this.name = name;
  }

  @Override
  public void run() {
    try ( //
            PrintWriter out = new PrintWriter( this.server.getOutputStream(), true );//
    ) {
      BufferedReader console = new BufferedReader( new InputStreamReader( System.in ) );

      String consoleLine;
      while ( this.running ) {
        while ( ( consoleLine = console.readLine() ) != null ) {
          out.println( name + ": " + consoleLine );
        }
      }
    } catch ( IOException e ) {
      System.err.println( "No OutputStream from Server: " + this.server + " availlable." );
    }
  }

  public void shutdown() {
    this.running = false;
  }
}
