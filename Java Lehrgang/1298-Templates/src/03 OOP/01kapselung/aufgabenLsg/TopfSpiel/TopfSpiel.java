import java.util.Scanner;

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

  public void runde() {
    System.out.println( "Spieler " + ( next + 1 ) + " ist an der Reihe." );
    System.out.println( "Waehle aus den folgenden Aktionen:" );
    System.out.println( "1 - Eine Muenze in den Topf werfen." );
    System.out.println( "2 - Eine Muenze in den Topf werfen." );
    System.out.println( "3 - Eine Muenze in den Topf werfen." );
    System.out.println( "4 - Eine Muenze aus dem Topf des Gegners entfernen." );
    if ( this.tauschCounter == 0 ) {
      System.out.println( "5 - Toepfe tauschen." );
    } else {
      System.out
              .println( "  - Tauschen erst in " + this.tauschCounter + " Runden wieder moeglich." );
    }
    System.out.println( "Eingabe: " );
    int eingabe = new Scanner( System.in ).nextInt();
    aktion( eingabe );
  }

  private void aktion( int aktion ) {
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
    System.out.println( "Nach Aktion " + aktion + " ist die Verteilung:" );
    System.out.println( "Spieler 1: " + this.spieler[ 0 ].getCoins() + " Muenzen, Spieler 2: "
            + this.spieler[ 1 ].getCoins() + " Muenzen.\n" );
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

  public static void main( String[] args ) {
    TopfSpiel spiel = new TopfSpiel();

    while ( !spiel.istBeendet() ) {
      spiel.runde();
    }
    System.out.println( "Sieger ist Spieler " + spiel.getSieger() );
  }

}
