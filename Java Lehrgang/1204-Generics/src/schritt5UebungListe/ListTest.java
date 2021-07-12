package schritt5UebungListe;

import schritt3UebungStack.Mensch;

public class ListTest {

  public static void main( String[] args ) {
    List< Mensch > menschen = new List<>();
    menschen.readIn( new Mensch( "Max", 31, 165 ) );
    menschen.readIn( new Mensch( "Kevin", 15, 182 ) );
    menschen.show();
    System.out.println( "---- Reverse:" );
    menschen.reverse().show();
    System.out.println( "---- Head:" );
    menschen.head().show();
    System.out.println( "---- Tail:" );
    menschen.tail().show();

    List< Mensch > andereMenschen = menschen.copy();
    System.out.println( "---- andereM:" );
    andereMenschen.show();
    System.out.println( "---- andereM drop:" );
    andereMenschen.drop( 0 );
    andereMenschen.show();
    System.out.println( "---- andereM neue Menschen:" );
    andereMenschen.add( new Mensch( "Anton", 27, 169 ), 0 );
    andereMenschen.add( new Mensch( "Jochen", 29, 179 ), 10 );
    andereMenschen.show();
    System.out.println( "---- andereM get:" );
    System.out.println( "Ausgabe: " + andereMenschen.get( 2 ) );
    System.out.println( "---- conc:" );
    menschen.conc( andereMenschen );
    menschen.show();
    menschen.tail().show();
    System.out.println( "---- Länge:" );
    System.out.println( menschen.length() );
    System.out.println( "---- andereM:" );
    andereMenschen.show();
  }

}
