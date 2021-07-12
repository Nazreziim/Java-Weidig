package chat.stufe2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

  private Socket client;

  public ClientThread( Socket client ) {
    this.client = client;
  }

  @Override
  public void run() {
    try ( //
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( client.getInputStream() ) );
            PrintWriter out = new PrintWriter( client.getOutputStream(), true );//
    ) {
      String inputLine;
      while ( ( inputLine = in.readLine() ) != null ) {
        out.println( "Message: '" + inputLine + "' received." );
      }
    } catch ( IOException e ) {
      System.err.println( "InputStream nicht verfügbar." );
    }
  }

}
