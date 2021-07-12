package alt.components.listen;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListFrame extends JFrame {
  DefaultListModel model;
  JTextField text;

  public ListFrame( int x, int y ) {
    super( "OwnFrame" );
    this.setSize( x, y );
    this.setLayout( new FlowLayout() );
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    model = new DefaultListModel();
    JList list = new JList( model );
    list.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );

    model.addElement( "Mickey Maus" );
    model.addElement( "Pluto" );
    model.addElement( "Goofy" );
    list.addListSelectionListener( new ListSelectionListener() {

      @Override
      public void valueChanged( ListSelectionEvent e ) {
        if ( !e.getValueIsAdjusting() ) {
          JList source = (JList) e.getSource();
          if ( source.getSelectedIndex() != -1 ) {
            ( (DefaultListModel) source.getModel() ).remove( source.getSelectedIndex() );
          }

          for ( Object o : source.getSelectedValues() )
            System.out.println( o );
          for ( Integer i : source.getSelectedIndices() )
            System.out.println( i );

        }
      }

    } );
    JList list2 = new JList( model );
    list2.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );

    text = new JTextField( 20 );
    text.addActionListener( new ActionListener() {

      @Override
      public void actionPerformed( ActionEvent e ) {
        model.addElement( text.getText() );

      }

    } );
    this.add( new JScrollPane( list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED ) );
    this.add( list2 );
    this.add( text );
    this.setVisible( true );
  }

  public static void main( String[] args ) {
    ListFrame f = new ListFrame( 640, 480 );

  }
}
