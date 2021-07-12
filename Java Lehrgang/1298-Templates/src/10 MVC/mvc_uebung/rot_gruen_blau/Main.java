package mvc_uebung.rot_gruen_blau;

/**
 * @version 2009
 * @author LGerhard
 *
 */
public class Main {

	public static void main(String[] args){
		Model m = new Model();
		View v = new View(m);
		
		Control c = new Control(m);
		c.letsGo();
	}
}
