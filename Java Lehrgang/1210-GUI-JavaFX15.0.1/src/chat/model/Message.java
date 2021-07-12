package chat.model;

import java.io.Serializable;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message implements Serializable {

  private static final long serialVersionUID = 100L;

  private LocalDateTime localDateTime;
  private String user;
  private String msg;
  private InetAddress ipSender;

  public Message( String user, String msg, LocalDateTime localDateTime, InetAddress ipSender ) {
    this.user = user;
    this.msg = msg;
    this.localDateTime = localDateTime;
    this.ipSender = ipSender;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append( "[" + this.localDateTime.format( DateTimeFormatter.ofPattern( "uuuu-MM-dd HH:mm:ss" ) ) + "] " );
    sb.append( this.user + ": " );
    sb.append( this.msg );
    return sb.toString();
  }

  public String getMsg() {
    return this.msg;
  }

  public String getUser() {
    return this.user;
  }

}
