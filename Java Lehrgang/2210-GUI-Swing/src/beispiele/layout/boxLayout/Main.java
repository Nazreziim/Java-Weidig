package beispiele.layout.boxLayout;

import java.awt.EventQueue;

public class Main {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        BoxLayoutFrame frame = new BoxLayoutFrame( "BoxLayoutExample" );
      }
    } );
  }

}
