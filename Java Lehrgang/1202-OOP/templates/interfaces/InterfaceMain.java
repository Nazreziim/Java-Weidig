package interfaces;

public class InterfaceMain {

  public static void main( String[] args ) {

    Flugzeug flugzeug = new Flugzeug();
    Vogel vogel = new Vogel();

    flugzeug.fliegen();
    vogel.fliegen();

    Object[] oArr = new Object[ 3 ];
    oArr[ 0 ] = vogel;
    oArr[ 1 ] = flugzeug;

    for ( Object o : oArr ) {
      if ( o instanceof Flugfaehig ) {
        ( (Flugfaehig) o ).fliegen();
      }
    }

    Flugzeug[] fArr = new Flugzeug[ 1 ];
    // fArr[0] = new Vogel();

    Flugfaehig[] flArr = new Flugfaehig[ 3 ];
    flArr[ 0 ] = vogel;
    flArr[ 1 ] = flugzeug;
    flArr[ 2 ] = new Flugzeug();

    for ( Flugfaehig fl : flArr ) {
      fl.fliegen();
    }

    try {
      Flugzeug kopie = (Flugzeug) flugzeug.clone();
    } catch ( CloneNotSupportedException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
