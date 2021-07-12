package schneckenrennen.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Diese Klasse repräsentiert ein Rennen.
 * 
 * @author kmoench
 */
public class Rennen {
  // Name des Rennens
  private String name;
  // Map SchneckenId zu Schnecke
  private HashMap< Long, Rennschnecke > mapIdSchnecken;
  // Map SchneckenId zu zurückgelegtem Weg
  private HashMap< Long, Double > mapIdWeg;
  // Laenge der Strecke
  private double streckenLaenge;
  // Vortschritt des Rennens in Zeiteinheit
  private int time;

  /**
   * Standardkonstruktor für ein Rennen mit Streckenlaenge 400
   */
  public Rennen() {
    this( "Standardrennen", 400 );
  }

  /**
   * Konstruktor mit Name des Rennens und Streckenlaenge
   * 
   * @param name Name des Rennens
   * @param streckenLaenge Streckenlaenge des Rennens
   */
  public Rennen( String name, double streckenLaenge ) {
    this.name = name;
    this.streckenLaenge = streckenLaenge;
    this.mapIdSchnecken = new HashMap< Long, Rennschnecke >();
    this.mapIdWeg = new HashMap< Long, Double >();
    this.time = 0;
  }

  public void addRennschnecke( Rennschnecke neueSchnecke ) {
    if ( !this.mapIdSchnecken.containsKey( neueSchnecke.getId() ) ) {
      this.mapIdSchnecken.put( neueSchnecke.getId(), neueSchnecke );
      this.mapIdWeg.put( neueSchnecke.getId(), 0.0 );
    }
  }

  public void removeRennschnecke( Rennschnecke schnecke ) {
    this.mapIdSchnecken.remove( schnecke.getId() );
    this.mapIdWeg.remove( schnecke.getId() );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append( "Rennen " + this.name + "\n" );
    sb.append( String.format( "%16s: %f%n", "Streckenlaenge", this.getStreckenLaenge() ) );
    sb.append( String.format( "%16s: %d%n", "Zeitpunkt", this.time ) );
    sb.append( "  Teilnehmer:\n" );
    for ( long id : this.mapIdSchnecken.keySet() ) {
      sb.append( this.mapIdSchnecken.get( id ) );
    }
    sb.append( "-----" );
    return sb.toString();
  }

  public Rennschnecke ermittleGewinner() {
    Rennschnecke gewinner = null;
    for ( long id : this.mapIdWeg.keySet() ) {
      if ( this.mapIdWeg.get( id ) > this.streckenLaenge ) {
        if ( gewinner == null || this.mapIdWeg.get( gewinner.getId() ) < this.mapIdWeg.get( id ) ) {
          gewinner = this.mapIdSchnecken.get( id );
        }
      }
    }
    return gewinner;
  }

  /**
   * Die Bewegung innerhalb einer Zeiteinheit durchführen
   * 
   * @return Die aktuelle Zeiteinheit.
   */
  public int kriechen() {
    if ( !istBeendet() ) {
      for ( long id : this.mapIdSchnecken.keySet() ) {
        this.mapIdWeg.put( id, this.mapIdWeg.get( id ) + this.mapIdSchnecken.get( id ).krieche() );
      }
      ++this.time;
    }
    return this.time;
  }

  /**
   * Die Bewegung innerhalb mehrerer Zeiteinheiten durchführen.
   * 
   * @param runden Anzahl der Zeiteinheiten.
   * @return Die aktuelle Zeiteinheit.
   */
  public int kriechen( int runden ) {
    int result = 0;
    for ( int i = 0; i < runden; ++i ) {
      result = this.kriechen();
    }
    return result;
  }

  /**
   * Liefert zurück ob das Rennen beendet ist oder nicht.
   * 
   * @return true, falls ein Sieger feststeht, false, sonst.
   */
  public boolean istBeendet() {
    boolean result = false;
    for ( Iterator< Long > it = this.mapIdWeg.keySet().iterator(); !result && it.hasNext(); ) {
      Long id = it.next();
      if ( this.mapIdWeg.get( id ) > this.streckenLaenge ) {
        result = true;
      }
    }
    return result;
  }

  /**
   * Liefert den Name des Rennens.
   * 
   * @return Name des Rennens.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Liefert die Namen der Teilnehmer mit aktueller Position
   * 
   * @return Map Name -> Position.
   */
  public Map< String, Double > getSchneckenNamenPositionen() {
    HashMap< String, Double > mapNamenPositionen = new HashMap< String, Double >();
    for ( Iterator< Long > it = this.mapIdSchnecken.keySet().iterator(); it.hasNext(); ) {
      Long id = it.next();
      mapNamenPositionen.put( this.mapIdSchnecken.get( id ).getName(), this.mapIdWeg.get( id ) );
    }
    return mapNamenPositionen;
  }

  public double getStreckenLaenge() {
    return this.streckenLaenge;
  }

  public void setName( String eingabeRennenName ) {
    this.name = eingabeRennenName;
  }

}
