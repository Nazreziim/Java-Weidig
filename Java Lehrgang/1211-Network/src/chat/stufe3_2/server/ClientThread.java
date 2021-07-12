package chat.stufe3_2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ClientThread extends Thread implements Observer {
  private Socket clientSocket;
  private PrintWriter out;
  private ChatRoom chat;
  private boolean running;

  public ClientThread( ChatRoom chat2, Socket clientSocket ) {
    this.clientSocket = clientSocket;
    this.chat = chat2;
    this.chat.addObserver( this );
    try {
      this.out = new PrintWriter( this.clientSocket.getOutputStream(), true );
    } catch ( IOException e ) {
      System.err.println( "No OutputStream from Server: " + this.clientSocket + " availlable." );
    }
    this.running = true;
  }

  @Override
  public void run() {
    for ( String message : chat.getMessages() ) {
      out.println( message );
    }

    try ( BufferedReader in = new BufferedReader(
            new InputStreamReader( clientSocket.getInputStream() ) ); ) {
      String inputLine;
      while ( this.running ) {
        while ( ( inputLine = in.readLine() ) != null ) {
          this.chat.post( inputLine );
          System.out.println( clientSocket + ": " + inputLine );
        }
      }
    } catch ( IOException e ) {
      System.err.println( "No InputStream from Server: " + this.clientSocket + " availlable." );
    }
    this.chat.deleteObserver( this );
  }

  @Override
  public void update( Observable o, Object arg ) {
    if ( o instanceof ChatRoom && arg instanceof String ) {
      if ( out != null && arg != null ) {
        System.out.println( "Sending back: " + (String) arg );
        out.println( (String) arg );
      }
    }
  }
}
