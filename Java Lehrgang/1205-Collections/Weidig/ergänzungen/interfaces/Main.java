package erg�nzungen.interfaces;

public class Main {
	public static void main(String[] args) {
		// Funktioniert nicht, da von Interfaces keine Objekte erzeugt werden k�nnen
		// Interface hallo = new Interface();

		InterfaceImplementer halloUndTsch�ss = new InterfaceImplementer();

		halloUndTsch�ss.halloVomInterface();
		halloUndTsch�ss.tsch�ss();

		Interface berndsInterface = new InterfaceImplementer(); // HUCH! << funktioniert mit abstraken Klassen auch
		Interface bernd;
		bernd = new InterfaceImplementer();
		
		
		berndsInterface.halloVomInterface();
		
		// Funktioniert nicht, da ich im Interface keinen Zugriff auf die
		// Funktionalit�ten der Klassen habe welche dies implementieren, sondern nur auf
		// die Methoden des Interfaces
		
		// berndsInterface.tsch�ss();
		
		

	}

	// F�r Importaufgabe
	public void husten() {
		System.out.println("Husten");
	}
}
