package alt.components.version5_colorchooser;

import javax.swing.SwingUtilities;

import alt.components.version5_colorchooser.models.Model;

public class Main {

  /**
   * @param args
   */
  public static void main( String[] args ) {
    Model m = new Model();
	System.out.println("Main " + Thread.currentThread().getName());
    // Control c = new Control(m);
    SwingUtilities.invokeLater( new Runnable() {
      @Override
      public void run() {
			System.out.println("invokeLater " + Thread.currentThread().getName());
        MainFrame f = new MainFrame( m );
      }
    } );
  }

}
