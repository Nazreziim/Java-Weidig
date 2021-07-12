package basic_threading.v1;

import java.lang.Thread;


/**
 * Eine Klasse deren Exemplare Programmcode parallel ausf�hren sollen, muss Interface Runnable implementieren.
 * Sie schreibt eine run()-Funktion vor.
 * 
 *
 */

public class ThreadRun implements Runnable{
	public static int count = 0;
	public final int id;
	
	public ThreadRun(int id){
		this.id = id;
	}
	/**
	 * Enth�lt parallel auszuf�hrenden Code.
	 */
	public void run(){
		for(int i = 0; i<100; i++){
			count++;
			System.out.println("ThreadRun Nr. "+this.id+ " z�hlt " +count);	
		}
		//Thread.currentThread() : Klassenmethode liefert den Thread, der diese Methode ausf�hrt 
		System.out.println("This job was done by "+Thread.currentThread().getName()+" with id "+Thread.currentThread().getId());
	}
}
