package uebung7;

public class KillingMachine extends Thread {
  private AssemblyLine< Scratchy > assemblyLine;

  public KillingMachine( AssemblyLine< Scratchy > assemblyLine ) {
    this.assemblyLine = assemblyLine;
  }

  @Override
  public void run() {
    while ( !isInterrupted() ) {
      if ( assemblyLine.size() > 0 ) {
        System.out.println( "Zerstöre Scratchy Nr. " + assemblyLine.remove().getId() + "." );
      }
      try {
        Thread.sleep( 100 );
      } catch ( InterruptedException e ) {
        System.err.println( "KillingMachine: Interrupt empfangen." );
        interrupt();
      }
    }
  }
}
