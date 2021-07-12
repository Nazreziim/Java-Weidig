package ln1wdhlg2017.oop;

class EuroBetrag {
  private int euro;
  private int cent;
  private boolean negativ;

  public EuroBetrag( int euro, int cent, boolean negativ ) {
    this.set( euro, cent, negativ );
  }

  public boolean isNegativ() {
    return this.negativ;
  }

  public void set( int euro, int cent, boolean negativ ) {
    this.euro = euro > 0 ? euro : euro * -1;
    this.cent = cent > 0 ? cent % 100 : ( cent % 100 ) * -1;
    this.negativ = negativ;
  }

  public EuroBetrag abs() {
    return new EuroBetrag( this.euro, this.cent, false );
  }

  public EuroBetrag add( int cent ) {
    int betragThis = this.euro * 100 + this.cent;
    int betrag = ( this.negativ ? betragThis * -1 : betragThis ) + cent;
    int euroNew = betrag / 100;
    int centNew = betrag % 100;
    return new EuroBetrag( euroNew, centNew, betrag < 0 );
  }

  public EuroBetrag add( EuroBetrag other ) {
    int betragThis = this.euro * 100 + this.cent;
    int betragOther = other.euro * 100 + other.cent;
    int betrag = ( this.negativ ? betragThis * -1 : betragThis )
            + ( other.negativ ? betragOther * -1 : betragOther );
    int euroNew = betrag / 100;
    int centNew = betrag % 100;
    return new EuroBetrag( euroNew, centNew, betrag < 0 );
  }

  @Override
  public String toString() {
    return ( this.negativ ? "-" : "" ) + this.euro + "," + this.cent + " Euro";
  }
}

public class A1EuroBetrag {

  public static void main( String[] args ) {
    EuroBetrag a = new EuroBetrag( 0, 0, false );
    EuroBetrag b = new EuroBetrag( 0, 0, false );

    a.set( 50, 5, true );
    if ( a.isNegativ() ) {
      System.out.println( "Sie sind in den roten Zahlen." );
      System.out.print( "Sie müssen mindestens " );
      System.out.print( a.abs().toString() );
      System.out.println( " einzahlen." );
    }

    b = a.abs().add( 150 );
    System.out.print( "Wenn Sie " );
    System.out.print( b.toString() );
    System.out.println( " einzahlen," );
    System.out.print( "dann haben Sie " );
    System.out.print( a.add( b ).toString() );
    System.out.println( "auf dem Konto." );
  }

}
