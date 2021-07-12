package ln1wdhlg2017.oop.a2SchachPaketLSG;

public class Zug {

  private Zug next;
  private Koordinate ziel;

  public Zug( Koordinate ziel ) {
    this.ziel = ziel;
  }

  public boolean hasNext() {
    return next != null;
  }

  public Zug getNext() {
    return this.next;
  }

  public void setNext( Zug next ) {
    this.next = next;
  }

  public Koordinate getZiel() {
    return this.ziel;
  }

  @Override
  public boolean equals( Object o ) {
    boolean equals = false;
    if ( o != null && o instanceof Zug ) {
      Zug z = (Zug) o;
      equals = this.ziel.equals( z.getZiel() );
    }
    return equals;
  }

}
