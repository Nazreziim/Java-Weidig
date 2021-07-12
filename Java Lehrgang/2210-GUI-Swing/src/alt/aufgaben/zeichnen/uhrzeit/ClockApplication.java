package alt.aufgaben.zeichnen.uhrzeit;


import java.util.Date;

import javax.swing.*;

public class ClockApplication {
	

  public static void main( String[] args )
  {
	JLabel label = new JLabel();
    JFrame f = new JFrame( "Die Uhrzeit" );
    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    f.setSize( 250, 100 );
    label.setText( String.format( "%tT", new Date() ));
    f.add(label);
    f.setVisible( true );
    
    for (int i=0; i<60; i++) {
    try {
		Thread.sleep(1000);
		label.setText( String.format( "%tT", new Date() ));
		f.repaint();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    }
    
  }
}
