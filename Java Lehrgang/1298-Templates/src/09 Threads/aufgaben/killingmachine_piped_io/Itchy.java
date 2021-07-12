package aufgaben.killingmachine_piped_io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;

public class Itchy {
	public static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PipedInputStream inPipe = new PipedInputStream();
		PipedOutputStream outPipe;
		try {
			outPipe = new PipedOutputStream(inPipe);
			KillingMachine km = new KillingMachine(inPipe);
			CloningMachine cm = new CloningMachine(outPipe);
			cm.start();
			km.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	

	}

}
