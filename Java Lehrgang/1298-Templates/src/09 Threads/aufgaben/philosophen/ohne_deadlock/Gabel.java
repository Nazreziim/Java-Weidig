package aufgaben.philosophen.ohne_deadlock;

import java.util.concurrent.locks.*;

public class Gabel {
	public int id;
	private static int count = 1;
	public Lock lock = new ReentrantLock();
	
	public Gabel(){
		this.id = count;
		count++;
	}
	public String toString(){
		return "Gabel-" + this.id; 
	}
}
