package work.view;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import work.model.Rechner;
import work.model.Rechnung;

public class LogDialog extends JDialog implements PropertyChangeListener {
  private static final long serialVersionUID = 1L;
  private Rechner rechner;
  private final JTextArea logArea;

  public LogDialog( JFrame owner, Rechner rechner ) {
    super( owner, false );
    this.rechner = rechner;
    this.logArea = new JTextArea();
    this.rechner.addVerlaufListener( this );
    this.setTitle( "Minikalkulator Hsl60 Log" );
    this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
    Rectangle ownerBounds = owner.getBounds();
    this.setBounds( new Rectangle(
            new Point( (int) ( ownerBounds.getMinX() ), (int) ( ownerBounds.getMaxY() + 100 ) ) ) );
    this.setPreferredSize( new Dimension( (int) ownerBounds.getWidth(), 200 ) );
    createAndShowGui();
  }

  private void createAndShowGui() {
    this.logArea.setEditable( false );

    for ( int i = 0; i < rechner.size(); ++i ) {
      logArea.append( print( rechner.get( i ) ) + "\n" );
    }

    JScrollPane scrollPane = new JScrollPane( logArea );

    this.add( scrollPane );

    this.pack();
    this.setVisible( true );
  }

  private String print( Rechnung r ) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" );
    StringBuffer sb = new StringBuffer( r.getTimestamp().format( dtf ) );
    sb.append( ": " );
    sb.append( r.getOp1() );
    sb.append( r.getOperation().getOperation() );
    sb.append( r.getOp2() );
    sb.append( "=" );
    sb.append( r.getErg() );
    return sb.toString();
  }

  @Override
  public void propertyChange( PropertyChangeEvent evt ) {
    if (evt.getPropertyName().equals( "addVerlauf" ) && evt.getNewValue() instanceof Rechnung) {
       logArea.append( print( rechner.get( rechner.size() - 1 ) ) + "\n" );
    }
    else if (evt.getPropertyName().equals( "clearVerlauf" ) && evt.getOldValue() instanceof Integer ) {
      
      logArea.append("==> Clear Veraluf \n");
    }
    
  }
  
  
  
}
