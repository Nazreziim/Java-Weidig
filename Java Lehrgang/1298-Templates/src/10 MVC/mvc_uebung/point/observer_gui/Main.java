package mvc_uebung.point.observer_gui;

public class Main {

	public static void main(String[] args){
		Model m = new Model(80,30);
		m.addObserver(new View1());
		//m.addObserver(new View2());		
		m.addObserver(new ViewFrame());
		Control c = new Control(m);
		c.letsGo();
	}
}
