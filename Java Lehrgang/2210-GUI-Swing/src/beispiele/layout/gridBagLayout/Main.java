package beispiele.layout.gridBagLayout;

import java.awt.EventQueue;

public class Main {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        GridBagLayoutFrame frame = new GridBagLayoutFrame( "GridBagLayoutExample" );
      }
    } );
  }

}
