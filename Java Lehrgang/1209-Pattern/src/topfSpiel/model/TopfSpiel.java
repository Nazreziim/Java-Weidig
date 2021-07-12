package topfSpiel.model;

public class TopfSpiel {

  private Topf[] spieler;
  private int next;
  private int tauschCounter;

  public TopfSpiel() {
    this( 7 );
  }

  public TopfSpiel( int n ) {
    this.spieler = new Topf[ 2 ];
    this.spieler[ 0 ] = new Topf( n );
    this.spieler[ 1 ] = new Topf( n );
    this.next = 0;
    this.tauschCounter = 0;
  }

  public void aktion( int aktion ) {
    switch ( aktion ) {
      case 1 :
      case 2 :
      case 3 :
        this.spieler[ next ].add( aktion );
        break;
      case 4 :
        this.spieler[ ( next + 1 ) % 2 ].remove( 1 );
        break;
      case 5 :
        if ( this.tauschCounter == 0 ) {
          Topf tmp = this.spieler[ 0 ];
          this.spieler[ 0 ] = this.spieler[ 1 ];
          this.spieler[ 1 ] = tmp;
          this.tauschCounter = 2;
          break;
        }
      default :
        System.err.println( "Ihre Eingabe war fehlerhaft." );
    }
    if ( this.tauschCounter > 0 ) {
      this.tauschCounter--;
    }
    this.next = ( this.next + 1 ) % 2;
  }

  public boolean istBeendet() {
    return this.spieler[ 0 ].isFull() || this.spieler[ 1 ].isFull();
  }

  public int getSieger() {
    int sieger = 0;
    if ( this.spieler[ 0 ].isFull() ) {
      sieger = 1;
    } else if ( this.spieler[ 1 ].isFull() ) {
      sieger = 2;
    }
    return sieger;
  }

  public int getNext() {
    return this.next;
  }

  public int getTauschCounter() {
    return this.tauschCounter;
  }

  public Topf[] getSpieler() {
    return this.spieler;
  }
}
