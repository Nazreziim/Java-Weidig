package topfSpiel.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UIConsole {

  public UIConsole() {
  }

  public int zugMachen( Integer next, Integer tauschCounter ) {
    System.out.println( "Spieler " + ( next + 1 ) + " ist an der Reihe." );
    System.out.println( "Waehle aus den folgenden Aktionen:" );
    System.out.println( "1 - Eine Muenze in den Topf werfen." );
    System.out.println( "2 - Zwei Muenzen in den Topf werfen." );
    System.out.println( "3 - Drei Muenzen in den Topf werfen." );
    System.out.println( "4 - Eine Muenze aus dem Topf des Gegners entfernen." );
    if ( tauschCounter == 0 ) {
      System.out.println( "5 - Toepfe tauschen." );
    } else {
      System.out.println( "  - Tauschen erst in " + tauschCounter + " Runden wieder moeglich." );
    }
    System.out.println( "Eingabe: " );
    int eingabe = 0;
    try {
      eingabe = new Scanner( System.in ).nextInt();
    } catch ( InputMismatchException e ) {
    }
    return eingabe;
  }

  public void ausgabe( int aktion, Integer coinsSpieler1, Integer coinsSpieler2 ) {
    System.out.println( "Nach Aktion " + aktion + " ist die Verteilung:" );
    System.out.println( "Spieler 1: " + coinsSpieler1 + " Muenzen, Spieler 2: " + coinsSpieler2 + " Muenzen.\n" );
  }

  public void ausgabeSieger( Integer sieger ) {
    System.out.println( "Sieger ist Spieler " + sieger );
  }
}
