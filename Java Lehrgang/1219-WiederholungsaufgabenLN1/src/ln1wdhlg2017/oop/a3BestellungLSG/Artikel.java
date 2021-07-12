package ln1wdhlg2017.oop.a3BestellungLSG;

import java.util.Iterator;

class ArtListIterator implements Iterator< ArtElem > {
  private ArtElem next;

  public ArtListIterator( ArtElem start ) {
    this.next = start;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }

  @Override
  public ArtElem next() {
    ArtElem current = next;
    next = next.getNext();
    return current;
  }

}

class ArtList implements Iterable< ArtElem > {
  private ArtElem start;

  public ArtElem getStart() {
    return this.start;
  }

  public void add( Artikel art ) {
    ArtElem tmp = this.start;
    if ( tmp == null ) {
      this.start = new ArtElem( art );
    } else {
      while ( tmp != null && tmp.hasNext() ) {
        tmp = tmp.getNext();
      }
      tmp.setNext( new ArtElem( art ) );
    }
  }

  @Override
  public Iterator< ArtElem > iterator() {
    return new ArtListIterator( this.start );
  }
}

class ArtElem {
  private ArtElem next;
  private Artikel value;

  public ArtElem( Artikel value ) {
    this.value = value;
  }

  public boolean hasNext() {
    return this.next != null;
  }

  public ArtElem getNext() {
    return this.next;
  }

  public void setNext( ArtElem next ) {
    this.next = next;
  }

  public Artikel getValue() {
    return this.value;
  }
}

public abstract class Artikel {

}
