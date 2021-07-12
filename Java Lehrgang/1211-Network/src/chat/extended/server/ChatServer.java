package chat.extended.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;

import chat.extended.server.model.ChatRoom;
import chat.extended.server.model.Client;
import chat.extended.server.model.ClientList;
import chat.extended.server.model.UserList;

public class ChatServer implements Runnable {

  private ChatRoom room;
  private UserList registeredUsers;
  private ClientList connectedClients;
  private boolean running;
  private int port;
  private String name;
  private String motd;

  public ChatServer( String name, String motd, int port ) {
    System.out.println( "Initializing ChatServer" );
    this.running = true;
    this.port = port;
    this.name = name;
    this.motd = motd;

    System.out.println( "Creating ClientList" );
    this.connectedClients = new ClientList();
    System.out.println( "Creating Userlist" );
    this.registeredUsers = new UserList();
    System.out.println( "Creating Chatroom" );
    ChatRoom room = new ChatRoom( this.motd );

    System.out.println( "Chatserver initialized." );
  }

  @Override
  public void run() {
    System.out.println( "Chatserver starting." );
    try ( ServerSocket serverSocket = new ServerSocket( port ); ) {
      // Timeout für accept() setzen
      serverSocket.setSoTimeout( 1000 );
      while ( running ) { // Prüfen ob Server weiter laufen soll.
        try { // auf Verbindungen warten.
          this.connectedClients.add( new Client( serverSocket.accept() ) );
        } catch ( SocketTimeoutException e ) {
          // Timeout erreicht, prüfen ob Server weiter laufen soll und auf Verbindungen warten.
        }
      }
      System.out.println( "Shutting down Chatserver." );
    } catch ( IOException e ) {
      System.err.println( "The Port is not free." );
    }
    System.out.println( "Server is shut down. Bye..." );
  }

  public void shutdown() {
    this.running = false;
  }

}
