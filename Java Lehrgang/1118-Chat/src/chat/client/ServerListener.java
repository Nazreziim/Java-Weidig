package chat.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

import chat.model.InfoType;
import chat.model.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Part of the Client, which listens for Messages from the server.
 * 
 * @author 11248307
 *
 */
public class ServerListener implements Runnable {

  private boolean running;
  private Socket serverSocket;
  private ObservableList< String > userSet;
  private ObservableList< Message > messageList;

  /**
   * ServerListener needs a Socket wich is Connected to the server.
   * 
   * @param server Connected Socket to the server.
   */
  public ServerListener( Socket server ) {
    this.running = false;
    this.serverSocket = server;
    this.messageList = FXCollections.synchronizedObservableList( FXCollections.observableList( new LinkedList<>() ) );
    this.userSet = FXCollections.synchronizedObservableList( FXCollections.observableList( new ArrayList<>() ) );
  }

  /**
   * Cycle of the ServerListener. <br>
   * Start in a Thread(Pool).
   */
  @Override
  public void run() {
    if ( this.running ) {
      throw new IllegalStateException( "ServerListener already running, or something went wrong." );
    }
    this.running = true;

    // InputStream: Waits for messages from Server
    try ( ObjectInputStream ois = new ObjectInputStream( this.serverSocket.getInputStream() ); ) {

      Message msg = null;

      while ( this.running ) {

        try {
          Object o = ois.readObject();
          if ( o instanceof InfoType && (InfoType) o == InfoType.MESSAGE ) {
            o = ois.readObject();
            if ( o instanceof Message ) {
              msg = (Message) o;
              this.messageList.add( msg );
            }
          } else if ( o instanceof InfoType && (InfoType) o == InfoType.USERADD ) {
            o = ois.readObject();
            if ( o instanceof String ) {
              this.userSet.add( (String) o );
            }
          } else if ( o instanceof InfoType && (InfoType) o == InfoType.USERREMOVE ) {
            o = ois.readObject();
            if ( o instanceof String ) {
              this.userSet.remove( (String) o );
            }
          }
        } catch ( IOException e ) {
          // System.err.println( "InputStream wurde geschlossen." );
          this.running = false;
        } catch ( ClassNotFoundException e ) {
          System.err.println( "Unbekanntes Format." );
        }

      }

    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  /**
   * stop the ServerListener.
   */
  public void stop() {
    this.running = false;
  }

  /**
   * Returns an observable List of Users.
   * 
   * @return observable List of Users.
   */
  public ObservableList< String > getUserList() {
    return FXCollections.unmodifiableObservableList( this.userSet );
  }

  /**
   * Returns an observable List of Messages.
   * 
   * @return observable List of Messages.
   */
  public ObservableList< Message > getMessageList() {
    return FXCollections.unmodifiableObservableList( this.messageList );
  }

}
