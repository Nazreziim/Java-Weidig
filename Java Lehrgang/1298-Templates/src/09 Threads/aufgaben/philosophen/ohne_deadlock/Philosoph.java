package aufgaben.philosophen.ohne_deadlock;
/**
 * Diese Klasse repräsentiert einen Philosoph aus dem<br>
 * bekannte Philosophen-Problem
 * <a href = "de.wikipedia.org">Philosophenproblem bei Wiki</a>
 * @see Gabel
 * @version 1.0
 * @since 11.05.2009
 * 
 *
 */
public class Philosoph extends Thread {

	/**
	 * Das ist die linke Gabel.<br>Umbruch
	 * @see Gabel
	 */
	private Gabel links;
	/**
	 * Das ist die rechte Gabel.
	 */
	private Gabel rechts;
	
	/**
	 * Beschreibung für den Konstruktor.
	 * @param name Das ist der Name des Philosophen
	 * @param links Das ist die linke Gabel
	 * @param rechts Das ist rechte Gabel.
	 */
	public Philosoph(String name, Gabel links, Gabel rechts){
		super(name);
		this.links = links;
		this.rechts = rechts;
	}
	/**
	 * Beschreibung von run
	 * 
	 */
	public void run(){
		while(true){
			essen();
			philosophieren();
			schlafen();
		}
	}
	/**
	 * 
	 * @return  Liefert immer false
	 * @throws Exception
	 */
	public boolean essen(){
		
		
		if (this.links.lock.tryLock() == true) {
			/** 
			 * Der nachfolgende Abschnitt erhöht die Wahrscheinlichkeit für einen Deadlock
			 */
			System.out.println(this.getName() + " nimmt linke Gabel");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (this.rechts.lock.tryLock() == true){
				System.out.println(this.getName() + " ißt!");
				try {
					Thread.sleep((long)Math.random()*5000+5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.rechts.lock.unlock();
			} else {
				System.out.println(this.getName() + " legt rechte Gabel wieder hin ohne zu essen!");
			}
			this.links.lock.unlock();
		} else {
			System.out.println(this.getName() + " legt linke Gabel wieder hin ohne zu essen!");
		}
		return false;
	}
	public void philosophieren(){
		System.out.println(this.getName() + " philosophiert!");
		try {
			Thread.sleep((long)Math.random()*5000+5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void schlafen(){
		System.out.println(this.getName() + " schläft!");
		try {
			Thread.sleep((long)Math.random()*5000+5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
