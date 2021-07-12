package chat.stufe2_1.server;

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
      boolean bye = false;
      String inputLine;
      while ( ( inputLine = in.readLine() ) != null && !bye ) {
        if ( inputLine.equalsIgnoreCase( "BYE" ) ) {
          bye = true;
          out.println( "Bye Bye..." );
        } else {
          out.println( "Message: '" + inputLine + "' received." );
        }
      }
    } catch ( IOException e ) {
    }
  }

}
