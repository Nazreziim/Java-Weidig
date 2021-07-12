package chat.extended.server.model;

import java.time.ZonedDateTime;

public class ChatMessage {

  private static long counter = 0;

  private final long id;
  private final String message;
  private final User autor;
  private final ZonedDateTime clientTimestamp;
  private final ZonedDateTime serverTimestamp;

  public ChatMessage( User autor, String message, ZonedDateTime clientTimestamp ) {
    this.id = ++ChatMessage.counter;
    this.serverTimestamp = ZonedDateTime.now();
    this.clientTimestamp = clientTimestamp;
    this.autor = autor;
    this.message = message;
  }

  private long getId() {
    return this.id;
  }

  public String getMessage() {
    return this.message;
  }

  public User getAutor() {
    return this.autor;
  }

  public ZonedDateTime getClientTimestamp() {
    return this.clientTimestamp;
  }

  public ZonedDateTime getServerTimestamp() {
    return this.serverTimestamp;
  }

  @Override
  public boolean equals( Object obj ) {
    boolean result = false;
    if ( obj != null && obj instanceof ChatMessage && this.id == ( (ChatMessage) obj ).getId() ) {
      result = true;
    }
    return result;
  }
  
  @Override
  public int hashCode() {
    return (int) ( this.id >>> 32 ^ this.id );
  }

}
