package ergänzungen.interfaces;

public class Main {
	public static void main(String[] args) {
		// Funktioniert nicht, da von Interfaces keine Objekte erzeugt werden können
		// Interface hallo = new Interface();

		InterfaceImplementer halloUndTschüss = new InterfaceImplementer();

		halloUndTschüss.halloVomInterface();
		halloUndTschüss.tschüss();

		Interface berndsInterface = new InterfaceImplementer(); // HUCH! << funktioniert mit abstraken Klassen auch
		Interface bernd;
		bernd = new InterfaceImplementer();
		
		
		berndsInterface.halloVomInterface();
		
		// Funktioniert nicht, da ich im Interface keinen Zugriff auf die
		// Funktionalitäten der Klassen habe welche dies implementieren, sondern nur auf
		// die Methoden des Interfaces
		
		// berndsInterface.tschüss();
		
		

	}

	// Für Importaufgabe
	public void husten() {
		System.out.println("Husten");
	}
}
