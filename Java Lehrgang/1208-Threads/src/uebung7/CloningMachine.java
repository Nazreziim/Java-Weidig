package uebung7;

public class CloningMachine extends Thread {
  private AssemblyLine< Scratchy > assemblyLine;

  public CloningMachine( AssemblyLine< Scratchy > assemblyLine ) {
    this.assemblyLine = assemblyLine;
  }

  @Override
  public void run() {
    while ( !isInterrupted() ) {
      this.assemblyLine.add( new Scratchy() );
      System.out.println( "Clone Scratchy Nr. " + this.assemblyLine.element().getId() + "." );
      try {
        Thread.sleep( 200 );
      } catch ( InterruptedException e ) {
        System.err.println( "CloningMachine: Interrupt empfangen." );
        interrupt();
      }
    }
  }
}
