package topfSpiel.view;

public class UIString {

  public UIString() {
  }

  public String zugMachen( Integer next, Integer tauschCounter ) {
    StringBuilder sb = new StringBuilder( "" );
    sb.append( "Spieler " + ( next + 1 ) + " ist an der Reihe.\n" );
    sb.append( "Waehle aus den folgenden Aktionen:\n" );
    sb.append( "1 - Eine Muenze in den Topf werfen.\n" );
    sb.append( "2 - Zwei Muenzen in den Topf werfen.\n" );
    sb.append( "3 - Drei Muenzen in den Topf werfen.\n" );
    sb.append( "4 - Eine Muenze aus dem Topf des Gegners entfernen.\n" );
    if ( tauschCounter == 0 ) {
      sb.append( "5 - Toepfe tauschen.\n" );
    } else {
      sb.append( "  - Tauschen erst in " + tauschCounter + " Runden wieder moeglich.\n" );
    }
    sb.append( "Eingabe: " );
    return sb.toString();
  }

  public String ausgabe( int aktion, Integer coinsSpieler1, Integer coinsSpieler2 ) {
    StringBuilder sb = new StringBuilder( "" );
    sb.append( "Nach Aktion " + aktion + " ist die Verteilung:\n" );
    sb.append( "Spieler 1: " + coinsSpieler1 + " Muenzen, Spieler 2: " + coinsSpieler2 + " Muenzen.\n\n" );
    return sb.toString();
  }

  public String ausgabeSieger( Integer sieger ) {
    return "Sieger ist Spieler " + sieger + "\n";
  }
}
