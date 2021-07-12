package beispiel01;

public class ThreadErzeugen {
  public static void main( String... args ) {

    Thread b = new Thread( new DateCommand() );
    b.start();
    
    Thread a = new Thread( new CounterCommand() );
    a.start();
  }
}
