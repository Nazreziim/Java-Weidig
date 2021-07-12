package beispiele.comboBox;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxDemo extends JFrame {

  public ComboBoxDemo() {
    super();
    String[] values = new String[]{ "USD", "GBP", "ISK", "EUR", "JPY", "AUD", "HKD", "KOR", "PHP" };

    ComboBoxModel< String > model = new DefaultComboBoxModel< String >( values ) {
      private static final long serialVersionUID = 1L;

      @Override
      public String getElementAt( int index ) {
        return "Währung " + super.getElementAt( index );
      }
    };
    JComboBox< String > box = new JComboBox< String >( model );

    box.setPreferredSize( new Dimension( 200, 50 ) );
    this.setLayout( new GridLayout( 0, 2, 10, 10 ) );
    this.add( box );
    JButton b = new JButton( "Absenden" );
    this.add( b );

    this.pack();
    this.setVisible( true );

  }

  public static void main( String... strings ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        new ComboBoxDemo();
      }
    } );
  }

}
