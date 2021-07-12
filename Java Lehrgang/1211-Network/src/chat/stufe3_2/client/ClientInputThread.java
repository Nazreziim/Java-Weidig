package chat.stufe3_2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientInputThread extends Thread {

  private final Socket server;
  private boolean running;

  public ClientInputThread( Socket server ) {
    this.server = server;
    this.running = true;
  }

  @Override
  public void run() {
    try ( //
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( this.server.getInputStream() ) );//
    ) {
      String inputLine;
      while ( this.running ) {
        while ( ( inputLine = in.readLine() ) != null ) {
          System.out.println( inputLine );
        }
      }

    } catch ( IOException e ) {
      System.err.println( "No InputStream from Server: " + this.server + " availlable." );
    }
  }

  public void shutdown() {
    this.running = false;
  }
}
