package aufgaben.killingmachine_piped_io;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.ArrayList;

public class CloningMachine extends Thread{
	private PipedOutputStream band;

	public CloningMachine(PipedOutputStream band){
		this.band = band;
	}
	
	public void run(){
		int number = 0;
		
		while(!this.isInterrupted()){
			number++;
			try {
					band.write(number);
					System.out.println("Scratchy Nummer "+number + " wurde geclont!" );
				
			} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}			
			try {
				Thread.sleep((long) (1000*Math.random()));
			} catch (InterruptedException e) {
				this.interrupt();
			}
		}
		
		
	}
	
	
}
