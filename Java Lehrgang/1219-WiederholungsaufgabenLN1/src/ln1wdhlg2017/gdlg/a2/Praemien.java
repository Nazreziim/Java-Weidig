package ln1wdhlg2017.gdlg.a2;

import java.time.LocalDateTime;

public class Praemien {

  public static void main( String... strings ) {
    String mitarbeiter;
    do {
      mitarbeiter = HilfsMeth.readString(
              "Welche Art von Mitarbeiter ( AUSZUBILDENDER ARBEITER ANGESTELLTER ): " );
    } while ( !( mitarbeiter.trim().equalsIgnoreCase( "AUSZUBILDENDER" )
            || mitarbeiter.trim().equalsIgnoreCase( "ARBEITER" )
            || mitarbeiter.trim().equalsIgnoreCase( "ANGESTELLTER" ) ) );

    String zugehoerigkeit = HilfsMeth.readString( "Betriebszugehoerigkeit ( Jahre Monate ): " );
    String[] zugehoerigkeitArr = zugehoerigkeit.trim().split( " " );
    int[] zugehoerigkeitIntArr = new int[ 2 ];
    zugehoerigkeitIntArr[ 0 ] = Integer.parseInt( zugehoerigkeitArr[ 0 ].trim() );
    zugehoerigkeitIntArr[ 1 ] = Integer.parseInt( zugehoerigkeitArr[ 1 ].trim() );

    String alter = HilfsMeth.readString( "Alter: " );
    int alterInt = Integer.parseInt( alter.trim() );

    String montage = HilfsMeth.readString( "Montagestelle ( Ja, Nein ): " );
    boolean montageBool = montage.trim().equalsIgnoreCase( "Ja" );

    int[] montageDauerIntArr = new int[ 2 ];
    if ( montageBool ) {
      String montageDauer = HilfsMeth.readString( "Montagedauer ( Jahre Montate ): " );
      String[] montageDauerArr = montageDauer.trim().split( " " );
      montageDauerIntArr[ 0 ] = Integer.parseInt( montageDauerArr[ 0 ].trim() );
      montageDauerIntArr[ 1 ] = Integer.parseInt( montageDauerArr[ 1 ].trim() );
    }

    int grundpraemie = 0;
    if ( mitarbeiter.trim().equalsIgnoreCase( "AUSZUBILDENDERA" ) ) {
      grundpraemie = 100;
    } else if ( zugehoerigkeitIntArr[ 0 ] >= 6 ) {
      grundpraemie = 20 * zugehoerigkeitIntArr[ 0 ] + 80;
    } else if ( zugehoerigkeitIntArr[ 0 ] >= 1 ) {
      grundpraemie = 200;
    }
    int alterspraemie = 0;
    if ( alterInt >= 50 ) {
      alterspraemie = 50;
    }
    int montagepraemie = 0;
    if ( mitarbeiter.trim().equalsIgnoreCase( "ARBEITER" ) && montageBool
            && montageDauerIntArr[ 0 ] >= 1 ) {
      montagepraemie = 170;
    }
    int jubilaeumspraemie = 0;
    if ( ( zugehoerigkeitIntArr[ 0 ] == 24
            && zugehoerigkeitIntArr[ 1 ] > LocalDateTime.now().getMonthValue() )
            || ( zugehoerigkeitIntArr[ 0 ] == 25
                    && zugehoerigkeitIntArr[ 1 ] <= LocalDateTime.now().getMonthValue() ) ) {
      jubilaeumspraemie = 500;
    }

    int gesamt = grundpraemie + alterspraemie + montagepraemie + jubilaeumspraemie;
    System.out.println();
    System.out.printf( "=> Grundpraemie:      %d Euro%n", grundpraemie );
    System.out.printf( "=> Alterspraemie:     %d Euro%n", alterspraemie );
    System.out.printf( "=> Montagepraemie:    %d Euro%n", montagepraemie );
    System.out.printf( "=> Jubilaeumspraemie: %d Euro%n", jubilaeumspraemie );
    System.out.printf( "Die Praemie betraegt: %d Euro%n", gesamt );
  }

}
