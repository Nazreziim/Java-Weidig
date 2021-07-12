package basic_threading.v1;

public class Main {

	/**
	 * Version 2: start() - automatisch beim erzeugen der eigenen ThreadRun - Objekten
	 */
	public static void main(String[] args) {
		ThreadRun tr1 = new ThreadRun(1);
		ThreadRun tr2 = new ThreadRun(2);
		
		//nur run aufrufen, f�hrt zu sequentieller Abarbeitung
		tr1.run();
		tr2.run();
		
		//Thread-Objekt muss erzeugt werden, dem unsere ThreadRun-Referenzen �bergeben werden
		//Thread(Runnable target)
		Thread t1 = new Thread(tr1);
		Thread t2 = new Thread(tr2);
		
		//neue Threads starten, rufen run() der �bergebenen Objekte parallel auf. 
		//falls Thread schon l�uft -> IllegalThreadStateException
		t1.start();
		t2.start();
	}

}
