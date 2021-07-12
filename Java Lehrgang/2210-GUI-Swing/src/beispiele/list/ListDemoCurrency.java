package beispiele.list;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Currency;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListDemoCurrency extends JFrame {

  public ListDemoCurrency() {
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

    JList< String > liste = new JList< String >();
    liste.setVisibleRowCount( 5 );

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
        new ListDemoCurrency();
      }
    } );
  }

}
