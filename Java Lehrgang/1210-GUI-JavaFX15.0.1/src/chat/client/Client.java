package chat.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;

import chat.model.InfoType;
import chat.model.Message;
import chat.server.Server;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

/**
 * Clientside of a simple Chat-System with Client/Server-Architecture.
 * 
 * @author 11248307
 * 
 * @see Server
 *
 */
public class Client {

  private String userName;
  private String ipAddress;
  private int port;

  private ObjectOutputStream oos;
  private ServerListener serverListener;
  private Socket serverSocket;
  private boolean connected;

  /**
   * Create a new Clientinstance.
   * 
   * @param userName Username for the Chat.
   * @param ipAddress IP-Address of the Server.
   * @param port TCP-Port of the Server.
   */
  public Client( String userName, String ipAddress, int port ) {
    this.userName = userName;
    this.ipAddress = ipAddress;
    this.setPort( port );
    this.connected = false;
  }

  /**
   * Connect this Client to the specified (sonstructor) server
   */
  public void connect() {

    // Verbindung mit dem Server aufbauen
    try {
      this.serverSocket = new Socket( this.ipAddress, this.port );

      // PrintWriter
      this.oos = new ObjectOutputStream( this.serverSocket.getOutputStream() );

      // ServerListener
      this.serverListener = new ServerListener( this.serverSocket );
      Thread t = new Thread( this.serverListener );
      t.start();

      this.oos.writeObject( InfoType.USERNAME );
      this.oos.writeObject( userName );

      this.connected = true;

    } catch ( IOException e ) {
      e.printStackTrace();
    }

  }

  /**
   * Disconnect this Client from the server
   */
  public void disconnect() {
    this.connected = false;

    serverListener.stop();

    try {
      this.oos.close();
      this.serverSocket.close();
    } catch ( IOException e ) {
      e.printStackTrace();
    }
    this.oos = null;
  }

  /**
   * Send Message to Server
   * 
   * @param message The Message to be sent.
   */
  public void sendMessage( String message ) {
    if ( !this.connected || this.oos == null ) {
      throw new IllegalStateException( "Connection closed." );
    }
    try {
      this.oos.writeObject( InfoType.MESSAGE );
      this.oos.writeObject( new Message( this.userName, message, LocalDateTime.now(), this.serverSocket.getLocalAddress() ) );
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  /**
   * Sets the Serverport.
   * 
   * @param port TCP Port for the server
   * @throws IllegalArgumentException if port is out of range
   */
  private void setPort( int port ) {
    if ( port < 0 && port > 65535 ) {
      throw new IllegalArgumentException( "Port out of range. (0..65535)" );
    }
    this.port = port;
  }

  /**
   * Returns an observable List with the Messages.
   * 
   * @return observable List of Messages.
   */
  public ObservableList< Message > getMessageList() {
    if ( this.serverListener == null ) {
      throw new IllegalStateException( "something went wrong" );
    }
    return this.serverListener.getMessageList();
  }

  /**
   * Returns an observable List with the current users.
   * 
   * @return observable List with current Users.
   */
  public ObservableList< String > getUserList() {
    if ( this.serverListener == null ) {
      throw new IllegalStateException( "something went wrong" );
    }
    return this.serverListener.getUserList();
  }

}
