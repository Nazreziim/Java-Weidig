package grundlagen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Diese Klasse repräsentiert einen Graph mit beliebigen Infotypen für Knoten und Kanten.
 * 
 * @param <KNOTEN_INFOTYP> Knoteninfotyp
 * @param <KANTEN_INFOTYP> Kanteninfotyp
 */
public class Graph< KNOTEN_INFOTYP, KANTEN_INFOTYP > {

  private List< Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > > knoten;

  public Graph() {
    this.knoten = new ArrayList<>();
  }

  /**
   * Einen neuen Knoten in den Graph einfuegen.
   * 
   * @param nummer Knotennummer.
   * @param info Knoteninfo.
   */
  public void einfuegen( int nummer, KNOTEN_INFOTYP info ) {
    boolean vorhanden = false;
    Iterator< Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > > it = this.knoten.iterator();
    while ( !vorhanden && it.hasNext() ) {
      Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > tmp = it.next();
      if ( tmp.getNummer() == nummer ) {
        vorhanden = true;
      }
    }
    if ( !vorhanden ) {
      knoten.add( new Knoten<>( nummer, info, 0 ) );
    }
  }

  /**
   * Eine neue Kante in den Graphen einfuegen.
   * 
   * @param start Nummer des Startknotens.
   * @param ende Nummer des Endknotens.
   * @param info Info der Kante.
   */
  public void einfuegen( int start, int ende, KANTEN_INFOTYP info ) {
    Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > startKnoten = null;
    Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > endeKnoten = null;
    Iterator< Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > > it = this.knoten.iterator();
    while ( ( startKnoten == null || endeKnoten == null ) && it.hasNext() ) {
      Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > tmp = it.next();
      // Startknoten suchen
      if ( tmp.getNummer() == start ) {
        startKnoten = tmp;
      }
      // Endknoten suchen
      if ( tmp.getNummer() == ende ) {
        endeKnoten = tmp;
      }
    }
    if ( startKnoten != null && endeKnoten != null ) {
      // Überprüfen ob Kante noch nicht existiert
      boolean vorhanden = false;
      Iterator< Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > > kantenIt = startKnoten.getKanten().iterator();
      while ( !vorhanden && kantenIt.hasNext() ) {
        Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kante = kantenIt.next();
        if ( kante.getZielKnoten().getNummer() == ende ) {
          vorhanden = true;
        }
      }
      // Kante einfuegen
      if ( !vorhanden ) {
        startKnoten.getKanten().add( new Kante<>( info, 0, endeKnoten ) );
      }
    }
  }

  /**
   * Knoten aus dem Graph entfernen.
   * 
   * @param nummer Knotennummer.
   */
  public void ausfuegen( int nummer ) {
    Iterator< Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > > knotenIterator = this.knoten.iterator();
    while ( knotenIterator.hasNext() ) {
      Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > knoten = knotenIterator.next();
      Iterator< Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > > kantenIterator = knoten.getKanten().iterator();
      while ( kantenIterator.hasNext() ) {
        Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kante = kantenIterator.next();
        if ( kante.getZielKnoten().getNummer() == nummer ) {
          kantenIterator.remove();
        }
      }
      if ( knoten.getNummer() == nummer ) {
        knotenIterator.remove();
      }
    }
  }

