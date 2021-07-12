package aufgaben.killingmachine_piped_io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.util.ArrayList;

public class KillingMachine extends Thread{

	private PipedInputStream band;
	
	public KillingMachine( PipedInputStream band){
		this.band = band;
	}
	
	public void run(){
		while(!this.isInterrupted()){
				try{
					int number = (int)band.read();
					Itchy.count++;
					System.out.println("Scratchy Nummer"+number + " wurde bearbeitet!" );
				
				}catch (IOException e) {
					// TODO: handle exception
				}				
				try {
					Thread.sleep((long) (1000 * Math.random()));
				} catch (InterruptedException e) {
					this.interrupt();
				}
		}
	}
}
