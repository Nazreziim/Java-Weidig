package uebung2.model;

import java.util.Observable;

public class Ganzzahl extends Observable {
  private Integer zahl;

  public Ganzzahl() {
    this.zahl = Integer.valueOf( 0 );
  }

  public Ganzzahl( Integer zahl ) {
    this.zahl = zahl;
  }

  public void add( Integer a ) {
    this.zahl += a;
    this.setChanged();
    this.notifyObservers();
  }

  public void sub( Integer a ) {
    this.zahl -= a;
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
    this.setChanged();
    this.notifyObservers();
  }

  public Integer getZahl() {
    return this.zahl;
  }

}
