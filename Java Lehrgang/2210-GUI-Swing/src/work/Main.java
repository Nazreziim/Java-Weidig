package work;

import javax.swing.SwingUtilities;

import work.model.Rechner;
import work.view.MainFrame;

public class Main {
  // Instanzvariable des Singletons
  private static Main instance;
  // Monitor beim Erstellen des Singletons
  private static Object monitor = new Object();

  // Attribute von Main
  private final Rechner rechner;

  // Privater Konstruktor für den Singleton
  private Main() {
    this.rechner = new Rechner();
//    rechner.add( 1.5, 1.4 );
//    rechner.sub( Math.PI, 0.999 );
//    rechner.mult( 3.5, 40 );
//    rechner.div( 100, 0 );
  }

  
  // getInstance()-Methode für den Singleton
  public static Main getInstance() {
    // Prüfen ob schon eine Instanz existiert
    if ( Main.instance == null ) {
      // Wenn keine existiert, darf nur einer eine erstellen
      synchronized ( Main.monitor ) {
        // Falls weitere Threads gewartet haben, muss hier abgebrochen werden.
        if ( Main.instance == null ) {
          // Instanz erstellen.
          Main.instance = new Main();
        }
      }
    }
    // Instanz zurückliefern
    return Main.instance;
  }

  public Rechner getRechner() {
    return this.rechner;
  }

  public static void main( String[] args ) {
    SwingUtilities.invokeLater( new MainFrameRunnable( Main.getInstance().getRechner() ) );
  }

}
