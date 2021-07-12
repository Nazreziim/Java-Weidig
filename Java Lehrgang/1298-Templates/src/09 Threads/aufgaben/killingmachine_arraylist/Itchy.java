package aufgaben.killingmachine_arraylist;


import java.util.ArrayList;

public class Itchy {
	public static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Scratchy> band = new ArrayList<Scratchy>();
		KillingMachine km = new KillingMachine(band);
		CloningMachine cm = new CloningMachine(band);
		cm.start();
		km.start();
		while(count < 20){
			synchronized(band){
				try {
					band.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		cm.interrupt();
		km.interrupt();

	}

}
