package work.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MainFrameController {
  private MainFrame mainframe;
  private ScheduledThreadPoolExecutor scheduledPool;
  private DateTimeFormatter timeFormat;

  public MainFrameController( MainFrame mainframe ) {
    this.mainframe = mainframe;
    this.scheduledPool = new ScheduledThreadPoolExecutor( 1 );
    this.timeFormat = DateTimeFormatter.ofPattern( "HH:mm:ss" );

    this.createThreads();

    this.addMainFrameListener();

  }

  private void addMainFrameListener() {
    this.addMainFrameWindowListener();
  }

  private void addMainFrameWindowListener() {
    mainframe.addWindowListener( new WindowAdapter() {
      @Override
      public void windowClosed( WindowEvent e ) {
        System.out.println( "Das Fenster wurde geschlossen." );
        System.out.println( "ThreadPool beenden..." );
        scheduledPool.shutdown();
        System.out.println( "ThreadPool beendet" );
      }
    } );
  }

  private void createThreads() {
    this.createTimeThread();
    // Alternative zum ThreadPool
    // this.createTimeSwingWorker();
  }

  private void createTimeSwingWorker() {
    SwingWorker< Void, LocalDateTime > worker = new SwingWorker< Void, LocalDateTime >() {

      @Override
      protected Void doInBackground() throws Exception {
        while ( !this.isCancelled() ) {
          this.publish( LocalDateTime.now() );
          try {
            Thread.sleep( 1000 );
          } catch ( InterruptedException e ) {
            this.cancel( true );
          }
        }
        return null;
      }

      @Override
      protected void process( List< LocalDateTime > chunks ) {
        LocalDateTime now = chunks.get( chunks.size() - 1 );
        if ( mainframe != null && mainframe.getTimeLabel() != null ) {
          mainframe.getTimeLabel().setText( now.format( timeFormat ) );
        }
      }
    };
    worker.execute();
  }

  private void createTimeThread() {

    this.scheduledPool.scheduleAtFixedRate( new Runnable() {
      @Override
      public void run() {
        SwingUtilities.invokeLater( new Runnable() {
          @Override
          public void run() {
            if ( mainframe != null && mainframe.getTimeLabel() != null ) {
              mainframe.getTimeLabel().setText( LocalDateTime.now().format( timeFormat ) );
            }
          }
        } );
      }
    }, 1, 1, TimeUnit.SECONDS );
  }
}
