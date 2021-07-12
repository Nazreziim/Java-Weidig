package alt.components.version2_jlabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SimpleLabelsFrame extends JFrame {

  public SimpleLabelsFrame( int x, int y ) {
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    this.setSize( x, y );
    // Setzen in die Mitte des Bildschirms
    // Toolkit ist eine Abstrakte-Klasse, für jedes Betriebssytem gibt es eine Implementierung, die
    // man mit
    // getDefaultToolkit bekommt, darüber Grafikinfos des Systems
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation( ( d.width - this.getSize().width ) / 2,
            ( d.height - this.getSize().height ) / 2 );

    JLabel l = new JLabel( "Hallo Welt!Und ihr da draußen!", SwingConstants.CENTER );
    // mehrzeilig
    // JLabel l = new JLabel( "Hallo Welt!\nUnd ihr da draußen!", SwingConstants.CENTER ); geht
    // nicht
    // JLabel l = new JLabel( "<html>Hallo Welt!<br>Und ihr da draußen!</html>"); geht
    l.setFont( new Font( "Serif", Font.BOLD, 30 ) );
    l.setForeground( Color.BLUE );
    this.add( l );

    this.setVisible( true );

  }

  public static void main( String[] args ) {
    SimpleLabelsFrame of = new SimpleLabelsFrame( 300, 200 );
  }
}
