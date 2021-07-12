package aufgaben.santa;

/**
 * Die Klasse für ein Rentier
 * Ist ein Daemon-Thread - da ein Rentier endlos zwischen Urlaub und Arbeit wechselt
 * und enden soll, wenn alle Nicht-Daemons (Santa, main) zuende sind.
 * @author LGerhard
 *
 */
public class Rendeer extends Thread {
	private String name;
	private boolean onVacation = true;
	
	public Rendeer() {
		char[] text = new char[6];
		for (int i = 0; i < text.length; i++) {
			text[i] = (char)((int)(Math.random() * 26) + 'A');
		}
		this.name = new String(text);
		this.setDaemon(true);
		this.start();
	}
	
	public Rendeer(String name) {
		this.name = name;
		this.setDaemon(true);
		this.start();
		
	}
	
	public boolean isOnVacation() {
		return onVacation;
	}
	
	
	public String getMyName() {
		return name;
	}
	
	
	public void run() {
		while (true) {				
			if (onVacation) {
				System.out.println("Rentier " + name + " ist im Urlaub.");
				gotoSleep(5000);
				onVacation = false;
				System.out.println("Rentier " + name + " kommt aus dem Urlaub zurück.");
			}
			
		}
		
	}

	public void getHitched() {
		if (!onVacation) {
			System.out.println("Rentier " + name + " wird eingespannt.");
			gotoSleep(1000);
		} 
		
	}


	public void getUnhitched() {
		this.onVacation = true;
		
	}
	
	/**
	 * Diese Methode schickt den Rendeer-Thread schlafen
	 * TODO: Durch das Pausieren werden Deadlocks möglichst vermieden - sollte also auch ohne gehen!
	 * @param long millis - Die Mindestdauer in Millisekunden
	 */
	private void gotoSleep(long millis) {
		try {
			Thread.sleep((long)(Math.random() * millis));
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
	}
	
}
