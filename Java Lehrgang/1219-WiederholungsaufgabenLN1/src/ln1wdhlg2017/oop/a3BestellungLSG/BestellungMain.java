package ln1wdhlg2017.oop.a3BestellungLSG;

import ln1wdhlg2017.gdlg.a2.HilfsMeth;

public class BestellungMain {

  public static void main( String[] args ) {
    IntList il = new IntList();
    String weiter;
    do {
      String artNr = HilfsMeth
              .readString( "Geben Sie ihre Bestellnummer ein ( genau 8 Ziffern ):" );
      try {
        il.add( Integer.parseInt( artNr.substring( 0, 8 ) ) );
      } catch ( NumberFormatException | IndexOutOfBoundsException e ) {
        System.err.println( "Sie dürfen/müssen 8 Ziffern eingeben!" );
      }
      weiter = HilfsMeth.readString( "Wollen Sie weitere Nummern eingeben? (j)a oder (n)ein" );
    } while ( weiter.trim().substring( 0, 1 ).equalsIgnoreCase( "j" ) );

    // Hier soll im weiteren Verlauf die Klasse bestimmt werden von welcher die Instanz ist, welche
    // erschaffen werden muss.

    ArtList al = new ArtList();

    for ( IntElem ie : il ) {
      int artikelArt = (int) ( ie.getValue() / Math.pow( 10, 7 ) );
      int farbe = (int) ( ie.getValue() / Math.pow( 10, 2 ) ) % 10;
      int groesse = ie.getValue() % 100;
      switch ( artikelArt ) {
        case 1 :
          if ( farbe >= 0 && farbe <= 3 && groesse >= 34 && groesse <= 44 && groesse % 2 == 0 ) {
            al.add( new KleidungW(
                    farbe == 0 ? "rot" : farbe == 1 ? "gelb" : farbe == 2 ? "gruen" : "blau",
                    groesse ) );
          } else {
            System.out.println( "Die Artikelnummer " + ie.getValue() + " existiert so nicht." );
          }
          break;
        case 2 :
          if ( farbe >= 0 && farbe <= 3 && groesse >= 44 && groesse <= 54 && groesse % 2 == 0 ) {
            al.add( new KleidungM(
                    farbe == 0 ? "rot" : farbe == 1 ? "gelb" : farbe == 2 ? "gruen" : "blau",
                    groesse ) );
          } else {
            System.out.println( "Die Artikelnummer " + ie.getValue() + " existiert so nicht." );
          }
          break;
        case 3 :
          if ( farbe >= 0 && farbe <= 2 && groesse == 0 ) {
            al.add( new Moebel( farbe == 0 ? "Buche" : farbe == 1 ? "Eiche" : "Kiefer" ) );
          } else {
            System.out.println( "Die Artikelnummer " + ie.getValue() + " existiert so nicht." );
          }
          break;
        case 4 :
          if ( farbe == 0 && groesse == 0 ) {
            al.add( new Elektronik() );
          } else {
            System.out.println( "Die Artikelnummer " + ie.getValue() + " existiert so nicht." );
          }
          break;
        default :
          System.out.println( "Die Artikelnummer " + ie.getValue() + " existiert so nicht." );
      }
    }

    System.out.println( "Folgende Artikel wurden Akzeptiert:" );
    for ( ArtElem ae : al ) {
      System.out.println( ae.getValue() );
    }
  }

}
