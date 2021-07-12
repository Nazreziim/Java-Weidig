package wrsv2018schritt1.view;

import wrsv2018schritt1.model.Rennschnecke;
import wrsv2018schritt1.model.RennschneckenVerwaltung;
import wrsv2018schritt1.util.Util;

public class RennschneckenVerwaltungView {

  private RennschneckenVerwaltung rsv;
  private RSVVZustand zustand;

  public RennschneckenVerwaltungView( RennschneckenVerwaltung rsv ) {
    this.rsv = rsv;
    this.zustand = RSVVZustand.MENUE;
  }

  public void anzeigen() {
    while ( this.zustand != RSVVZustand.BEENDEN ) {
      switch ( this.zustand ) {
        case MENUE :
          this.zeigeMenueView();
          break;
        case REGISTRIEREN :
          this.zeigeRegistrierenView();
          break;
        case LISTE :
          this.zeigeListeView();
          break;
        case BEARBEITEN :
          this.zeigeBearbeitenView();
          break;
        case LOESCHEN :
          this.zeigeLoeschenView();
          break;
        default :
          // Intentionally empty
      }
    }
  }

  public RSVVZustand getZustand() {
    return zustand;
  }

  private void setZustand( RSVVZustand zustand ) {
    this.zustand = zustand;
  }

  public void zeigeMenueView() {
    final RSVVZustand[] RSVV_ZUSTAND_ARRAY = RSVVZustand.values();
    System.out.println( "Willkommen zur Rennschneckenverwaltung." );
    System.out.println( "Sie befinden sich im Hauptmenü." );
    System.out.println( "Mögliche Operationen:" );
    for ( RSVVZustand zustand : RSVV_ZUSTAND_ARRAY ) {
      System.out.printf( "%-15s: %s%n", zustand.toString(), zustand.getBeschreibung() );
    }
    boolean fertig = false;
    RSVVZustand zustand = RSVVZustand.MENUE;
    while ( !fertig ) {
      System.out.print( "Ihre Auswahl: " );
      String auswahl = Util.leseString();
      for ( int i = 0; i < RSVV_ZUSTAND_ARRAY.length && !fertig; ++i ) {
        if ( RSVV_ZUSTAND_ARRAY[ i ].toString().startsWith( auswahl.toUpperCase() ) ) {
          zustand = RSVV_ZUSTAND_ARRAY[ i ];
          fertig = true;
        }
      }
      if ( !fertig ) {
        System.out.println( "Die gewählte Operation existiert nicht." );
      }
    }
    this.setZustand( zustand );
  }

  private void zeigeRegistrierenView() {
    // Dialog (Informationen einholen)
    System.out.println( "Neue Rennschnecke registrieren:" );
    System.out.print( "Name: " );
    String name = Util.leseString();
    System.out.print( "Geschwindigkeit: " );
    double geschwindigkeit = Util.leseDouble();
    System.out.print( "Versichert über WRSV (ja/nein): " );
    boolean versichert = Util.leseBooleanDeuEng();

    // Verarbeiten (Neue Rennschnecke erstellen)
    Rennschnecke rs = new Rennschnecke( name, geschwindigkeit, versichert );

    // Dialog (Abfrage ob Daten korrekt sind.)
    System.out.println( "Folgende Informationen wurden erkannt:" );
    System.out.println( rs );
    System.out.print( "Sind diese richtig? (ja/nein)" );

    if ( Util.leseBooleanDeuEng() ) {
      // Rennschnecke speichern
      this.rsv.hinzufuegen( rs );
      System.out.println( "Ok, die Rennschnecke wurde registriert." );
      System.out.println( "Bis zum nächsten Mal." );
    } else {
      // Rennschnecke verwerfen
      System.out.println( "Die Rennschnecke wurde nicht registriert." );
      System.out.println( "Versuchen Sie es erneut." );
    }
    this.setZustand( RSVVZustand.MENUE );
  }

  private void zeigeListeView() {
    System.out.println( "Rennschneckenliste:" );
    System.out.println( "Drücken Sie Enter um weitere Einträge zu sehen." );
    final int EINTRAEGE_PRO_SEITE = 10;
    int seite = 0;
    do {
      int seitenDelta = seite * EINTRAEGE_PRO_SEITE;
      for ( int i = 0; i < 10 && i + seitenDelta < this.rsv.getAnzahl(); ++i ) {
        System.out.println( " " + ( i + seitenDelta ) + ": " + this.rsv.getRennschnecke( i + seitenDelta ) );
      }
      Util.leseString();
      ++seite;
    } while ( seite * EINTRAEGE_PRO_SEITE < this.rsv.getAnzahl() );
    System.out.println( "ENDE" );
    Util.leseString();
    this.setZustand( RSVVZustand.MENUE );
  }

