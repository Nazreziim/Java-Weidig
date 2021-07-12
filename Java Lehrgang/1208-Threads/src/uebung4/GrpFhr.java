package uebung4;

public class GrpFhr extends Soldat {

  private Soldat[] gruppe;
  private long grpId;

  public GrpFhr( long grpId, Soldat[] gruppe ) {
    this.grpId = grpId;
    this.gruppe = gruppe;
  }

  @Override
  public void run() {
    System.out.println( "GrpFhr: Gruppe " + this.grpId + " packt euer Zeug." );

    if ( gruppe != null ) {
      for ( int i = 0; i < this.gruppe.length; ++i ) {
        if ( this.gruppe[ i ] != null ) {
          this.gruppe[ i ].start();
        }
      }

      for ( int i = 0; i < this.gruppe.length; ++i ) {
        if ( this.gruppe[ i ] != null ) {
          try {
            this.gruppe[ i ].join();
          } catch ( InterruptedException e ) {
            System.out.println( "Wer stört mich beim Warten?" );
          }
        }
      }

      System.out.println( "GrpFhr: Gruppe " + this.grpId + " ist fertig mit packen." );
      System.out.println( "GrpFhr: Gruppe " + this.grpId + " marschiert zum Essen." );
      try {
        Thread.sleep( (long) ( 5000 * Math.random() ) );
      } catch ( InterruptedException e ) {
      }
      System.out.println( "GrpFhr: Gruppe " + this.grpId + " ist angekommen." );
      System.out.println( "GrpFhr: Gruppe " + this.grpId + " ist beim Essen." );
      try {
        Thread.sleep( (long) ( 10000 * Math.random() ) );
      } catch ( InterruptedException e ) {
      }
      System.out.println( "GrpFhr: Gruppe " + this.grpId + " ist zurück." );

    }
  }
}
