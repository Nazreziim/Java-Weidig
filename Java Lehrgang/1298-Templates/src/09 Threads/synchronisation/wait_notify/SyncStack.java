package synchronisation.wait_notify;

import java.util.*;

public class SyncStack {
	private List<Character> buffer = new ArrayList<Character>(400);
	
	/** Synchronized um:
	* 1.) den buffer (gemeinsame Ressource) zu sch�tzen
	* 2.) Der Aufruf von wait muss innerhalb eines Blocks sein, der auf dem Stack-Objekt
	* 	  synchronized ist.
	*/
	public synchronized char pop() {
		char c;
		// Schleife n�tig, da wait() durch einen Interrupt von au�en
		// beendet werden kann - falls dann aber der buffer immer noch leer
		// ist, soll direkt weiter gewartet werden!
		while (buffer.size() == 0) {
			try {
				this.wait();  // Monitor ist das gemeinsam genutzte SyncStack-Objekt
			} catch (InterruptedException e) {
				
			}			
		}
		c = buffer.remove(buffer.size()-1);
		return c;
	}

	/** Synchronized um den buffer zu sch�tzen
	 * 	Der Aufruf von this.notify() l�sst einen einzelnen Thread, 
	 * 	der waiting ist, laufen(weil der Stack leer war)
	 * 
	 *  Dass der Aufruf vor der Nutzung der gem. Ressource kommt, spielt keine Rolle,
	 *  da der Lock auf dem Stack-Objekt erst nach Beendigung des synchronized-Blocks
	 *  wieder ge�ffnet wird
	 *  
	 * @param c
	 */
	
	public synchronized void push(char c) {
		this.notify();
		buffer.add(c);
	}

}
