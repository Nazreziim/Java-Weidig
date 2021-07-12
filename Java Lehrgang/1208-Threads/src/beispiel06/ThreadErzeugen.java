package beispiel06;

public class ThreadErzeugen {
  public static void main( String... args ) {
    Thread a = new Thread( new CounterCommand() );
    Thread b = new Thread( new DateCommand() );

    System.out.println( "Priorit‰t von a: " + a.getPriority() );
    System.out.println( "Priorit‰t von b: " + b.getPriority() );

    // Hat nur geringe Auswirkungen
    System.out.println( "Setz bei b neue Priorit‰t: " + ( b.getPriority() + 1 ) );
    b.setPriority( b.getPriority() + 1 );

    // Hat groﬂe Auswirkungen
    System.out.println( "Setz bei a neue Priorit‰t: " + ( a.getPriority() - 1 ) );
    b.setPriority( a.getPriority() - 1 );

    System.out.println( "Starte Threads:" );
    b.start();
    a.start();
  }
}
