package schritt6UebungZusatzLsg;
import schritt6UebungZusatz.*;

public class Flasche <F>{
  F inhalt = null;

  public boolean istLeer() {
    return ( inhalt == null );
  }

  public void fuellen( F g ) {
    inhalt = g;
  }

  public F leeren() {
    F result = inhalt;
    inhalt = null;
    return result;
  }

  public static void main( String[] varargs ) {
    // in generischer Implementierung soll
    // f1 nur f�r Bier dienen
    Flasche <Bier> f1 = new Flasche <Bier>();
    f1.fuellen( new Bier( "DHBW-Br�u" ) );
    System.out.println( "f1 geleert mit " + f1.leeren() );
    f1 = new Flasche <Bier>();
    f1.fuellen( new Bier( "DHBW-Export" ) );
    System.out.println( "f1 geleert mit " + f1.leeren() );

    // In der generischen Implementierung soll f2 nur f�r
    // Weinflaschen dienen
    Flasche <Wein> f2 ;
    f2 = new Flasche <Wein>();
    f2.fuellen( new Weisswein( "Pfalz" ) );
    System.out.println( "f2 geleert mit " + f2.leeren() );

    f2 = new Flasche <Wein>();
    f2.fuellen( new Rotwein( "Bordeaux" ) );
    System.out.println( "f2 geleert mit " + f2.leeren() );
    //System.out.println("Brauerei: "+((Bier)f2).getBrauererei());  //geht nicht, Wein kann nicht zu Bier gecastet werden!
  }
}
