package uebungen.aufgabe8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Main {

  public static void main( String[] args ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        // Fenster
        JFrame frame = new JFrame( "Aufgabe 8" );
        frame.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
        frame.setLocation( 100, 100 );
        BorderLayout bl = new BorderLayout( 3, 3 );
        frame.getContentPane().setLayout( bl );

        // TextField
        JTextField textField = new JTextField();
        textField.setEditable( false );
        JTextArea area = new JTextArea();
        textField.addCaretListener( new CaretListener() {

          @Override
          public void caretUpdate( CaretEvent e ) {
            System.out.println( "Test" );
            System.out.println( "'" + textField.getText() + "'" );
            if ( !textField.getText().isEmpty() ) {
              area.setText( "" );
              int zahl = Integer.parseInt( textField.getText() );
              for ( String s : generatePossibilitiesPhone( zahl ) ) {
                area.append( s + "\n" );
              }
            }
          }
        } );
        frame.add( textField, BorderLayout.NORTH );

        // Tasten
        JPanel buttons = new JPanel();
        GridLayout gl = new GridLayout( 3, 0, 3, 3 );
        buttons.setLayout( gl );
        // Zahlentasten
        for ( int i = 1; i < 10; ++i ) {
          JButton button = new JButton( Integer.toString( i ) );
          button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
              textField.setText( textField.getText() + ( (JButton) e.getSource() ).getText() );
            }
          } );

          button.setSize( 50, 50 );
          buttons.add( button );
        }

        frame.getContentPane().add( buttons, BorderLayout.CENTER );

        // TextArea
        area.setSize( 159, 160 );
        area.setMinimumSize( new Dimension( 159, 160 ) );
        JScrollPane textAreaPane = new JScrollPane( area );
        textAreaPane.setSize( area.getSize() );
        frame.add( textAreaPane, BorderLayout.SOUTH );

        frame.setSize( 500, 500 );
//        frame.pack();
        frame.setVisible( true );
      }
    } );

  }

  public static List< String > generatePossibilitiesPhone( int number ) {
    Map< Integer, List< String > > map = new HashMap< Integer, List< String > >();

    for ( int i = 0; i < 10; ++i ) {
      map.put( i, new ArrayList< String >() );
    }

    map.get( 0 ).add( "0" );
    map.get( 1 ).add( "1" );
    map.get( 2 ).addAll( Arrays.asList( "A", "B", "C" ) );
    map.get( 3 ).addAll( Arrays.asList( "D", "E", "F" ) );
    map.get( 4 ).addAll( Arrays.asList( "G", "H", "I" ) );
    map.get( 5 ).addAll( Arrays.asList( "J", "K", "L" ) );
    map.get( 6 ).addAll( Arrays.asList( "M", "N", "O" ) );
    map.get( 7 ).addAll( Arrays.asList( "P", "Q", "R", "S" ) );
    map.get( 8 ).addAll( Arrays.asList( "T", "U", "V" ) );
    map.get( 9 ).addAll( Arrays.asList( "W", "X", "Y", "Z" ) );

    return generatePossibilities( number, map );
  }

  private static List< String > generatePossibilities( int number,
          Map< Integer, List< String > > map ) {

    List< String > result = new LinkedList< String >();

    if ( number / 10 == 0 ) {
      for ( String s : map.get( number ) ) {
        result.add( s );
      }
    } else {
      int ziffer = number;
      int stelle = 1;
      while ( ziffer / 10 > 0 ) {
        ziffer /= 10;
        stelle *= 10;
      }

      List< String > listeEndeString = generatePossibilities( number - ziffer * stelle, map );
      for ( String s : map.get( ziffer ) ) {
        for ( String sEnde : listeEndeString ) {
          result.add( s + sEnde );
        }
      }
    }
    return result;
  }
}
