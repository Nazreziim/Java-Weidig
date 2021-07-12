package alt.components.version3_controls;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlsFrame extends JFrame {
  private int wert = 0;

  private class MySliderListener implements ChangeListener {

    @Override
    public void stateChanged( ChangeEvent e ) {
      JSlider s = (JSlider) e.getSource();
      wert = s.getValue();
      System.out.println( wert );
    }

  }

  public ControlsFrame( int x, int y ) {
    super( "OwnFrame" );
    this.setSize( x, y );
    this.setLayout( new GridLayout( 0, 2, 10, 10 ) );
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    JSlider slider = new JSlider( 0, 255, wert );
    slider.addChangeListener( new MySliderListener() );

    slider.setPaintTicks( true );
    slider.setMinorTickSpacing( 5 );
    slider.setMajorTickSpacing( 25 );
    slider.setPaintLabels( true );
    this.add( slider );

    Vector< Integer > namen = new Vector< Integer >();
    namen.add( 1 );
    namen.add( 2 );
    namen.add( 3 );
    JComboBox combo = new JComboBox( namen );
    combo.addActionListener( new ActionListener() {

      @Override
      public void actionPerformed( ActionEvent e ) {
        JComboBox box = (JComboBox) e.getSource();
        System.out.println( "ComboBox Event: " + box.getSelectedItem() );
      }

    } );

    combo.setMaximumRowCount( 2 );
    combo.setSelectedIndex( 1 );
    this.add( combo );

    SpinnerNumberModel model = new SpinnerNumberModel( 0, 0, 255, 1 );
    JSpinner spin = new JSpinner( model );
    spin.addChangeListener( new ChangeListener() {

      @Override
      public void stateChanged( ChangeEvent e ) {
        JSpinner sp = (JSpinner) e.getSource();
        System.out.println( sp.getValue() );

      }

    } );

    this.add( spin );
    this.setVisible( true );
  }

  public static void main( String[] args ) {
    ControlsFrame f = new ControlsFrame( 640, 480 );

  }
}
