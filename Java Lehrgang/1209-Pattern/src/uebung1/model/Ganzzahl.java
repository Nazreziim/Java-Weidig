package uebung1.model;

public class Ganzzahl {
  private Integer zahl;

  public Ganzzahl() {
    this.zahl = Integer.valueOf( 0 );
  }

  public Ganzzahl( Integer zahl ) {
    this.zahl = zahl;
  }

  public void add( Integer a ) {
    this.zahl += a;
  }

  public void sub( Integer a ) {
    this.zahl -= a;
  }

  public void increment() {
    ++this.zahl;
  }

  public void decrement() {
    --this.zahl;
  }

  public Integer getZahl() {
    return this.zahl;
  }

}
