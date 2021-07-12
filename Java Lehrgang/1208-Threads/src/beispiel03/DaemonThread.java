package beispiel03;

public class DaemonThread {

  public static void main( String[] args ) {

    Thread t = new Thread() {
      @Override
      public void run() {
        while ( true ) {
          System.out.println( "l�uft..." );
        }
      }
    };

    t.setDaemon( true );
    t.start();

    System.out.println( "Ende f�r Heute!" );
  }

}
