package grundlagen;

public class Main {

  public static void main( String[] args ) {
    // Testgraph
    Graph< Integer, Integer > graph = new Graph<>();

    // Zwei Knoten einfügen
    graph.einfuegen( 1, 0 );
    graph.einfuegen( 2, 0 );
    graph.einfuegen( 3, 0 );
    graph.einfuegen( 4, 0 );

    graph.einfuegen( 1, 2, 0 );
    graph.einfuegen( 2, 1, 0 );
    graph.einfuegen( 2, 3, 0 );

    System.out.println( "Anzahl Kanten: " + graph.kantenZaehlen() );
    System.out.println( "Isolierte Knoten: " + graph.hatIsolierteKnoten() );
  }
}
