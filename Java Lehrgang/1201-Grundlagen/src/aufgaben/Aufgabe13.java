package aufgaben;

public class Aufgabe13 {

  public static void main( String[] args ) {

    int a = 4;
    int b = 3;

    System.out.println("Reine Ausgabe beider Werte:");
    System.out.println( a + " " + b );

    // Variable:
    System.out.println("Vertauschen durch zusätzliche Variable:");
    int tmp = a;
    a = b;
    b = tmp;

    System.out.println( a + " " + b );

    System.out.println("XOR Versuch:");
    // XOR:
    // a = 4 = 100
    // b = 3 = 011

    // 100 ^
    // 011
    // ---
    // 111 --> 7 
    a = a ^ b;

    // 111 ^
    // 011
    // ---
    // 100 --> 4
    b = a ^ b;

    // 111 ^
    // 100
    // ---
    // 011 --> 3
    a = a ^ b;

    System.out.println( a + " " + b );

    System.out.println("Addition:");
    // Addition:
    a = a + b; // a = 3 + 4 = 7
    b = a - b; // b = 7 - 4 = 3
    a = a - b; // a = 7 - 3 = 4

    System.out.println( a + " " + b );

    System.out.println("Differenz:");
    // Differenz:
    a = a - b; // a = 4 - 3 = 1
    b = a + b; // b = 1 + 3 = 4
    a = b - a; // a = 4 - 1 = 3

    System.out.println( a + " " + b );
    

    System.out.println("In einer Zeile:");
    // in einer Zeile:
    a += b - ( b = a );

    System.out.println( a + " " + b );

  }

}
