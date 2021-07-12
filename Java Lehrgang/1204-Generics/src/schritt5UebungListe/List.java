package schritt5UebungListe;

public class List< T > {
  private ListElem< T > start;

  public List() {
    this.start = null;
  }

  public void readIn( T info ) {
    if ( this.isEmpty() ) {
      this.start = new ListElem< T >( info, null );
    } else {
      ListElem< T > hilf = this.start;
      while ( hilf != null && hilf.getNext() != null ) {
        hilf = hilf.getNext();
      }
      hilf.setNext( new ListElem< T >( info, null ) );
    }
  }

  public List< T > copy() {
    List< T > result = new List< T >();
    ListElem< T > hilf = this.start;
    while ( hilf != null ) {
      result.readIn( hilf.getInfo() );
      hilf = hilf.getNext();
    }
    return result;
  }

  public void show() {
    ListElem< T > hilf = this.start;
    System.out.println( "[" );
    while ( hilf != null ) {
      System.out.println( hilf.getInfo() );
      if ( hilf.getNext() != null ) {
        System.out.println( ", " );
      }
      hilf = hilf.getNext();
    }
    System.out.println( "]" );
  }

  public void conc( List< T > liste ) {
    if ( this.isEmpty() ) {
      this.start = liste.start;
    } else {
      ListElem< T > hilf = this.start;
      while ( hilf != null && hilf.getNext() != null ) {
        hilf = hilf.getNext();
      }
      hilf.setNext( liste.start );
    }
  }

  public List< T > head() {
    List< T > result = new List< T >();
    if ( this.start != null ) {
      result.readIn( this.start.getInfo() );
    }
    return result;
  }

  public List< T > tail() {
    List< T > result = new List< T >();
    ListElem< T > hilf = this.start != null ? this.start.getNext() : null;
    while ( hilf != null ) {
      result.readIn( hilf.getInfo() );
      hilf = hilf.getNext();
    }
    return result;
  }

  public int length() {
    int length = 0;
    ListElem< T > hilf = this.start;
    while ( hilf != null ) {
      ++length;
      hilf = hilf.getNext();
    }
    return length;
  }

  public void add( T info, int key ) {
    if ( key == 0 ) {
      this.start = new ListElem< T >( info, this.start );
    } else {
      ListElem< T > hilf = this.start;
      int cur = 0;
      while ( hilf != null && hilf.getNext() != null && cur < key - 1 ) {
        hilf = hilf.getNext();
        ++cur;
      }
      hilf.setNext( new ListElem< T >( info, hilf.getNext() ) );
    }
  }

  public T get( int key ) {
    T result = null;
    int cur = 0;
    ListElem< T > hilf = this.start;
    while ( hilf != null && cur < key ) {
      hilf = hilf.getNext();
      ++cur;
    }
    if ( hilf != null ) {
      result = hilf.getInfo();
    }
    return result;
  }

  public void drop( int key ) {
    if ( key == 0 && this.start != null ) {
      this.start = this.start.getNext();
    } else {
      int cur = 0;
      ListElem< T > hilf = this.start;
      while ( hilf != null && cur < key - 1 ) {
        hilf = hilf.getNext();
        ++cur;
      }
      if ( hilf != null && hilf.getNext() != null ) {
        hilf.setNext( hilf.getNext().getNext() );
      }
    }
  }

  public List< T > reverse() {
    List< T > result = new List< T >();
    ListElem< T > hilf = this.start;
    while ( hilf != null ) {
      result.start = new ListElem< T >( hilf.getInfo(), result.start );
      hilf = hilf.getNext();
    }
    return result;
  }

  public boolean isEmpty() {
    return this.start == null;
  }

}
