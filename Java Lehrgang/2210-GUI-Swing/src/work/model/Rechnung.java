package work.model;

import java.time.LocalDateTime;

public class Rechnung {
  private final double op1;
  private final double op2;
  private final double erg;
  private final LocalDateTime timestamp;
  private final Operation operation;

  public Rechnung( double op1, double op2, double erg, LocalDateTime timestamp ) {
    this(op1, op2, erg, timestamp, null);

  }
  
  public Rechnung( double op1, double op2, double erg, Operation operation ) {
    this(op1, op2, erg, null, operation);

  }
  
  public Rechnung( double op1, double op2, double erg, LocalDateTime timestamp,
          Operation operation ) {
    this.op1 = op1;
    this.op2 = op2;
    this.erg = erg;    
    if ( timestamp != null ) {
      this.timestamp = timestamp.withNano( 0 ); // wichtig fuer die Gleichheitsueberpruefung im TreeSet
    }
    else{
      this.timestamp = null;
    }
    this.operation = operation;
  }

  public double getOp1() {
    return op1;
  }

  public double getOp2() {
    return op2;
  }

  public double getErg() {
    return erg;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public Operation getOperation() {
    return operation;
  }

}
