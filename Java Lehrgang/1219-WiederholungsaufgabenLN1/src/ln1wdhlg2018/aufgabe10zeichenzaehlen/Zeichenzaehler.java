package ln1wdhlg2018.aufgabe10zeichenzaehlen;

class CharListe {
  private CharLE start;

  public CharLE getStart() {
    return this.start;
  }

  public void setStart( CharLE start ) {
    this.start = start;
  }

  public void add( char key, int value ) {
    if ( start == null ) {
      start = new CharLE( key, value );
    } else {
      CharLE last = start;
      while ( last.hasNext() ) {
        last = last.getNext();
      }
      last.setNext( new CharLE( key, value ) );
    }
  }

  public boolean contains( char key ) {
    boolean contains = false;
    boolean abbruch = false;
    CharLE ce = start;
    while ( !abbruch && ce != null ) {
      if ( ce.contains( key ) ) {
        contains = true;
        abbruch = true;
      }
      ce = ce.getNext();
    }
    return contains;
  }

  public int inc( char key ) {
    int result = -1;
    if ( this.contains( key ) ) {
      CharLE e = start;
      while ( e.getKey() != key ) {
        e = e.getNext();
      }
      e.setValue( e.getValue() + 1 );
      result = e.getValue();
    }
    return result;
  }

}

class CharLE {
  private char key;
  private int value;
  private CharLE next;

  public CharLE( char key, int value ) {
    this.key = key;
    this.value = value;
  }

  public boolean hasNext() {
    return next != null;
  }

  public boolean contains( char key ) {
    return this.key == key;
  }

  public char getKey() {
    return key;
  }

  public int getValue() {
    return this.value;
  }

  public void setValue( int value ) {
    this.value = value;
  }

  public CharLE getNext() {
    return next;
  }

  public void setNext( CharLE next ) {
    this.next = next;
  }
}

public class Zeichenzaehler {

  public static void main( String[] args ) {

    String eingabe = HilfsMeth.readString( "Bitte eine Zeichenkette (max. 80 Zeichen ) eingeben:" );

    CharListe cl = new CharListe();
    for ( int i = 0; i < eingabe.length(); ++i ) {
      char current = eingabe.charAt( i );
      if ( !cl.contains( current ) ) {
        cl.add( current, 1 );
      } else {
        cl.inc( current );
      }
    }

    System.out.println( "\nFolgende Zeichen wurden gezaehlt:" );
    CharLE cle = cl.getStart();
    int max = 0;
    CharLE maxE = null;
    while ( cle != null ) {
      System.out.printf( "%c  = %3d%n", cle.getKey(), cle.getValue() );
      if ( cle.getValue() > max ) {
        max = cle.getValue();
        maxE = cle;
      }
      cle = cle.getNext();
    }
    System.out.println(
            "\nMaximalhaeufigkeit von " + max + " hat Buchstabe: " + maxE.getKey() + "." );
  }
}
