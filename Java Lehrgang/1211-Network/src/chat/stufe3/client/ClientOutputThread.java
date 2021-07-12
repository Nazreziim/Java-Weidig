package chat.stufe3.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientOutputThread extends Thread {

  private Socket server;
  private boolean running;

  public ClientOutputThread( Socket server ) {
    this.server = server;
    this.running = true;
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
          out.println( consoleLine );
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
