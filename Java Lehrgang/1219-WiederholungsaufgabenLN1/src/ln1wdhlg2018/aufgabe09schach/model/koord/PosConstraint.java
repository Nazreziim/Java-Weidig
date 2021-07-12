package ln1wdhlg2018.aufgabe09schach.model.koord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import ln1wdhlg2018.aufgabe09schach.model.Farbe;

public enum PosConstraint {
  //@formatter:off
  BAUER(2, 1, true, false),
  DAME(1, 5, false, true),
  KOENIG(1, 4, false, true),
  LAEUFER(1, 3, false, false),
  SPRINGER(1, 2, false, false),
  TURM(1,1,false, false);
  //@formatter:on

  /**
   * Abstand zum unteren Rand
   */
  private int reihenOffset;
  /**
   * Abstand zum linken Rand
   */
  private int linienOffset;
  /**
   * Komplette Reihe wird befüllt.
   */
  private boolean kompletteReihe;
  /**
   * Figur kommt nur einmal vor.
   */
  private boolean unique;

  /**
   * Speicher der möglichen Positionen in Abhängigkeit der Farbe einer Figur. 
   */
  private Map<Farbe, List<Koordinate>> possiblePositionsMap;
  private int lastAnzReihen;
  private int lastAnzLinien;
  
  private PosConstraint( int reihenOffset, int linienOffset, boolean kompletteReihe,
          boolean unique ) {
    if ( reihenOffset < 1 || reihenOffset > 8 || linienOffset < 1 || linienOffset > 8 ) {
      throw new IllegalArgumentException();
    }
    this.reihenOffset = reihenOffset;
    this.linienOffset = linienOffset;
    this.kompletteReihe = kompletteReihe;
    this.unique = unique;
    this.possiblePositionsMap = new EnumMap<Farbe, List<Koordinate>>(Farbe.class);
    this.lastAnzReihen = 0;
    this.lastAnzLinien = 0;
  }

  public int getLinienOffset() {
    return linienOffset;
  }

  public int getReihenOffset() {
    return reihenOffset;
  }

  public boolean isKompletteReihe() {
    return kompletteReihe;
  }

  public boolean isUnique() {
    return unique;
  }
  
  private synchronized boolean isGenerated(Farbe farbe) {
    System.out.println( "PosConstraint." + this.toString() + ".isGenerated( " + farbe + ");" );
    return this.possiblePositionsMap.containsKey( farbe );
  }
  
  private synchronized void listPossiblePositions( Farbe farbe, int anzReihen, int anzLinien ) {
    System.out.println( "PosConstraint." + this.toString() + ".listPossiblePositions( " + farbe + ");" );
    List< Koordinate > possibleKoords = new ArrayList< Koordinate >(anzLinien);

    int reihe = farbe == Farbe.WEISS
            ? this.getReihenOffset()
            : anzReihen+ 1 - this.getReihenOffset();
    if ( this.isKompletteReihe() ) {
      for ( int i = 1; i <= anzLinien; ++i ) {
        possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( i ) ) );
      }
    } else if ( this.isUnique() ) {
      if ( this.equals( DAME ) ) {
        possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( anzLinien/ 2 ) ) );
      }
      if ( this.equals( KOENIG ) ) {
        possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( anzReihen/ 2 + 1 ) ) );
      }
    } else {
      possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( this.getLinienOffset() ) ) );
      possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( anzLinien+ 1 - this.getLinienOffset() ) ) );
    }
    this.possiblePositionsMap.put( farbe, possibleKoords );
  }

  public synchronized List< Koordinate > getPossiblePositions( Farbe farbe, int anzReihen, int anzLinien ) {
    if(this.lastAnzReihen != anzReihen || this.lastAnzLinien != anzLinien || !this.isGenerated( farbe )) {
      this.listPossiblePositions( farbe, anzReihen, anzLinien );
      this.lastAnzReihen = anzReihen;
      this.lastAnzLinien = anzLinien;
    }
    return Collections.unmodifiableList( this.possiblePositionsMap.get( farbe ) );
  }

}
