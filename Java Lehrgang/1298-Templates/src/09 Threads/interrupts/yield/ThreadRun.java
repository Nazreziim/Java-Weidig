package interrupts.yield;

import java.lang.Thread;


/**
 * Eine Klasse deren Exemplare Programmcode parallel ausführen sollen, muss Interface Runnable implementieren.
 * Sie schreibt eine run()-Funktion vor.
 * 
 * Version 3: Thread implementiert selbst Runnable. Warum nicht von Thread ableiten, dieser
 * stellt schon leere run() zur Verfügung.
 * 
 * @author Daniel
 *
 */

public class ThreadRun extends Thread{
	public static int count = 0;
	public final int id;
	
	public ThreadRun(int id) {//,ThreadGroup g){
		//super(g, "ThreadRun-"+id);
		this.id = id;
		/*
		 * wenns automatisch losgehen soll
		 * 
		 */
		//this.start();
	}
	/**
	 * Enthält parallel auszuführenden Code.
	 */
	public void run(){
		for(int i = 0; i<100; i++){
			if(i == 50){
				System.out.println("Thread Nr. "+this.id+ " yield");
				Thread.yield();
				try {
					Thread.sleep((long) (Math.random()*100));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			count++;
			System.out.println("Thread Nr. "+this.id+ " zählt " +count);
			
		}
		//By the way: jetzt ist der Thread fertig und wird anschließend zerstört
	}
}
