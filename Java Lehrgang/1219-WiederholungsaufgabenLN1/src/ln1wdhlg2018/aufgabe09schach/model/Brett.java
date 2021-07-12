package ln1wdhlg2018.aufgabe09schach.model;

import java.util.LinkedList;
import java.util.List;

import ln1wdhlg2018.aufgabe09schach.model.figuren.Figur;
import ln1wdhlg2018.aufgabe09schach.model.koord.Koordinate;
import ln1wdhlg2018.aufgabe09schach.model.koord.PosConstraint;

public class Brett {

  /**
   * @formatter:off
   * Array für die Schachfiguren auf dem Brett
   * 1. Dimension: Zeilen 1..*
   * 2. Dimension: Spalten 'A'..* (1..*)
   * @formatter:on
   */
  private Figur[][] brett;
  private final int ANZ_REIHEN;
  private final int ANZ_LINIEN;

  public Brett( int anzReihen, char anzLinien ) {
    this.ANZ_REIHEN = anzReihen;
    this.ANZ_LINIEN = Koordinate.koordChar2Int( anzLinien );
    this.brett = new Figur[ ANZ_REIHEN ][ ANZ_LINIEN ];
  }

  public int getANZ_REIHEN() {
    return ANZ_REIHEN;
  }

  public int getANZ_LINIEN() {
    return ANZ_LINIEN;
  }

  public Figur getFigur( Koordinate koord ) {
    return this.brett[ koord.getReihe() - 1 ][ Koordinate.koordChar2Int( koord.getLinie() ) - 1 ];
  }

  public boolean add( Figur figur, Koordinate koord ) {
    System.out.println( "brett.add( " + figur + ", " + koord + " );" );
    boolean erfolg = false;
    if(this.brett.length > 0 && this.brett[0].length > 0) {
      int reihe = koord.getReihe() - 1;
      int linie = Koordinate.koordChar2Int( koord.getLinie() ) - 1;
      boolean dimensionCheck = reihe >= 0 && reihe < this.brett.length && linie >= 0 && linie < this.brett[0].length;
      if ( dimensionCheck && this.brett[ reihe ][ linie ] == null && figur.getPos() == null ) {
        this.brett[ koord.getReihe() - 1 ][ Koordinate.koordChar2Int( koord.getLinie() ) - 1 ] = figur;
        figur.setPos( koord );
        erfolg = true;
      }
    }
    return erfolg;
  }

  public boolean add( Figur figur ) {
    System.out.println( "brett.add( " + figur + " );" );
    boolean erfolg = false;
    if ( figur != null && figur.getPosConstraint() != null && figur.getFarbe() != null ) {
//      List< Koordinate > possibleKoords = this.listPossibleKoords( figur.getPosConstraint(), figur.getFarbe() );
      List<Koordinate> possibleKoords = figur.getPosConstraint().getPossiblePositions( figur.getFarbe(), ANZ_REIHEN, ANZ_LINIEN );
      System.out.println( figur + ": possibleKoords: " + possibleKoords );
      for ( int i = 0; i < possibleKoords.size() && !erfolg; ++i ) {
        if ( this.add( figur, possibleKoords.get( i ) ) ) {
          erfolg = true;
        }
      }
    }
    return erfolg;
  }

//  private List< Koordinate > listPossibleKoords( PosConstraint posConstraint, Farbe farbe ) {
//    List< Koordinate > possibleKoords = new LinkedList< Koordinate >();
//
//    int reihe = farbe == Farbe.WEISS
//            ? posConstraint.getReihenOffset()
//            : this.ANZ_REIHEN + 1 - posConstraint.getReihenOffset();
//    if ( posConstraint.isKompletteReihe() ) {
//      for ( int i = 1; i <= this.ANZ_LINIEN; ++i ) {
//        possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( i ) ) );
//      }
//    } else if ( posConstraint.isUnique() ) {
//      if ( posConstraint.equals( posConstraint.DAME ) ) {
//        possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( ANZ_LINIEN / 2 ) ) );
//      }
//      if ( posConstraint.equals( posConstraint.KOENIG ) ) {
//        possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( ANZ_LINIEN / 2 + 1 ) ) );
//      }
//    } else {
//      possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( posConstraint.getLinienOffset() ) ) );
//      possibleKoords.add( new Koordinate( reihe, (char) Koordinate.koordInt2Char( ANZ_LINIEN + 1 - posConstraint.getLinienOffset() ) ) );
//    }
//    return possibleKoords;
//  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder( "Brett ( Anzahl Reihen: " + this.ANZ_REIHEN
            + " Anzahl Linien: " + (char) Koordinate.koordInt2Char( this.ANZ_LINIEN ) + " )" );
    for ( int reihe = 0; reihe < this.ANZ_REIHEN; ++reihe ) {
      for ( int linie = 0; linie < this.ANZ_LINIEN; ++linie ) {
        Figur f = this.brett[ reihe ][ linie ];
        if ( f != null ) {
          sb.append( "\n\t" + f );
        }
      }
    }
    return sb.toString();
  }

}
