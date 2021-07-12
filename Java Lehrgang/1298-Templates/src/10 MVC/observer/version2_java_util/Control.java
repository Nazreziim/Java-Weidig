package observer.version2_java_util;

/**
 * Die Control-Klasse vermittelt gewöhnlich zwischen Model und View. Durch den Einsatz des Observer-Pattern muss hier allerdings
 * nur noch das Model "bedient" werden
 * @author LGerhard
 * @see Model
 *
 */
public class Control {
	private ModelInterface mdl;

	
	public Control(ModelInterface m) {
		this.mdl = m;	
	}
	
	public void letsGo() {
		for (int i=0; i<100; i++) {
			this.mdl.inkr();
			// Hier ist kein expliziter Aufruf mehr nötig - das Model informiert seine Observer direkt in der Methode inkr!   
			// this.v.show();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
