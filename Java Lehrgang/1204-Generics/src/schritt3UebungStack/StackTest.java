package schritt3UebungStack;

public class StackTest {
  public static void main( String... strings ) {
    Stack< Integer > intStack = new Stack< Integer >();
    intStack.push( 3 );
    intStack.push( 5 );
    System.out.println( "Top: " + intStack.top() );
    System.out.println( "Pop: " + intStack.pop() );
    System.out.println( "Pop: " + intStack.pop() );
    System.out.println( "isEmpty: " + intStack.isEmpty() );

    Stack< Double > doubleStack = new Stack<>();
    doubleStack.push( Math.PI );
    System.out.println( doubleStack.pop() );

    // Stack< Rennschnecke > schneckenStack = new Stack<>();
    // schneckenStack.push( new Rennschnecke( "Andy", "Feldafinger", 100 ) );
    // System.out.println( schneckenStack.pop() );

    Stack< Mensch > menschStack = new Stack< Mensch >();
    menschStack.push( new Mensch( "Max", 11, 149 ) );
    System.out.println( menschStack.pop() );

    // Stack< Zeitung > zStack = new Stack<>();
    // zStack.push( new Zeitung( "Abendzeitung", "2017-07-10" ) );
    // System.out.println( zStack.pop() );

    Integer i = 5;
    System.out.println( i );
  }
}
