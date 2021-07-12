package work.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import work.contoller.RechnerController;
import work.model.Operation;
import work.model.Rechner;
import work.model.Rechnung;

public class KalkulatorPanel extends JPanel implements PropertyChangeListener {
  private static final long serialVersionUID = 1L;

  private Rechner rechner;
  private JTextField ergTextArea;
  private JSpinner op1TextField;
  private JSpinner op2TextField;
  
  public KalkulatorPanel(Rechner rechner) {
    
    this.rechner = rechner;

    JLabel op1Label = new JLabel( "1. Operator:", SwingConstants.RIGHT );
    JLabel op2Label = new JLabel( "2. Operator:", SwingConstants.RIGHT );
    JLabel ergLabel = new JLabel( "Ergebnis:", SwingConstants.RIGHT );

    this.op1TextField = new JSpinner(new SpinnerNumberModel(0.0, -10000000.0 , 10000000.0, 0.001));  
    this.op2TextField = new JSpinner(new SpinnerNumberModel(0.0, -10000000.0 , 10000000.0, 0.001));    
    ergTextArea = new JTextField();

    JButton addButton = new JButton( "+" );
    JButton subButton = new JButton( "-" );
    JButton multButton = new JButton( "*" );
    JButton divButton = new JButton( "/" );
    ActionListener actionListener = new ButtonActionListener();
    
    addButton.addActionListener( actionListener );
    addButton.setActionCommand( addButton.getText() );
    
    subButton.addActionListener( actionListener );
    subButton.setActionCommand( subButton.getText() );
    
    multButton.addActionListener( actionListener );
    multButton.setActionCommand( multButton.getText() );
    
    divButton.addActionListener( actionListener );
    divButton.setActionCommand( divButton.getText() );
    

    JPanel btnPanel = new JPanel();
    btnPanel.add( addButton );
    btnPanel.add( subButton );
    btnPanel.add( multButton );
    btnPanel.add( divButton );

    JPanel bildPanel = new JPanel();
    bildPanel.setPreferredSize( new Dimension( 60, 75 ) );
    bildPanel.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
    bildPanel.setLayout( null );

    try {
      BufferedImage image = ImageIO
              .read( new File( System.getProperty( "user.dir" ) + "\\pics\\calculator.gif" ) );
      // Bild skalieren
      // https://memorynotfound.com/java-resize-image-fixed-width-height-example/
      Image tmp = image.getScaledInstance( 60, 75, Image.SCALE_SMOOTH );
      BufferedImage resized = new BufferedImage( 60, 75, BufferedImage.TYPE_INT_ARGB );
      Graphics2D g2d = resized.createGraphics();
      g2d.drawImage( tmp, 0, 0, null );
      g2d.dispose();
      // Skalieren abgeschlossen
      JLabel bildLabel = new JLabel( new ImageIcon( resized ) );
      bildLabel.setBounds( 0, 0, 60, 75 );
      bildPanel.add( bildLabel );
    } catch ( IOException e ) {
      bildPanel.add( new JLabel( "X" ) );
    }

    JCheckBox checkbox = new JCheckBox( "Nachkommastellen", true );

    JRadioButton dezRB = new JRadioButton( "dezimal" );
    JRadioButton hexRB = new JRadioButton( "hexadezimal" );
    JRadioButton octRB = new JRadioButton( "octal" );
    JRadioButton binRB = new JRadioButton( "binär" );
    dezRB.setSelected( true );

    ButtonGroup darstellungGroup = new ButtonGroup();
    darstellungGroup.add( dezRB );
    darstellungGroup.add( hexRB );
    darstellungGroup.add( octRB );
    darstellungGroup.add( binRB );

    JPanel rbPanel = new JPanel();
    rbPanel.setLayout( new BoxLayout( rbPanel, BoxLayout.Y_AXIS ) );
    rbPanel.add( dezRB );
    rbPanel.add( hexRB );
    rbPanel.add( octRB );
    rbPanel.add( binRB );
    rbPanel.setBorder( BorderFactory.createTitledBorder( "Darstellung" ) );

    JLabel colorLabel = new JLabel( "Hintergrundfarbe:" );
    JComboBox< Color > colorComboBox = new JComboBox< Color >( new JComboBoxColorModel() );
    colorComboBox.setRenderer( new JComboBoxColorCellRenderer() );

    this.setLayout( new GridBagLayout() );
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets( 5, 5, 5, 5 );
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add( op1Label, gbc );

    gbc.gridx = 1;
    this.add( op1TextField, gbc );

    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add( op2Label, gbc );

    gbc.gridx = 1;
    this.add( op2TextField, gbc );

    gbc.gridx = 0;
    gbc.gridy = 2;
    this.add( ergLabel, gbc );

    gbc.gridx = 1;
    this.add( ergTextArea, gbc );

    gbc.gridx = 2;
    gbc.gridy = 0;
    gbc.gridheight = 3;
    this.add( bildPanel, gbc );

    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridheight = 1;
    gbc.gridwidth = 3;
    this.add( btnPanel, gbc );

    gbc.gridy = 4;
    this.add( checkbox, gbc );

    gbc.gridy = 5;
    this.add( rbPanel, gbc );

    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 1;
    this.add( colorLabel, gbc );

    gbc.gridwidth = 2;
    gbc.gridx = 1;
    this.add( colorComboBox, gbc );

  }

