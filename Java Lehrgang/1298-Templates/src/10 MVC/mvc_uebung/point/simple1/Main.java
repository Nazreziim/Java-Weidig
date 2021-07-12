package mvc_uebung.point.simple1;

/**
 * Typ 3.2.1S
 * @version 2012
 * @author LGerhard
 *
 */
public class Main {

	public static void main(String[] args){
		Model m = new Model(20,10);
		View v = new View(m);
		Control c = new Control(m,v);
		c.letsGo();
	}
}
