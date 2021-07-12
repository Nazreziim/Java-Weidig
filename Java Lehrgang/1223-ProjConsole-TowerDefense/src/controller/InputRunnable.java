package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import view.console.BashControl;

public class InputRunnable implements Runnable {

  private List< String > inputList;

  private boolean running;
  private ReentrantLock runningLock;

  public InputRunnable( List< String > inputList ) {
    this.running = true;
    this.runningLock = new ReentrantLock();
    this.inputList = inputList;
  }

  @Override
  public void run() {

    // Scanner scanner = new Scanner( System.in );
    InputStreamReader isr = new InputStreamReader( System.in );
    BufferedReader br = new BufferedReader( isr );
    StringBuilder sb = new StringBuilder();

    try {
      while ( this.running ) {
        while ( !br.ready() && this.running ) {
          Thread.yield();
        }
        if ( this.running ) {
          char c = (char) br.read();
          if ( c == 10 ) {
            inputList.add( sb.toString().trim().toUpperCase() );
            sb = new StringBuilder();
            BashControl.moveOneUpFirstColumn();
            BashControl.clearLine();
          } else {
            sb.append( c );
          }
        }
      }
    } catch ( IOException e ) {
      e.printStackTrace();
    }
  }

  public void stop() {
    this.running = false;
  }

}
