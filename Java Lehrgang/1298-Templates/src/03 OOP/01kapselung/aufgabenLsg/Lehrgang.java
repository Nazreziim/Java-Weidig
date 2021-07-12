package misc;

public class Lehrgang {

  private long nr;
  private String name;
  private int dauer;

  public Lehrgang( long nr, String name, int dauer){
    this.nr = nr;
    this.name = name;
    this.dauer = dauer;
  }
  
  @Override
  public String toString() {
    return "Lehrgangsnr: " + this.nr + " Bezeichnung: " + name;
  }
  
  public static void main(String... args){
    Lehrgang l1 = new Lehrgang( 130454, "AnwProgBw - Java", 12);
    Lehrgang l2 = new Lehrgang( 131456, "AnwProgBw - Ada", 14);
    
    System.out.println( l1 );
    System.out.println( l2 );
  }
}
