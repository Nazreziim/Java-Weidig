package alt.aufgaben.zeichnen.clipping.point_gui;

public class Main {

	public static void main(String[] args){
		Model m = new Model(30,70);
		//m.addObserver(new View1());
		//m.addObserver(new View2());		
		m.addObserver(new ViewFrame());
		Control c = new Control(m);
		c.letsGo();
	}
}
