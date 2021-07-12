package work;

import work.model.Rechner;
import work.view.MainFrame;
import work.view.MainFrameController;

public class MainFrameRunnable implements Runnable {

  private Rechner rechner;

  public MainFrameRunnable( Rechner rechner ) {
    this.rechner = rechner;
  }

  @Override
  public void run() {
    MainFrame mainframe = new MainFrame( 2020, 100, this.rechner );
    MainFrameController controller = new MainFrameController( mainframe );
  }
}
