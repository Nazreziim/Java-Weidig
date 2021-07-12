package chat.stufe5.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ClientThread extends Thread implements Observer {

  private final Socket clientSocket;
  private BufferedReader in;
  private PrintWriter out;
  private String name;
  private ChatRoom chatRoom;
  private boolean running;

  public ClientThread( ChatRoom chatRoom, Socket clientSocket ) {
    this.clientSocket = clientSocket;
    this.chatRoom = chatRoom;
    this.chatRoom.addObserver( this );
    try {
      this.out = new PrintWriter( this.clientSocket.getOutputStream(), true );
      this.in = new BufferedReader( new InputStreamReader( this.clientSocket.getInputStream() ) );
      this.name = in.readLine();
      System.out.println( this.name + " hat sich angemeldet." );
    } catch ( IOException e ) {
      System.err.println( "No OutputStream from Server: " + this.clientSocket + " availlable." );
    }
    this.running = true;
  }

  @Override
  public void run() {
    try {
      for ( Message m : this.chatRoom.getMessages() ) {
        this.out.println( m.toString() );
      }
      this.chatRoom.userConnected( this.name );
      String inputLine;
      Message newMessage;
      while ( ( inputLine = in.readLine() ) != null ) {
        newMessage = new Message( this.name, inputLine );
        this.chatRoom.post( newMessage );
        System.out.println( newMessage.toString() );
      }
      this.chatRoom.userDisconnected( this.name );
      this.chatRoom.deleteObserver( this );
    } catch ( IOException e ) {
      System.err.println( "No InputStream from Server: " + this.clientSocket + " availlable." );
    }
    this.chatRoom.deleteObserver( this );
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
