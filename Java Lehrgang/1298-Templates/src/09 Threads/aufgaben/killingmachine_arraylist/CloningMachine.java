package aufgaben.killingmachine_arraylist;


import java.util.ArrayList;

public class CloningMachine extends Thread{
	private ArrayList<Scratchy> band;

	public CloningMachine(ArrayList<Scratchy> band){
		this.band = band;
	}
	
	public void run(){
		long number = 0;
		
		while(!this.isInterrupted()){
			synchronized(band){
				
				if(this.band.size()<2){
					Scratchy s = new Scratchy(number);
					number++;
					band.add(s);
					System.out.println(s + " wurde geclont!" );
					band.notify();
				}
			}
			try {
				Thread.sleep((long) (1000*Math.random()));
			} catch (InterruptedException e) {
				break;
			}
		}
		
		
	}
	
	
}
