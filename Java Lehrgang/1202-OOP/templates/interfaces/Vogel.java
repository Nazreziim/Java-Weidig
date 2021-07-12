package interfaces;

import java.io.Serializable;

public class Vogel extends Lebewesen implements Flugfaehig, Serializable {

//  private static final long serialVersionUID = 3617586828041749959L;

  /**
   * 
   */
  private static final long serialVersionUID = 3617586828041749959L;

  @Override
  public void fliegen() {
    System.out.println( "Vogel fliegt." );
  }

}
