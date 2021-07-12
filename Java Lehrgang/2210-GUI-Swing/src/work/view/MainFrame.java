package work.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import work.contoller.RechnerController;
import work.model.Rechner;

public class MainFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private Rechner rechner;
  private JLabel timeLabel;

  public MainFrame( int posX, int posY, Rechner rechner ) {
    this.rechner = rechner;
    this.setTitle( "Minikalkulator Hsl60" );
    this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );

    createAndShowGui( posX, posY );
  }

  private void createAndShowGui( int posX, int posY ) {

    JMenuBar menuBar = new JMenuBar();
    JMenu jmDatei = new JMenu( "Datei" );
    JMenuItem jmiDateiVerlauf = new JMenuItem( "Verlauf" );
    MainFrame mainFrame = this;
    jmiDateiVerlauf.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent e ) {
        new VerlaufDialog( mainFrame, rechner );
      }
    } );
    jmDatei.add( jmiDateiVerlauf );
    JMenuItem jmiDateiBeenden = new JMenuItem( "Beenden" );
    jmDatei.add( jmiDateiBeenden );
    JMenu jmHilfe = new JMenu( "Hilfe" );
    JMenuItem jmiHilfeLog = new JMenuItem( "Log" );
    jmiHilfeLog.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent e ) {
        new LogDialog( mainFrame, rechner );
      }
    } );
    jmHilfe.add( jmiHilfeLog );
    JMenuItem jmiHilfeVersion = new JMenuItem( "Version" );
    jmHilfe.add( jmiHilfeVersion );

    menuBar.add( jmDatei );
    menuBar.add( jmHilfe );
    this.setJMenuBar( menuBar );

    JLabel header = new JLabel( "Minikalkulator", SwingConstants.CENTER );
    Font font = header.getFont();
    Map< TextAttribute, Object > attr = (Map< TextAttribute, Object >) font.getAttributes();
    attr.put( TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON );
    attr.put( TextAttribute.SIZE, 20 );
    attr.put( TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD );
    header.setFont( font.deriveFont( attr ) );

    this.add( header, BorderLayout.NORTH );

    KalkulatorPanel kalkPanel = new KalkulatorPanel(rechner);
    RechnerController rechnerCont = new RechnerController(rechner);
    // zu 3. Controller meldet sich an KalkulationsPanel an.
    kalkPanel.addPropertyChangeListener( rechnerCont );
    // zu 3. KalkulationsPanel meldet sich an Controller an.
    rechnerCont.addErgebnisListener( kalkPanel );

    this.add( kalkPanel, BorderLayout.CENTER );

    JPanel statusBar = new JPanel();
    statusBar.setBorder( BorderFactory.createLineBorder( Color.BLACK, 1 ) );
    statusBar.setLayout( new BoxLayout( statusBar, BoxLayout.X_AXIS ) );
    LocalDateTime ldt = LocalDateTime.now();
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern( "HH:mm:ss" );
    JLabel datePanel = new JLabel( ldt.format( DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) ) );
    this.timeLabel = new JLabel( ldt.format( timeFormat ) );
    statusBar.add( datePanel );
    statusBar.add( Box.createHorizontalGlue() );
    statusBar.add( timeLabel );
    this.add( statusBar, BorderLayout.SOUTH );

    this.setBounds( new Rectangle( new Point( posX, posY ) ) );
    this.pack();
    this.setVisible( true );

    // new VerlaufDialog( this, this.rechner );

    // new LogDialog( this, this.rechner );
    // JOptionPane.showMessageDialog( this, "Nachricht", "Title2", JOptionPane.WARNING_MESSAGE );

  }

  public JLabel getTimeLabel() {
    return this.timeLabel;
  }

}
