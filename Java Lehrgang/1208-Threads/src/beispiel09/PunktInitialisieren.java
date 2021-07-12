package beispiel09;

import java.awt.Point;

public class PunktInitialisieren {

  public static void main( String[] args ) {
    Point p = new Point();

    Runnable r = new Runnable() {
      @Override
      public void run() {
        int x = (int) ( Math.random() * 1000 );
        int y = x;

        while ( true ) {
          p.x = x; // schreiben
          p.y = y; // ---

          int xc = p.x; // lesen
          int yc = p.y; // ---

          if ( xc != yc ) {
            System.out.println( "Aha: x=" + xc + ", y=" + yc );
          }
        }
      }
    };

    new Thread( r ).start();
    new Thread( r ).start();
  }

}
