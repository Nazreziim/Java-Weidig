package schritt3UebungStack;

public class StackElement< T extends Comparable< T > > {
  private T inhalt;
  private StackElement< T > next;

  public StackElement( T inhalt, StackElement< T > next ) {
    this.inhalt = inhalt;
    this.next = next;
  }

  public T getInhalt() {
    return this.inhalt;
  }

  public StackElement< T > next() {
    return this.next;
  }

  public void setNext( StackElement< T > next ) {
    this.next = next;
  }

  // Liefert den maximalen Inhalt der Restliste zurück.
  // Benötigt: T extends Comparable< T > in Zeile 3
  public T getMax( T vergleich ) {
    T result;
    // Wenn vergleich ungleich null: Prüfen was größer ist.
    if ( vergleich != null ) {
      result = this.inhalt.compareTo( vergleich ) > 0 ? this.inhalt : vergleich;
    } else { // Ansonsten ist this.inhalt groesser!
      result = this.inhalt;
    }

    // Wenn es ein nächstes gibt
    if ( this.next != null ) {
      // Das Ergebnis hier an das nächste Element weiter geben und Ergebnis davon abspeichern
      result = this.next.getMax( result );
    }

    // Resultat zurückliefern
    return result;
  }

}
