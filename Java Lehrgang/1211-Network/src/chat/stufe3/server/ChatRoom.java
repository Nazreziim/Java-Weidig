package chat.stufe3.server;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class ChatRoom extends Observable {

  private List< String > messages;

  public ChatRoom() {
    this.messages = new LinkedList< String >();
  }

  public void post( String message ) {
    this.messages.add( message );
    System.out.println( "ChatRoom: post: " + message );
    this.setChanged();
    this.notifyObservers( message );
  }

  public List< String > getMessages() {
    return Collections.unmodifiableList( this.messages );
  }
}
