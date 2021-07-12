package aufgaben.killingmachine_arraylist;

import java.util.ArrayList;

public class KillingMachine extends Thread{

	private ArrayList<Scratchy> band;
	
	public KillingMachine( ArrayList<Scratchy> band){
		this.band = band;
	}
	
	public void run(){
		while(!this.isInterrupted()){
			synchronized(this.band){
				if(this.band.size() > 0){
					Scratchy s = this.band.remove(0);
					Itchy.count++;
					System.out.println(s + " wurde zu Hackfleisch verarbeitet!" );
					System.out.println("Es verbleiben noch " + this.band.size() + " Scratchy's auf dem Band" );
					try {
						Thread.sleep((long) (1000 * Math.random()));
					} catch (InterruptedException e) {
						this.interrupt();
					}
				}
				else{
					try {
						this.band.wait();
					} catch (InterruptedException e) {
						this.interrupt();
					}
				}				
			}
			
		}
	}
}
