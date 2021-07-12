package schritt2MitGeneric;

public class Box< T > {
  private T inhalt;

  public Box( T inhalt ) {
    this.setInhalt( inhalt );
  }

  public T getInhalt() {
    return this.inhalt;
  }

  public void setInhalt( T inhalt ) {
    this.inhalt = inhalt;
  }

}
