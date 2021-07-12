package random;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeListener;

public class Random {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        createAndShowGui();
      }
    } );

  }

  public static void createAndShowGui() {
    try {
      UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
    } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException
            | UnsupportedLookAndFeelException e ) {
      e.printStackTrace();
    }

    JFrame window = new JFrame( "Randomizer" );
    window.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();

    JPanel root = new JPanel();
    root.setLayout( new GridLayout( 0, 2, 3, 3 ) );
    root.setBorder( BorderFactory.createEmptyBorder( 3, 3, 3, 3 ) );

    JLabel labelMin = new JLabel( "Minimalwert:" );
    root.add( labelMin );
    JSpinner spinnerMin = new JSpinner(
            new SpinnerNumberModel( 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1 ) );
    root.add( spinnerMin );

    JLabel labelMax = new JLabel( "Maximalwert:" );
    root.add( labelMax );
    JSpinner spinnerMax = new JSpinner(
            new SpinnerNumberModel( 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1 ) );
    root.add( spinnerMax );

    JLabel labelZufall = new JLabel( "Zufall:" );
    root.add( labelZufall );
    JTextField tfZufall = new RandomTextField( (SpinnerNumberModel) spinnerMin.getModel(),
            (SpinnerNumberModel) spinnerMax.getModel() );
    spinnerMin.addChangeListener( (ChangeListener) tfZufall );
    spinnerMax.addChangeListener( (ChangeListener) tfZufall );
    tfZufall.setEditable( false );
    root.add( tfZufall );

    JButton bRandom = new JButton( "Random" );
    bRandom.addActionListener( (ActionListener) tfZufall );
    root.add( bRandom );

    JButton bClose = new JButton( "Close" );
    bClose.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent arg0 ) {
        window.dispose();
      }
    } );
    root.add( bClose );

    window.add( root );
    window.pack();
    window.setBounds( (int) ( screenDim.getWidth() / 2 - window.getWidth() / 2 ), //
            (int) ( screenDim.getHeight() / 2 - window.getHeight() / 2 ), //
            window.getWidth(), //
            window.getHeight() );
    window.setVisible( true );
  }

}
