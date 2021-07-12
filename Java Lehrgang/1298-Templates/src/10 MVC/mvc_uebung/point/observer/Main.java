package mvc_uebung.point.observer;

public class Main {

	public static void main(String[] args){
		Model m = new Model(20,10);
		View v = new View(m);
		View2 v2 = new View2(m);
		Control c = new Control(m);
		c.letsGo();
	}
}
