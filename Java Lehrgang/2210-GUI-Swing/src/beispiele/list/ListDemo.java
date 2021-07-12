package beispiele.list;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ListDemo extends JFrame {

  public ListDemo() {
    super();
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    // Panel bauen
    JPanel panel = new JPanel();
    panel.setBorder( BorderFactory.createTitledBorder( "Accounts" ) );
    panel.setLayout( new GridLayout( 0, 2, 10, 10 ) );

    String[] values = new String[ 20 ];
    for ( int i = 0; i < values.length; ++i ) {
      values[ i ] = "Nutzer" + ( i + 1 );
    }

    DefaultListModel< String > lModel = new DefaultListModel< String >() {
      @Override
      public String getElementAt( int index ) {
        return "Account: " + super.getElementAt( index );
      }
    };

    JList< String > liste = new JList< String >( lModel );
    liste.setVisibleRowCount( 5 );
    for ( String s : values ) {
      lModel.addElement( s );
    }

    JScrollPane scroll = new JScrollPane( liste );

    panel.add( scroll );
    JButton b = new JButton( "Absenden" );
    panel.add( b );
    this.add( panel );

    this.pack();
    this.setVisible( true );

  }

  public static void main( String... strings ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        for ( Object o : UIManager.getInstalledLookAndFeels() ) {
          System.out.println( o );
        }
        try {
          UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
        } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e ) {
          e.printStackTrace();
        }
        new ListDemo();
      }
    } );
  }

}
