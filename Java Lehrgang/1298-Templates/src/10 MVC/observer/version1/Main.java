/**
 * 
 */
package observer.version1;

/**
 * @author alandgraf
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();
		View view = new View(model);
		Control control = new Control(model,view);
		control.begin();
	}

}
