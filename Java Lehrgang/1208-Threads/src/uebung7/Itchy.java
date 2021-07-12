package uebung7;

public class Itchy {

  public static void main( String[] args ) {

    AssemblyLine< Scratchy > assemblyLine = new AssemblyLine<>();

    CloningMachine cloningMachine = new CloningMachine( assemblyLine );
    KillingMachine killingMachine = new KillingMachine( assemblyLine );

    cloningMachine.start();
    killingMachine.start();

    try {
      Thread.sleep( (long) ( 10000 + Math.random() * 5000 ) );
    } catch ( InterruptedException e ) {
    }

    cloningMachine.interrupt();
    try {
      Thread.sleep( 1000L );
    } catch ( InterruptedException e ) {
    }

    killingMachine.interrupt();
  }

}
