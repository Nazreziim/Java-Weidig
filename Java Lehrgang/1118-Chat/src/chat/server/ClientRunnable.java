package chat.server;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import chat.model.InfoType;
import chat.model.Message;

public class ClientRunnable implements Runnable, PropertyChangeListener {

  private Socket clientSocket;
  private List< ChatRoom > chatRooms;
  private ChatRoom currentChatroom;

  private ObjectOutputStream oos;
  private Message lastMessage;
  private String currentUser;

  public ClientRunnable( Socket clientSocket, List< ChatRoom > chatRooms ) {
    this.clientSocket = clientSocket;
    this.chatRooms = chatRooms;
    this.currentChatroom = this.chatRooms.get( 0 );
  }

  @Override
  public void run() {

    // InputStream: Liest Nachrichten vom Client
    try ( ObjectInputStream ois = new ObjectInputStream( clientSocket.getInputStream() ); ) {

      // OutputStream: Schreibt Nachrichten an den Client
      this.oos = new ObjectOutputStream( clientSocket.getOutputStream() );

      this.currentChatroom.addPropertyChangeListener( this );

      this.sendUserList();

      for ( Message msg : this.currentChatroom.getMessages() ) {
        this.sendMessage( msg );
      }

      Object o = null;
      do {
        try {
          o = ois.readObject();

          if ( o instanceof InfoType && (InfoType) o == InfoType.MESSAGE ) {
            o = ois.readObject();
            if ( o instanceof Message ) {
              this.lastMessage = (Message) o;
              this.currentChatroom.sendMessage( this.lastMessage );
            }
          } else if ( o instanceof InfoType && (InfoType) o == InfoType.USERNAME ) {
            o = ois.readObject();
            if ( o instanceof String ) {
              if ( this.currentUser != null ) {
                this.currentChatroom.removeUser( this.currentUser );
              }
              this.currentUser = (String) o;
              this.currentChatroom.addUser( this.currentUser );
            }
          }

        } catch ( ClassNotFoundException e ) {
          System.err.println( "Klasse unbekannt." );
        }

      } while ( this.lastMessage == null || ( this.lastMessage != null && !this.lastMessage.getMsg().startsWith( "BYE" ) ) );

    } catch ( IOException e ) {
      System.err.println( "ClientRunnable: Abbruch, wahrscheinlich ist die Verbindung verloren gegangen." );
      e.printStackTrace();
    } finally {
      try {
        this.currentChatroom.removePropertyChangeListener( this );
        this.oos.close();
        this.clientSocket.close();
      } catch ( IOException e ) {
        e.printStackTrace();
      }
      this.currentChatroom.removeUser( this.currentUser );
      this.oos = null;
    }

  }

  @Override
  public void propertyChange( PropertyChangeEvent evt ) {
    if ( evt.getSource() instanceof ChatRoom ) {
      if ( evt.getPropertyName().equals( "Messages" ) && evt.getNewValue() instanceof Message ) {
        Message msg = ( (Message) evt.getNewValue() );
        this.sendMessage( msg );
      } else if ( evt.getPropertyName().equals( "Users" ) ) {
        if ( evt.getOldValue() == null && evt.getNewValue() instanceof String ) {
          this.sendUserUpdate( InfoType.USERADD, (String) evt.getNewValue() );
        } else if ( evt.getOldValue() instanceof String ) {
          this.sendUserUpdate( InfoType.USERREMOVE, (String) evt.getOldValue() );
        }
      }
    }
  }

  private void sendMessage( Message msg ) {
    if ( this.oos != null ) {
      try {
        this.oos.writeObject( InfoType.MESSAGE );
        this.oos.writeObject( msg );
      } catch ( Exception e ) {
        System.err.println( "Message: " + msg + " konnte nicht gesendet werden." );
      }
    }
  }

  private void sendUserUpdate( InfoType infoType, String userName ) {
    if ( this.oos != null ) {
      try {
        this.oos.writeObject( infoType );
        this.oos.writeObject( userName );
      } catch ( IOException e ) {
        System.err.println( "Username: " + userName + " konnte nicht gesendet werden." );
      }
    }
  }

  private void sendUserList() {
    if ( this.oos != null && this.currentChatroom != null && this.currentChatroom.getCurrentUsers() != null ) {
      ArrayList< String > tmpList = new ArrayList< String >( this.currentChatroom.getCurrentUsers() );
      try {
        for ( String user : tmpList ) {
          this.oos.writeObject( InfoType.USERADD );
          this.oos.writeObject( user );
        }
      } catch ( IOException e ) {
        System.err.println( "Das Senden der UserListwurde abgebrochen." );
      }
    }
  }

}
