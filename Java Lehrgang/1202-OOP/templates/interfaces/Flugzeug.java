package interfaces;

public class Flugzeug extends Maschine implements Flugfaehig, Transportieren, Gleitfaehig, Cloneable {

  Triebwerk triebwerk = new Triebwerk();
  
  @Override
  public void fliegen() {
    System.out.println( "Flugzeuf fliegt." );
  }

  @Override
  public void transportieren( String ladung ) {
    System.out.println( "Flugzeug transportiert " + ladung );
  }

  @Override
  public void gleiten() {
    System.out.println( "Gleitendes Flugzeug." );
  }
  
  @Override
  public Object clone() throws CloneNotSupportedException {
    Flugzeug copy = (Flugzeug) super.clone();
    copy.triebwerk = new Triebwerk();
    return copy;
  }

}
