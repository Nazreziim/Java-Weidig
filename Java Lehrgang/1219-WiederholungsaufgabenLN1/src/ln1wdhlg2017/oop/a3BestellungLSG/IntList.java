package ln1wdhlg2017.oop.a3BestellungLSG;

import java.util.Iterator;

class IntListIterator implements Iterator< IntElem > {
  private IntElem next;

  public IntListIterator( IntElem start ) {
    this.next = start;
  }

  @Override
  public boolean hasNext() {
    return next != null;
  }

  @Override
  public IntElem next() {
    IntElem current = next;
    next = next.getNext();
    return current;
  }

}

public class IntList implements Iterable< IntElem > {
  private IntElem start;

  public IntElem getStart() {
    return this.start;
  }

  public void add( int i ) {
    IntElem tmp = this.start;
    if ( tmp == null ) {
      this.start = new IntElem( i );
    } else {
      while ( tmp != null && tmp.hasNext() ) {
        tmp = tmp.getNext();
      }
      tmp.setNext( new IntElem( i ) );
    }
  }

  @Override
  public Iterator< IntElem > iterator() {
    return new IntListIterator( this.start );
  }
}

class IntElem {
  private IntElem next;
  private int value;

  public IntElem( int value ) {
    this.value = value;
  }

  public boolean hasNext() {
    return this.next != null;
  }

  public IntElem getNext() {
    return this.next;
  }

  public void setNext( IntElem ie ) {
    this.next = ie;
  }

  public int getValue() {
    return this.value;
  }
}
