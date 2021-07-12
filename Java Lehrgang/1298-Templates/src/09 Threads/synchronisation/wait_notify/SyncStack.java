package synchronisation.wait_notify;

import java.util.*;

public class SyncStack {
	private List<Character> buffer = new ArrayList<Character>(400);
	
	/** Synchronized um:
	* 1.) den buffer (gemeinsame Ressource) zu schützen
	* 2.) Der Aufruf von wait muss innerhalb eines Blocks sein, der auf dem Stack-Objekt
	* 	  synchronized ist.
	*/
	public synchronized char pop() {
		char c;
		// Schleife nötig, da wait() durch einen Interrupt von außen
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

	/** Synchronized um den buffer zu schützen
	 * 	Der Aufruf von this.notify() lässt einen einzelnen Thread, 
	 * 	der waiting ist, laufen(weil der Stack leer war)
	 * 
	 *  Dass der Aufruf vor der Nutzung der gem. Ressource kommt, spielt keine Rolle,
	 *  da der Lock auf dem Stack-Objekt erst nach Beendigung des synchronized-Blocks
	 *  wieder geöffnet wird
	 *  
	 * @param c
	 */
	
	public synchronized void push(char c) {
		this.notify();
		buffer.add(c);
	}

}
