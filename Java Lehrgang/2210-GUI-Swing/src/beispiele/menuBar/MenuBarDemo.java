package beispiele.menuBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class MenuBarDemo extends JFrame {

  public MenuBarDemo() {
    this( "" );
  }

  public MenuBarDemo( String name ) {
    super( name );
    JFrame root = this;
    this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    this.setPreferredSize( new Dimension( 500, 500 ) );

    // JMenuBar bauen
    JMenuBar menu = new JMenuBar();
    // JMenu Datei bauen
    JMenu menuDatei = new JMenu( "Datei" );
    JMenuItem menuDateiOeffnen = new JMenuItem( "Open..." );
    menuDateiOeffnen.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent arg0 ) {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog( root );
        if ( result == JFileChooser.APPROVE_OPTION ) {
          File file = fc.getSelectedFile();
          System.out.println( "Datei: " + file.getAbsolutePath()
                  + " wurde ausgewählt und kann jetzt weiter verwendet werden." );
          JLabel pic = new JLabel( new ImageIcon( file.getAbsolutePath() ) );
          pic.setPreferredSize( new Dimension( 100, 100 ) );
          root.add( pic );
          root.validate();
          root.update( pic.getGraphics() );
        } else {
          System.out.println( "Öffnen Dialog wurde abgebrochen." );
        }
      }
    } );
    menuDatei.add( menuDateiOeffnen );
    JMenuItem menuDateiSpeichern = new JMenuItem( "Speichern" );
    menuDateiSpeichern.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent arg0 ) {
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog( root );
        if ( result == JFileChooser.APPROVE_OPTION ) {
          File file = fc.getSelectedFile();
          System.out.println( "Datei: " + file.getAbsolutePath()
                  + " wurde ausgewählt und kann jetzt weiter verwendet werden." );
        } else {
          System.out.println( "Öffnen Dialog wurde abgebrochen." );
        }
      }
    } );
    menuDatei.add( menuDateiSpeichern );
    JMenu menuDateiImport = new JMenu( "Import" );
    menuDatei.add( menuDateiImport );
    JMenuItem menuDateiImportPdf = new JMenuItem( "PDF" );
    menuDateiImportPdf.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent arg0 ) {
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed( false );
        javax.swing.filechooser.FileFilter filterPdf = new javax.swing.filechooser.FileFilter() {
          @Override
          public boolean accept( File pathname ) {
            boolean result = false;
            String fileName = pathname.getName();
            if ( pathname.isDirectory()
                    || fileName.substring( fileName.length() - 3, fileName.length() )
                            .equalsIgnoreCase( "PDF" ) ) {
              return true;
            }
            return result;
          }

          @Override
          public String getDescription() {
            return "PDF";
          }
        };
        fc.addChoosableFileFilter( filterPdf );
        int result = fc.showOpenDialog( root );
        if ( result == JFileChooser.APPROVE_OPTION ) {
          File file = fc.getSelectedFile();
          System.out.println( "Datei: " + file.getAbsolutePath()
                  + " wurde ausgewählt und kann jetzt weiter verwendet werden." );
        } else {
          System.out.println( "Öffnen Dialog wurde abgebrochen." );
        }
      }
    } );
    menuDateiImport.add( menuDateiImportPdf );
    JMenuItem menuDateiImportDocx = new JMenuItem( "DOCX" );
    menuDateiImport.add( menuDateiImportDocx );
    JMenuItem menuDateiImportTxt = new JMenuItem( "TXT" );
    menuDateiImport.add( menuDateiImportTxt );
    JMenuItem abfrage = new JMenuItem( "Abfrage Dialog..." );
    abfrage.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent arg0 ) {
        int result = JOptionPane.showConfirmDialog( root, "Wollen Sie das wirklich tun?" );
        System.out.println( result );
      }
    } );
    menuDatei.add( abfrage );
    JMenuItem dialog = new JMenuItem( "Dialog..." );
    dialog.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent arg0 ) {
        JDialog dialog = new JDialog( root, "Dialog Fenster" );
        // , Dialog.ModalityType.DOCUMENT_MODAL );
        dialog.getContentPane().setLayout( new GridLayout( 0, 2 ) );
        JLabel dialogLabel = new JLabel( "Test Text" );
        dialogLabel.setPreferredSize( new Dimension( 100, 30 ) );
        dialog.add( dialogLabel );

        JButton b = new JButton( "Schließen" );
        b.addActionListener( new ActionListener() {

          @Override
          public void actionPerformed( ActionEvent arg0 ) {
            dialog.dispose();
          }
        } );
        dialog.add( b );
        dialog.pack();
        dialog.setVisible( true );
      }
    } );
    menuDatei.add( dialog );
    menuDatei.addSeparator();
    JMenuItem beenden = new JMenuItem( "Beenden" );
    beenden.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent arg0 ) {
        root.dispose();
      }
    } );
    menuDatei.add( beenden );
    // ** ENDE JMenu Datei bauen
    // Datei zur MenuBar hinzufügen
    menu.add( menuDatei );

    // JMenu Bearbeiten bauen
    JMenu menuBearbeiten = new JMenu( "Bearbeiten" );
    menu.add( menuBearbeiten );
    JMenuItem menuBearbeitenFarbe = new JMenuItem( "Farbe wählen ..." );
    menuBearbeitenFarbe.addActionListener( new ActionListener() {

      @Override
      public void actionPerformed( ActionEvent arg0 ) {
        Color farbeNeu = JColorChooser.showDialog( root, "Wählen Sie eine Farbe.",
                root.getBackground() );
        System.out.println( "Gewählte Farbe: " + farbeNeu );
      }
    } );
    // ** ENDE JMenu Bearbeiten bauen
    // Bearbeiten zur MenuBar hinzufügen
    menuBearbeiten.add( menuBearbeitenFarbe );

    // JMenu credits bauen
    JMenu credits = new JMenu( "Credits" );
    credits.addMouseListener( new MouseAdapter() {
      @Override
      public void mouseClicked( MouseEvent e ) {
        super.mouseClicked( e );
        System.out.println( "Credits" );
        JDialog creditsDialog = new JDialog( root, "Credits" );
        creditsDialog.setLayout( new GridLayout( 0, 2 ) );
        creditsDialog.add( new JLabel( "Version:" ) );
        creditsDialog.add( new JLabel( "0.0.0.1 pre alpha" ) );
        creditsDialog.add( new JLabel( "Entwickler" ) );
        creditsDialog.add( new JLabel( "<Name des Entwicklers>" ) );
        creditsDialog.pack();
        creditsDialog.setVisible( true );
      }
    } );
    // ** ENDE JMenu credits bauen
    // credits zur MenuBar hinzufügen
    menu.add( credits );

    menu.add( new JSeparator() );
    this.setJMenuBar( menu );

    this.pack();
    this.setVisible( true );
  }

  public static void main( String... strings ) {
    EventQueue.invokeLater( new Runnable() {
      @Override
      public void run() {
        try { // Look and Feel setzen
          UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
        } catch ( ClassNotFoundException e ) {
        } catch ( InstantiationException e ) {
        } catch ( IllegalAccessException e ) {
        } catch ( UnsupportedLookAndFeelException e ) {
        }
        new MenuBarDemo();
      }
    } );
  }
}
