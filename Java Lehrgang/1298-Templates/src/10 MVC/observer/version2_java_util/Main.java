package observer.version2_java_util;

/**
 * Hauptklasse zum Start der Applikation
 * @author LGerhard
 *
 */
public class Main {

	public static void main(String[] args) {
		Model m = new Model();
		// Hier werden dem Model (= Observable) nun seine Beobachter bekannt (=Observer = Views) gemacht
		m.addObserver(new AndereView());  // Das kann nur hier erledigt werden - Alternative: Model als Parameter für 
										  // Konstruktor der View, und dann dort der Aufruf von m.addObserver(this)
		m.addObserver(new View());
		Control c = new Control(m);
		c.letsGo();

	}

}
