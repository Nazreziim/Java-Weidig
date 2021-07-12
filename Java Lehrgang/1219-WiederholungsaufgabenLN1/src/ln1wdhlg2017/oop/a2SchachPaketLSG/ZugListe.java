package ln1wdhlg2017.oop.a2SchachPaketLSG;

public class ZugListe {

  private Zug start;

  public ZugListe() {
    this.start = null;
  }

  public void add( Koordinate ziel ) {
    this.add( new Zug( ziel ) );
  }

  public void add( Zug zug ) {
    if ( this.start == null ) {
      this.start = zug;
    } else {
      Zug tmp = this.start;
      while ( tmp.hasNext() ) {
        tmp = tmp.getNext();
      }
      tmp.setNext( zug );
    }
  }

  public boolean contains( Koordinate ziel ) {
    return this.contains( new Zug( ziel ) );
  }

  public boolean contains( Zug zug ) {
    boolean contains = false;
    Zug tmp = this.start;
    while ( !contains && tmp != null ) {
      if ( tmp.equals( zug ) ) {
        contains = true;
        tmp = tmp.getNext();
      }
    }
    return contains;
  }

  public void remove( Koordinate ziel ) {
    this.remove( new Zug( ziel ) );
  }

  public void remove( Zug zug ) {
    Zug tmp = this.start;
    if ( tmp != null && tmp.equals( zug ) ) {
      this.start = this.start.getNext();
    } else {
      while ( tmp != null && tmp.hasNext() ) {
        if ( tmp.getNext().equals( zug ) ) {
          tmp.setNext( tmp.getNext().getNext() );
        }
        tmp = tmp.getNext();
      }
    }
  }

  public Zug getStart() {
    return this.start;
  }

}
