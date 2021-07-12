package beispiel03;

public class DaemonThread {

  public static void main( String[] args ) {

    Thread t = new Thread() {
      @Override
      public void run() {
        while ( true ) {
          System.out.println( "läuft..." );
        }
      }
    };

    t.setDaemon( true );
    t.start();

    System.out.println( "Ende für Heute!" );
  }

}
