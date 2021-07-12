package uebung5;

public class Kueche {

  public synchronized void essen( long grpId ) {
    System.out.println( "Kueche: Gruppe " + grpId + " ist beim essen." );
    try {
      Thread.sleep( (long) ( 10000 * Math.random() ) );
    } catch ( InterruptedException e ) {
    }
    System.out.println( "Kueche: Gruppe " + grpId + " ist fertig mit essen." );
  }
}
