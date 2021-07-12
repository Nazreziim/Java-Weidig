package alt.einfuehrung.swing.version1;

import javax.swing.JFrame;

public class HelloSwingFrame {

  public static void main( String[] args ) {
    JFrame f = new JFrame( "Das Fenster zur Welt" );

    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 300, 200 );
    // System.out.println(f.isShowing());
    f.setVisible( true );
    // System.out.println(f.isShowing());

    // Fenster in den Hintergrund
    // f.toBack();

    // Größe verändern
    // f.setSize(200, 300);
    //f.setResizable(false);

    // Position verändern
    // f.setLocation((int)(Math.random()*1024), (int)(Math.random()*768));

    // KEIN show(), hide() - sind beide deprecated
  }
}
