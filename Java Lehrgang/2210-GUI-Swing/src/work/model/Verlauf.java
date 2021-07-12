package work.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;
import java.util.List;

public class Verlauf {

  private List< Rechnung > verlaufListe;

  private final PropertyChangeSupport changeSupport;

  public Verlauf() {
    this.verlaufListe = new LinkedList< Rechnung >();
    this.changeSupport = new PropertyChangeSupport( this );
  }

  public int size() {
    return this.verlaufListe.size();
  }

  public Rechnung add( Rechnung r ) {
    this.verlaufListe.add( r );
    this.changeSupport.firePropertyChange( "addVerlauf", null, r );
    return r;
  }

  public Rechnung get( int n ) {
    return this.verlaufListe.get( n );
  }

  public void clear() {
    int size = this.verlaufListe.size();
    this.verlaufListe.clear();
    this.changeSupport.firePropertyChange( "clearVerlauf", size , 0 );
  }

  public void addVerlaufListener( PropertyChangeListener l ) {
    this.changeSupport.addPropertyChangeListener( l );
  }

  public void removeVerlaufListener( PropertyChangeListener l ) {
    this.changeSupport.removePropertyChangeListener( l );
  }
}
