package work.model;

import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;

public class Rechner {
  private final Verlauf verlauf;

  public Rechner() {
    this.verlauf = new Verlauf();
  }

  public Rechnung add( double op1, double op2 ) {
    LocalDateTime now = LocalDateTime.now();
    double erg = op1 + op2;
    Rechnung r = new Rechnung( op1, op2, erg, now, Operation.ADD );
    this.verlauf.add( r );
    return r;
  }

  public Rechnung sub( double op1, double op2 ) {
    LocalDateTime now = LocalDateTime.now();
    double erg = op1 - op2;
    Rechnung r = new Rechnung( op1, op2, erg, now, Operation.SUB );
    this.verlauf.add( r );
    return r;
  }

  public Rechnung mult( double op1, double op2 ) {
    LocalDateTime now = LocalDateTime.now();
    double erg = op1 * op2;
    Rechnung r = new Rechnung( op1, op2, erg, now, Operation.MULT );
    this.verlauf.add( r );
    return r;
  }

  public Rechnung div( double op1, double op2 ) {
    LocalDateTime now = LocalDateTime.now();
    double erg = op1 / op2;
    Rechnung r = new Rechnung( op1, op2, erg, now, Operation.DIV );
    this.verlauf.add( r );
    return r;
  }

  public void clear() {
    this.verlauf.clear();
  }

  public int size() {
    return this.verlauf.size();
  }

  public Rechnung get( int n ) {
    return this.verlauf.get( n );
  }
  
  public void addVerlaufListener( PropertyChangeListener l ) {
    this.verlauf.addVerlaufListener( l );
  }

  public void removeVeralufListener( PropertyChangeListener l ) {
    this.verlauf.removeVerlaufListener( l );
  }
}
