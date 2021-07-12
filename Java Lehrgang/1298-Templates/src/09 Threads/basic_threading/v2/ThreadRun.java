package basic_threading.v2;

import java.lang.Thread;


/**
 * Eine Klasse deren Exemplare Programmcode parallel ausf�hren sollen,
 * muss Interface Runnable implementieren.
 * Sie schreibt eine run()-Funktion vor.
 * 
 * Version 2: Objekt verwaltet eigenen Thread, d.h. im Konstruktor
 * wird Thread erzeugt und this �bergeben. Anschlie�end gleich start().
 * 
 * Ableiten von dieser Klasse problematisch - denk dran in
 * Unterklassenkonstruktor wird erst super() aufgerufe,
 * d.h. eventuell Objekt nicht fertig und Thread l�uft schon.
 * @author Daniel
 *
 */

public class ThreadRun implements Runnable{
	public static int count = 0;
	public final int id;
	
	public ThreadRun(int id){
		this.id = id;
		(new Thread(this)).start();
	}
	/**
	 * Enth�lt parallel auszuf�hrenden Code.
	 */
	public void run(){
		for(int i = 0; i<100; i++){
			count++;
			System.out.println("Thread Nr. "+this.id
                                + "z�hlt " +count);
		}
	}
}
