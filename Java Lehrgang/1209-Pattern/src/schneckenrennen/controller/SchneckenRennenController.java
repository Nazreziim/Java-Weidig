package schneckenrennen.controller;

import java.util.ArrayList;
import java.util.List;

import schneckenrennen.model.Rennen;
import schneckenrennen.model.Rennschnecke;
import schneckenrennen.model.Wettbuero;
import schneckenrennen.view.UIConsole;

/**
 * 
 * @author kmoench
 *
 */
public class SchneckenRennenController {

  private List< Rennen > listeRennen;
  private Wettbuero wettbuero;
  private UIConsole view;

  public SchneckenRennenController( Wettbuero wettbuero, UIConsole view ) {
    this.listeRennen = new ArrayList< Rennen >();
    this.wettbuero = wettbuero == null ? new Wettbuero() : wettbuero;
    this.view = view;
  }

  public void start() {
    // Fragen ob Rennen angelegt werden soll?
    // Details für Rennen abfragen
    // Rennen zur Liste hinzufügen
    this.listeRennen.add( new Rennen() );
    Rennen rennen = this.listeRennen.get( 0 );
    rennen.setName( this.view.eingabeRennenName() );

    // Teilnehmer abfragen. Von Strings in eine Liste von Rennschnecken packen.
    // Anschließend dem Rennen hinzufügen.
    List< Rennschnecke > teilnehmer = this
            .teilnehmerStringToList( this.view.eingabeTeilnehmer( rennen.getName() ) );
    for ( Rennschnecke r : teilnehmer ) {
      rennen.addRennschnecke( r );
    }

    this.view.ausgabeRennenBeschreibung( rennen.toString() );
    // Hier sollen später mal Wetten eingegeben werden.
    this.view.eingabeWetten();

    // Solange wie keine Sieger feststeht, Runden durchführen.
    while ( !rennen.istBeendet() ) {
      // Runde durchführen
      int t = rennen.kriechen( 10 );
      // Rennsituation darstellen
      this.view.ausgabeRennsituation( t, rennen.getStreckenLaenge(),
              rennen.getSchneckenNamenPositionen(), 150 );
    }
    // Nach dem Rennen: Sieger ausgaben
    this.view.ausgabeSieger( rennen.ermittleGewinner().getName() );

    // Ergebnisse der Wetten darstellen
    // view.ausgabeWetten();
  }

  public List< Rennschnecke > teilnehmerStringToList( String[] teilnehmer ) {
    List< Rennschnecke > result = new ArrayList< Rennschnecke >( teilnehmer.length );
    for ( String s : teilnehmer ) {
      if ( s != null ) {
        String[] details = s.split( "," );
        if ( details.length == 2 ) {
          details[ 0 ] = details[ 0 ].trim();
          details[ 1 ] = details[ 1 ].trim();
          if ( details[ 0 ] != "" && details[ 1 ] != "" ) {
            Rennschnecke schnecke = new Rennschnecke( details[ 0 ], details[ 1 ],
                    Math.random() * 10 + 1 );
            result.add( schnecke );
          }
        }
      }
    }
    return result;
  }

}
