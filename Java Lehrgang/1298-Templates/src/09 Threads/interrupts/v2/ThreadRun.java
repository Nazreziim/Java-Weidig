package interrupts.v2;

import java.lang.Thread;


/**
 * Eine Klasse deren Exemplare Programmcode parallel ausf�hren sollen, muss Interface Runnable implementieren.
 * Sie schreibt eine run()-Funktion vor.
 * 
 * Version 3: Thread implementiert selbst Runnable. Warum nicht von Thread ableiten, dieser
 * stellt schon leere run() zur Verf�gung.
 * 
 * @author Daniel
 *
 */

public class ThreadRun extends Thread{
	public static int count = 0;
	public final int id;
	public boolean canceled = false;
	
	public ThreadRun(int id){
		this.id = id;
		/*
		 * wenns automatisch losgehen soll
		 * 
		 */
		//this.start();
	}
	/**
	 * Enth�lt parallel auszuf�hrenden Code.
	 */
	public void run(){
		//z�hlen bis Abbruch
		while(!this.canceled){
			count++;
			System.out.println("Thread Nr. "+this.id+ " z�hlt " +count);
			try {
				this.sleep(Math.round(Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//By the way: jetzt ist der Thread fertig und wird anschlie�end zerst�rt
	}
}