  /**
   * Kante aus dem Graph entfernen.
   * 
   * @param start Nummer des Startknoten.
   * @param ende Nummer des Endknoten.
   */
  public void ausfuegen( int start, int ende ) {
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > k : this.knoten ) {
      if ( k.getNummer() == start ) {
        Iterator< Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > > kanteIterator = k.getKanten().iterator();
        while ( kanteIterator.hasNext() ) {
          Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kante = kanteIterator.next();
          if ( kante.getZielKnoten().getNummer() == ende ) {
            kanteIterator.remove();
          }
        }
      }
    }
  }

  /**
   * Alle Markierungen im Graph löschen.
   */
  public void markierungenLoeschen() {
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > k : this.knoten ) {
      for ( Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kante : k.getKanten() ) {
        kante.setMarkierung( 0 );
      }
      k.setMarkierung( 0 );
    }

    // @formatter:off
    // this.knoten.forEach( knoten -> {
    //   knoten.setMarkierung( 0 );
    //   knoten.getKanten().forEach( kante -> kante.setMarkierung( 0 ) );
    // } );
    // @formatter:on
  }

  /**
   * Die Gesamtzahl der Kanten ermitteln.
   * 
   * @return Gesamtzahl der Kanten.
   * 
   * @author B-IX-59 Java 2019
   */
  // XXX
  public int kantenZaehlen() {
    int counter = 0;
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > knoten : this.knoten ) {
      counter += knoten.getKanten().size();
    }
    return counter;
  }

  /**
   * Erstellt einen ungerichteten Graph aus dem aktuellen Graph und gibt diesen zurück. Nicht
   * zerstörend.
   * 
   * @return Ungerichteter Graph.
   */
  public Graph< KNOTEN_INFOTYP, KANTEN_INFOTYP > erstelleUngerichtetenGraph() {
    Graph< KNOTEN_INFOTYP, KANTEN_INFOTYP > g = new Graph<>();
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > knoten : this.knoten ) {
      g.einfuegen( knoten.getNummer(), knoten.getInfo() );
      for ( Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kante : knoten.getKanten() ) {
        g.einfuegen( kante.getZielKnoten().getNummer(), kante.getZielKnoten().getInfo() );
        g.einfuegen( knoten.getNummer(), kante.getZielKnoten().getNummer(), kante.getInfo() );
        g.einfuegen( kante.getZielKnoten().getNummer(), knoten.getNummer(), kante.getInfo() );
      }
    }
    return g;
  }

  /**
   * Mache aus dem aktuellen Graph einen ungerichteten Graph.
   * 
   * @author B-IX-59 Java 2019
   */
  // XXX
  public void veraendereZuUngerichtetetemGraph() {
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > kno : knoten ) {
      for ( Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kan : kno.getKanten() ) {
        Boolean hatRueck = false;
        for ( Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > rueckkan : kan.getZielKnoten().getKanten() ) {
          if ( rueckkan.getZielKnoten() == kno ) {
            hatRueck = true;
          }
        }
        if ( !hatRueck ) {
          this.einfuegen( kan.getZielKnoten().getNummer(), kno.getNummer(), kan.getInfo() );
        }
      }
    }
  }

  /**
   * Prüfung auf isolierte Knoten.
   * 
   * @return True, falls mindestens ein isolierter Knoten existiert, ansonsten false.
   *
   * @author B-IX-59 Java 2019
   */
  // XXX
  public boolean hatIsolierteKnoten() {
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > knoten : this.knoten ) {
      if ( knoten.getKanten().size() == 0 ) {
        boolean verweistAufKnoten = false;
        for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > knoten2 : this.knoten ) {
          for ( Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kante : knoten2.getKanten() ) {
            if ( kante.getZielKnoten() == knoten ) {
              verweistAufKnoten = true;
            }
          }
        }
        if ( !verweistAufKnoten ) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean hatIsolierteKnoten2() {
    this.markierungenLoeschen();
    boolean isolierteKnoten = false;
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > knoten : this.knoten ) {
      for ( Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kante : knoten.getKanten() ) {
        kante.getZielKnoten().setMarkierung( kante.getZielKnoten().getMarkierung() + 1 );
      }
    }
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > knoten : this.knoten ) {
      if ( knoten.getMarkierung() == 0 ) {
        isolierteKnoten = true;
      }
    }
    this.markierungenLoeschen();
    return isolierteKnoten;
  }

  /**
   * Prüfung ob der Graph einen Baum abbildet.
   * 
   * @return True, falls der Graph einen Baum abbildet, ansonsten false.
   * @author B-IX-59 Java 2019
   */
  // XXX
  public boolean istBaum() {
    boolean istBaum = false;
    int counter = 0;

    if ( !hatIsolierteKnoten() ) {
      if ( kantenZaehlen() == knoten.size() - 1 ) {
        // zu prüfenden knoten
        for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > temp : knoten ) {
          // gehst du alle knoten durch für alle kanten
          for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > kno : knoten ) {
            // von jedem knoten jede kante auf zu prüfenden knoten oprüfen
            for ( Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kan : kno.getKanten() ) {
              if ( kan.getZielKnoten() == temp ) {
                counter++;
              }
            }
          }
        }
      }
    }
    if ( counter == knoten.size() - 1 ) {
      istBaum = true;
    }
    return istBaum;
  }

  /**
   * Strukturierte Stringräpresentation des Graphen.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder( "Graph:\n" );
    for ( Knoten< KNOTEN_INFOTYP, KANTEN_INFOTYP > knoten : this.knoten ) {
      sb.append( "Knoten " + knoten.getNummer() + ": Info: " + knoten.getInfo() + "\n" );
      for ( Kante< KANTEN_INFOTYP, KNOTEN_INFOTYP > kante : knoten.getKanten() ) {
        sb.append( "  -- Kante( Info: " + kante.getInfo() + " ) -> " + kante.getZielKnoten().getNummer() + "\n" );
      }
    }
    return sb.toString();
  }

}