  class ButtonActionListener implements ActionListener{

    @Override
    public void actionPerformed( ActionEvent e ) {
        Rechnung rechnung  = null;
        Operation oper = null;
        
      // erste Ausbaustufe
        if ( e.getSource() instanceof JButton) {
          
          // Auslesen der Operatoren 
          Double wert1 = (Double) op1TextField.getValue();
          Double wert2 = (Double) op2TextField.getValue();
          
          // System.out.println( op1TextField.getValue() ); 
          // System.out.println( e.getActionCommand() );
          
          switch (e.getActionCommand()) {
            case "+":
             //  1 Umbau mit festen Werten
//              rechnung = rechner.add( 1.5, 1.4 );
              // 3.1 Operation wird ausgewaehlt
              oper = Operation.ADD;
              break;
            case "-":
              // 2 Werte aus Optionsfelder
              //rechnung = rechner.sub( wert1, wert2 );
              // 3.1 Operation wird ausgewaehlt
              oper = Operation.SUB;
              break;
            case "*":
              // 1 Umbau mit festen Werten
              //rechnung = rechner.mult( 3.5, 40 );
              // 3.1 Operation wird ausgewaehlt
              oper = Operation.MULT;
              break;
            case "/":
              //  2 Werte aus Optionsfelder
              //rechnung = rechner.div( wert1, wert2 );
              // 3.1 Operation wird ausgewaehlt
              oper = Operation.DIV;
              break;
            default:
                
          }
          
          //  1.1 / 1.2 direktes setzen des erg nach Berechnung in dieser Methode
//          if ( rechnung != null ) {
//            ergTextArea.setText( Double.valueOf( rechnung.getErg() ).toString());
//          }
          
          
          // 3 ueber Controller die Steuerung vornehmen
          // 3.2 Alle erforderlichen Eingabewerte fuer die Berechnung werden in ein
          // RechnungsObjekt verpackt und an alle Interessenten (RechnungsController) verschickt
          // siehe Anmeldung in MainFrame
          Rechnung newValue = new Rechnung(wert1, wert2, 0.0, oper);
          firePropertyChange("button", null, newValue );
        }
      
    }
    
  }

  // 3.6 KalkulationsPanel hoert auf die Ergebnis-Nachrichten vom Controller.
  // siehe Anmeldung im MainFrame
  @Override
  public void propertyChange( PropertyChangeEvent evt ) {
    
      if ( evt.getSource() instanceof RechnerController && evt.getNewValue() instanceof Rechnung) {
        Rechnung newValue = (Rechnung) evt.getNewValue();
        // 3.6  setzen des erg, Berechnung wurde im Controller angestossen und danach hier benachrichtigt.
        ergTextArea.setText( Double.valueOf( newValue.getErg() ).toString());
        
      }
    
  }
  
}
