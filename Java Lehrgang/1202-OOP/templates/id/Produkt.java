package id;

public class Produkt {

  // statisches Attribut bzw. Klassenvariable
  private static long counter;
  
  // static Block (wird beim Laden der Klasse ausgeführt)
  // hier werden statische Attribute initialisiert.
  static {
    counter = 0;
  }
  
  // Konstante
  // Konstanten werden (implizit) im Konstruktor initialisiert
  public final long ID;

  // Attribute werden (implizit) im Konstruktor initialisiert
  private String name = "Mustermann";

  public Produkt() {
    this( "" );
  }

  public Produkt( String name ) {
    Produkt.counter++;
    this.ID = Produkt.counter;
    this.name = name;
  }

  // statische Methode bzw. Klassenmethode
  public static long getCounter() {
    return counter;
  }

}
