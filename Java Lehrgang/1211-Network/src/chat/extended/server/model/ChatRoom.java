package chat.extended.server.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChatRoom {

  private List< ChatMessage > messages;
  private String motd;

  public ChatRoom( String motd ) {
    this.motd = motd;
    this.messages = new LinkedList< ChatMessage >();
  }

  public void send( ChatMessage message ) {
    this.messages.add( message );
  }

  public List< ChatMessage > getMessages() {
    return Collections.unmodifiableList( this.messages );
  }

  public String getMotd() {
    return this.motd;
  }

}
