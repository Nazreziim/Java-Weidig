package aufgaben.philosophen.mit_deadlock;

public class Gabel {
	public int id;
	private static int count = 1;
	
	public Gabel(){
		this.id = count;
		count++;
	}
	public String toString(){
		return "Gabel-" + this.id; 
	}
}
