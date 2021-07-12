package synchronisation.synchronized_method;

public class CounterSynchronized  {
	public int value = 0;
	
	/**
	 * Version 1:
	 * Diese Methode ist komplett thread-sicher durch das synchronized Schlüsselwort
	 */
//	public synchronized void increment() {
//		// Das Schlüsselwort synchronized sorgt dafür, dass die gesamte Methode
//		// atomar behandelt wird
//		int erg = this.value; // Lesen
//		erg++;		
//		try {// Das soll jetzt einen Moment dauern!
//			Thread.sleep((long)(Math.random()*100));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		this.value = erg;     // Schreiben
//	}

	
	/**
	 * Version 2:
	 * Diese Methode synchronisiert den kritischen Abschnitt - das Schreiben in value
	 */
	public void increment() {

		int erg = this.value; // Lesen		
		try {// Das soll jetzt einen Moment dauern!
			Thread.sleep((long)(Math.random()*100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		// Eigentlich genügt die Synchronisation des Schreibvorgangs
		// Synchronisation auf ein Monitor-Objekt (hier this)
		// Ein immer gut geeigneter Monitor ist auch getClass() - da Singleton
		synchronized(this) {
			erg++;		
			this.value = erg;     // Schreiben
		}
	}


}
