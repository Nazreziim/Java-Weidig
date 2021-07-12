package chat.stufe5.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class ChatRoom extends Observable {

  private List< Message > messages;

  public ChatRoom() {
    this.messages = new LinkedList< Message >();

    try {
      Connection adminConn = DriverManager.getConnection( "jdbc:h2:./db/chat", "DBAdmin", "P@ssw0rd" );
      Statement statement = adminConn.createStatement();
      ResultSet result = statement.executeQuery( "SELECT ID, AUTOR, CONTENT FROM MESSAGES" );

      while ( result.next() ) {
        this.messages.add( new Message( result.getInt( "ID" ), result.getString( "AUTOR" ), result.getString( "CONTENT" ) ) );
      }

      statement.close();
      adminConn.close();
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
  }

  public void post( Message message ) {
    try {
      Connection adminConn = DriverManager.getConnection( "jdbc:h2:./db/chat", "DBAdmin", "P@ssw0rd" );
      Statement statement = adminConn.createStatement();
      statement.execute(
              "INSERT INTO MESSAGES (AUTOR, CONTENT) VALUES( '" + message.getAutor() + "', '" + message.getContent() + "')" );
      statement.close();
      adminConn.close();
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
    this.messages.add( message );
    System.out.println( "ChatRoom: post: " + message );
    this.setChanged();
    this.notifyObservers( message );
  }

  public List< Message > getMessages() {
    return Collections.unmodifiableList( this.messages );
  }

  public void userConnected( String name ) {
    setChanged();
    notifyObservers( new Message( -1, "Server", name + " ist dem Chat beigetreten." ) );
  }

  public void userDisconnected( String name ) {
    setChanged();
    notifyObservers( new Message( -2, "Server", name + " hat den chat verlassen." ) );
  }
}
