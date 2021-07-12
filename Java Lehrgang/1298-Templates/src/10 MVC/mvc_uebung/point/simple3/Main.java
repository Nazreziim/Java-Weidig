package mvc_uebung.point.simple3;
/**
 * Typ 3.2.3 S
 * @author Daniel
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Model m = new Model(10, 8);
		
		View v = new View(m); 
		
		Control c = new Control(m, v);
		
		c.letItStart();
	}

}
