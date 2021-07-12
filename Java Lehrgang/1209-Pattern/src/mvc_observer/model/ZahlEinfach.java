package mvc_observer.model;

import java.util.Observable;

public class ZahlEinfach extends Observable {
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
    this.setChanged();
    this.notifyObservers();
  }

  public void sub( Integer b ) {
    this.zahl -= b;
    if ( this.zahl < 0 ) {
      this.zahl = 0;
    }
    this.setChanged();
    this.notifyObservers();
  }

  public void increment() {
    ++this.zahl;
    this.setChanged();
    this.notifyObservers();
  }

  public void decrement() {
    --this.zahl;
    if ( this.zahl < 0 ) {
      this.zahl = 0;
    }
    this.setChanged();
    this.notifyObservers();
  }

}
