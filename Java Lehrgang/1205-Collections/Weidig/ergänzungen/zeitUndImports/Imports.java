package ergänzungen.zeitUndImports;

import ergänzungen.interfaces.Main;

public class Imports {
	public static void main(String[] args) {
		//TEUFELSZEUG 
		//(funktioniert nur weil ich mich in einer statischen 
		//Methode befinde "static context")
		Main.main(null);
		
		//Kann ich nicht nutzen 
		//Main.husten();
		
		//Aber ich kann eben alles nutzen solange es sichtbar ist
		Main einMainObjekt = new Main();
		einMainObjekt.husten();
	}
}
