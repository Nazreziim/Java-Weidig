package wrsv2018schritt1.model;

public class RennschneckenVerwaltung {
  public static final int MAX_RENNSCHNECKEN = 20;

  private Rennschnecke[] rennschnecken; 
  private int anzahl;

  public RennschneckenVerwaltung() {
    this.rennschnecken = new Rennschnecke[ RennschneckenVerwaltung.MAX_RENNSCHNECKEN ];
    this.anzahl = 0;
  }

  public void hinzufuegen( Rennschnecke rennschnecke ) {
    if ( !this.vorhanden( rennschnecke ) && !this.istVoll() ) {
      this.rennschnecken[ this.anzahl ] = rennschnecke;
      ++this.anzahl;
    }
  }

  public void entfernen( Rennschnecke rennschnecke ) {
    if ( !this.istLeer() ) {
      boolean gefunden = false;
      for ( int i = 0; i < this.anzahl; ++i ) {
        if ( !gefunden && this.rennschnecken[ i ] == rennschnecke ) {
          gefunden = true;
        }
        if ( gefunden && i < this.anzahl - 1 ) {
          this.rennschnecken[ i ] = this.rennschnecken[ i + 1 ];
        } else if ( gefunden && i == this.anzahl - 1 ) {
          this.rennschnecken[ i ] = null;
        }
      }
      if ( gefunden ) {
        --this.anzahl;
      }
    }
  }

  public int getAnzahl() {
    return this.anzahl;
  }

  public boolean istVoll() {
    return this.anzahl == RennschneckenVerwaltung.MAX_RENNSCHNECKEN;
  }

  public boolean istLeer() {
    return this.anzahl == 0;
  }

  public boolean vorhanden( Rennschnecke rennschnecke ) {
    boolean gefunden = false;
    for ( int i = 0; i < this.anzahl && !gefunden; ++i ) {
      gefunden = this.rennschnecken[ i ].equals( rennschnecke );
    }
    return gefunden;
  }

  public boolean vorhanden( int id ) {
    boolean gefunden = false;
    for ( int i = 0; i < this.anzahl && !gefunden; ++i ) {
      gefunden = this.rennschnecken[ i ].getID() == id;
    }
    return gefunden;
  }

  public Rennschnecke getRennschnecke( int stelle ) {
    if ( stelle < 0 || stelle >= this.anzahl ) {
      throw new IndexOutOfBoundsException(
              "Index: " + stelle + "/" + this.anzahl + " existiert nicht." );
    }
    return this.rennschnecken[ stelle ];
  }

  public Rennschnecke getRennschneckeID( int id ) {
    boolean gefunden = false;
    Rennschnecke schnecke = null;
    for ( int i = 0; i < this.anzahl && !gefunden; ++i ) {
      if ( this.rennschnecken[ i ].getID() == id ) {
        schnecke = this.rennschnecken[ i ];
      }
    }
    return schnecke;
  }

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder( "RennschneckenListe [anzahl=" + anzahl + "]" );
    for ( int i = 0; i < anzahl; ++i ) {
      string.append( "\n\t" + this.rennschnecken[ i ].toString() );
    }
    return string.toString();
  }

}
