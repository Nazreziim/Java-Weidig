package ln1wdhlg2017.oop.a2SchachPaketLSG;

public class SchachMain {

  public static void main( String[] args ) {
    Brett b = new Brett();
    b.initialisieren();

    b.print();

    b.bedrohungslage();
  }
}