  private void zeigeBearbeitenView() {
    System.out.println( "Rennschnecke bearbeiten:" );
    int auswahl = -1;
    do {
      System.out.print( "Auswahl der Rennschnecke durch ID (1) oder Listenposition(2)? [1]: " );
      auswahl = Util.auswahl( 2 );
    } while ( auswahl == -1 );
    Rennschnecke subjekt = null;
    if ( auswahl == 1 ) {
      System.out.print( "Welche Rennschnecke wollen Sie bearbeiten? ID: " );
      int id = Util.leseInt();
      if ( this.rsv.vorhanden( id ) ) {
        subjekt = this.rsv.getRennschneckeID( id );
      }
    } else {
      System.out.print( "Welche Rennschnecke wollen Sie bearbeiten? Listenposition: " );
      int stelle = Util.leseInt();
      subjekt = this.rsv.getRennschnecke( stelle );
    }
    if ( subjekt != null ) {
      System.out.println( "Rennschnecke gefunden. Sie können jetzt neue Werte eintragen." );
      System.out.println( "Falls Sie einen Wert nicht verändern wollen, drücken Sie einfach Enter." );
      System.out.print( "Name [" + subjekt.getName() + "]: " );
      String neuerName = Util.leseString();
      System.out.print( "Geschwindigkeit [" + subjekt.getGeschwindigkeit() + "]: " );
      double neueGeschwindigkeit = Util.leseDouble( true );
      System.out.print( "Versichert [" + ( subjekt.isVersichert() ? "ja" : "nein" ) + "]: " );
      String versicherungString = Util.leseString();
      boolean versicherungAenderung = false;
      boolean neuerVersicherungsstatus = false;
      if ( !versicherungString.isEmpty() ) {
        neuerVersicherungsstatus = Util.string2Boolean( versicherungString );
        versicherungAenderung = true;
      }
      System.out.println( "Neue Informationen:" );
      if ( !neuerName.isEmpty() )
        System.out.println( "Name: " + neuerName );
      if ( neueGeschwindigkeit != 0.0 )
        System.out.println( "Geschwindigkeit: " + neueGeschwindigkeit );
      if ( versicherungAenderung )
        System.out.println( "Neuer Versicherungsstatus: " + ( neuerVersicherungsstatus ? "ja" : "nein" ) );
      System.out.print( "Wollen Sie diese Daten übernehmen? (ja/nein): " );
      boolean uebernehmen = Util.leseBooleanDeuEng();
      if ( uebernehmen ) {
        if ( !neuerName.isEmpty() )
          subjekt.setName( neuerName );
        if ( neueGeschwindigkeit != 0.0 )
          subjekt.setGeschwindigkeit( neueGeschwindigkeit );
        if ( versicherungAenderung )
          subjekt.setVersichert( neuerVersicherungsstatus );
      }
      System.out.println( "Bis zum nächsten Mal." );
    } else {
      System.out.println( "Die Rennschnecke konnte nicht gefunden werden. Versuchen Sie es erneut." );
    }
    this.setZustand( RSVVZustand.MENUE );
  }

  private void zeigeLoeschenView() {
    System.out.println( "Rennschnecke löschen:" );
    int auswahl = -1;
    do {
      System.out.print( "Auswahl der Rennschnecke durch ID (1) oder Listenposition(2)? [1]: " );
      auswahl = Util.auswahl( 2 );
    } while ( auswahl == -1 );
    Rennschnecke subjekt = null;
    if ( auswahl == 1 ) {
      System.out.print( "Welche Rennschnecke wollen Sie löschen? ID: " );
      int id = Util.leseInt();
      if ( this.rsv.vorhanden( id ) ) {
        subjekt = this.rsv.getRennschneckeID( id );
      }
    } else {
      System.out.print( "Welche Rennschnecke wollen Sie löschen? Listenposition: " );
      int stelle = Util.leseInt();
      subjekt = this.rsv.getRennschnecke( stelle );
    }
    System.out.println( "Ausgewählt:" );
    System.out.println( subjekt );
    System.out.print( "Wollen Sie die Rennschnecke wirklich löschen? (ja/nein): " );
    boolean loeschen = Util.leseBooleanDeuEng();
    if ( loeschen ) {
      this.rsv.entfernen( subjekt );
      System.out.println( "Rennschnecke wurde aus der globalen Liste entfernt." );
    } else {
      System.out.println( "OK, bis zum nächsten Mal." );
    }
    this.setZustand( RSVVZustand.MENUE );
  }

}
