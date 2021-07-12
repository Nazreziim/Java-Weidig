package mvc_basic.model;

public class ZahlEinfach {
  private Integer zahl;

  public ZahlEinfach() {
    this.zahl = Integer.valueOf( 0 );
  }

  public ZahlEinfach( int zahl ) {
    this.zahl = Integer.valueOf( zahl );
  }

  public ZahlEinfach( Integer zahl ) {
    this.zahl = zahl;
  }

  public Integer getZahl() {
    return this.zahl;
  }

  public void add( Integer b ) {
    this.zahl += b;
  }

  public void sub( Integer b ) {
    this.zahl -= b;
    if ( this.zahl < 0 ) {
      this.zahl = 0;
    }
  }

  public void increment() {
    ++this.zahl;
  }

  public void decrement() {
    --this.zahl;
    if ( this.zahl < 0 ) {
      this.zahl = 0;
    }
  }

}
