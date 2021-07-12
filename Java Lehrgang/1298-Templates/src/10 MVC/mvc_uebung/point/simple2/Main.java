package mvc_uebung.point.simple2;


/**
 * Typ 3.2.2
 * @author Daniel
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model m = new Model(10, 8);
		// Henne - Ei Problem
		View v = new View(m); 
		m.setView(v);
		
		Control c = new Control(m, v);
		
		c.letItStart();
	}

}
