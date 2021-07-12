package synchronisation.critical_section;


public class Counter {

	public int value = 0;
	
	public void increment() {
		/* Das ist eine critical Section: 
		 * Es kann sein, dass zwischen Lesen und Schreiben der Scheduler den Thread wechselt
		 * Somit ist die Atomarität der Methode increment nicht mehr sichergestellt.  
		 */
		int erg = this.value; // Lesen
		erg++;		
		try {// Das soll jetzt einen Moment dauern!
			Thread.sleep((long)(Math.random()*100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.value = erg;     // Schreiben
	}

//	public int getValue() {
//		try {// Das soll jetzt einen Moment dauern!
//			Thread.sleep((long)(Math.random()*100));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return this.value;
//	}
}
