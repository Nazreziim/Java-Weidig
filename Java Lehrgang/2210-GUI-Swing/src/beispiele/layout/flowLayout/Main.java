package beispiele.layout.flowLayout;

import java.awt.EventQueue;

public class Main {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        FlowLayoutFrame frame = new FlowLayoutFrame( "BorderLayoutExample" );
      }
    } );
  }

}
