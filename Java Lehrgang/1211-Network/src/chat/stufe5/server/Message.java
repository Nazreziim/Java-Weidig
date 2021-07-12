package chat.stufe5.server;

public class Message {
  private static int counter = 0;
  private final int id;
  private final String autor;
  private final String content;

  public Message( String autor, String content ) {
    this.id = ++counter;
    this.autor = autor;
    this.content = content;
  }

  Message( int id, String autor, String content ) {
    this.id = id;
    this.autor = autor;
    this.content = content;
  }

  public String getAutor() {
    return this.autor;
  }

  public String getContent() {
    return this.content;
  }

  public int getID() {
    return this.id;
  }

  public String toString() {
    return this.autor + ": " + this.content;
  }
}
