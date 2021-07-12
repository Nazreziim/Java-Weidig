package schritt5UebungListe;

public class ListElem< T > {
  private T info;
  private ListElem< T > next;

  public ListElem( T info, ListElem< T > next ) {
    this.setInfo( info );
    this.setNext( next );
  }

  public T getInfo() {
    return info;
  }

  public void setInfo( T info ) {
    this.info = info;
  }

  public ListElem< T > getNext() {
    return next;
  }

  public void setNext( ListElem< T > next ) {
    this.next = next;
  }

}
