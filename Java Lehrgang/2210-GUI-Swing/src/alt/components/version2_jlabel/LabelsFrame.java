/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package alt.components.version2_jlabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

/**
 *
 * @author dborkowitz
 */
public class LabelsFrame extends JFrame {
  JLabel label;

  public LabelsFrame( String titel ) {
    super( titel );
    // this.setLayout(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    // setSize(300, 200);

    // 1.) Font global für alle Labels ändern
    Font f = new Font( "Courier New", Font.ITALIC, 20 );
    try {
      f = Font.createFont( Font.PLAIN, getClass().getResourceAsStream( "/res/Powerweld.ttf" ) );
      f = f.deriveFont( 30.0f );
    } catch ( Exception ex ) {
    }
    UIDefaults uIDefaults = UIManager.getDefaults();
    uIDefaults.put( "Label.font", f );

    JPanel panel = new JPanel();
    this.add( panel );

    // 2.) Labels erstellen
    label = new JLabel( "Unser Label" );
    label.setToolTipText( "Dies ist die Präsentation eines JLabels" );
    label.setBorder( BorderFactory
            .createTitledBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED ), "Label" ) );
    label.setPreferredSize( new Dimension( 200, 200 ) );
    label.setMaximumSize( new Dimension( 20, 20 ) );
    label.setMinimumSize( new Dimension( 20, 20 ) );
    panel.add( label );

    JLabel label1 = new JLabel( "Label1", JLabel.LEFT );
    label1.setPreferredSize( new Dimension( 200, 200 ) );
    label1.setBorder( label.getBorder() );

    JLabel label2 = new JLabel( "Label2", JLabel.TRAILING );
    label2.setPreferredSize( new Dimension( 200, 200 ) );
    label2.setBorder( label.getBorder() );
    Icon icon = new ImageIcon( "./12 GUI/res/trash.gif" );

    JLabel label3 = new JLabel( "Label mit Icon", icon, JLabel.LEFT );
    label3.setHorizontalAlignment( JLabel.RIGHT );
    label3.setPreferredSize( new Dimension( 200, 200 ) );
    label3.setBorder( label.getBorder() );
    label3.setFont( f );
    label3.setText( "Etwas anderes" );

    panel.add( label1 );
    panel.add( label2 );
    panel.add( label3 );

    // 3.) Applikations-Icon ändern
    try {
      BufferedImage i = ImageIO.read( new File( "./12 GUI/res/trash.gif" ) );
      this.setIconImage( i );
    } catch ( IOException ex ) {
      Logger.getLogger( LabelsFrame.class.getName() ).log( Level.SEVERE, null, ex );
    }

    // 4.) Button hinzufügen
    JButton button = new JButton( "Unser Button" );
    // button.addActionListener(new ActionListener() {
    // public void actionPerformed(ActionEvent e) {
    // buttonAction();
    // }
    // });
    panel.add( button );

    // 5.) Aufruf zur automatischen Größenanpassung!
    this.pack();

  }

  // private void buttonAction() {
  // label.setText("Click");
  // }

  public static void main( String[] args ) {
    LabelsFrame f = new LabelsFrame( "Das Fenster zur Welt" );

    f.setVisible( true );
  }
}
