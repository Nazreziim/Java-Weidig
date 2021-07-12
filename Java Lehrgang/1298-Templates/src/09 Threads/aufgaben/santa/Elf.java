package aufgaben.santa;

/**
 * Die Klasse für eine Elfe - ist ein Daemon-Thread, da eine Elfe zwischen
 * den Zuständen "Arbeiten" und "Auf Hilfe warten" endlos abwechselt und enden
 * soll, wenn alle Nicht-Daemons enden (Santa, main). 
 * @author LGerhard
 *
 */
public class Elf extends Thread {
	private int id;
	private boolean hasAProblem = false;
	private static int ctr = 0;
	
	public Elf() {
		this.id = ctr++;
		this.setDaemon(true);
		this.start();
	}
	
	public void run() {
		while (true) {
			
			if (!hasAProblem) {
				System.out.println("Elfe Nr. " + id + " arbeitet!");
				//gotoSleep(7000);
				System.out.println("Elfe Nr. " + id + " hat ein Problem!");
				hasAProblem = true;
				
			} 
		}
	}

	public boolean hasAProblem() {
		return hasAProblem;
	}
	
	public void solveProblem() {
		hasAProblem = false;
	}

	public int getElfId() {
		return id;
	}
	
	/**
	 * Diese Methode schickt den Elf-Thread schlafen
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
