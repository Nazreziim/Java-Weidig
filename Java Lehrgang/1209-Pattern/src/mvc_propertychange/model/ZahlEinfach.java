package mvc_propertychange.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ZahlEinfach {
  private Integer zahl;
  private PropertyChangeSupport pcs;

  public ZahlEinfach() {
    this( Integer.valueOf( 0 ) );
  }

  public ZahlEinfach( int zahl ) {
    this( Integer.valueOf( zahl ) );
  }

  public ZahlEinfach( Integer zahl ) {
    this.zahl = zahl;
    this.pcs = new PropertyChangeSupport( this );
  }

  public Integer getZahl() {
    return this.zahl;
  }

  public void add( Integer b ) {
    Integer old = this.zahl;
    this.zahl += b;
    this.pcs.firePropertyChange( "zahl", old, this.zahl );
  }

  public void sub( Integer b ) {
    Integer old = this.zahl;
    this.zahl -= b;
    if ( this.zahl < 0 ) {
      this.zahl = 0;
    }
    this.pcs.firePropertyChange( "zahl", old, this.zahl );
  }

  public void increment() {
    Integer old = this.zahl;
    ++this.zahl;
    this.pcs.firePropertyChange( "zahl", old, this.zahl );
  }

  public void decrement() {
    Integer old = this.zahl;
    --this.zahl;
    if ( this.zahl < 0 ) {
      this.zahl = 0;
    }
    this.pcs.firePropertyChange( "zahl", old, this.zahl );
  }

  public void addPropertyChangeListener( PropertyChangeListener listener ) {
    this.pcs.addPropertyChangeListener( listener );
  }

  public void removePropertyChangeListener( PropertyChangeListener listener ) {
    this.pcs.removePropertyChangeListener( listener );
  }

}
