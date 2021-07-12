package chat.server;

public class Box< T > {

  private T data;

  public Box( T data ) {
    this.setdata( data );
  }

  public T getdata() {
    return data;
  }

  public void setdata( T data ) {
    this.data = data;
  }

}
