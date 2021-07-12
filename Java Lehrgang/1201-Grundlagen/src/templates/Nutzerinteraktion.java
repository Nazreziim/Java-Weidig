package templates;
import java.util.Scanner;
// !!!!!!! SCANNER M�SSEN IMPORTIERT WERDEN !!!!!!!!!!

public class Nutzerinteraktion {
	public static void main(String[] args) {
		//Scanner werden unter anderem f�r Nutzereingaben genutzt
		
		//Erzeugen des Scanners
		Scanner nutzerinteraktion = new Scanner(System.in);
		//Nutzereingabe UND Speichern der Eingabe in Variable
		String eingabeText = nutzerinteraktion.next();
		//Ausgabe des eingegebenen Strings
		System.out.println("Ausgabe = " + eingabeText);
		
		
		//Mit anderen Datentypen ebenfalls m�glich
		//ACHTUNG: F�r einen anderen Datentyp gibt es eine
		//andere Bezeichnung (z.B. .nextInt() --> Integer)
		//Sollte man etwas nicht derartiges eingeben kommt
		//es zu einer Fehlermeldung
		Scanner sc = new Scanner(System.in);
		int zahl = sc.nextInt();
		System.out.println(zahl);
		
		//Scanner k�nnen ebenfalls f�r mehrere Eingaben genutzt werden
		Scanner mehrfachNutzbarerScanner = new Scanner(System.in);
		int ersteZahl = mehrfachNutzbarerScanner.nextInt();
		int zweiteZahl = mehrfachNutzbarerScanner.nextInt();
		String ersterString = mehrfachNutzbarerScanner.next();
		
		//Scanner k�nnen geschlossen aber DANACH nicht mehr genutzt werden
		//              mehrfachNutzbarerScanner.close();
		//Dies w�rde nicht funktionieren und zu einem Fehler f�hren,
		//wenn der Scanner geschlossen w�rde
		String zweiterString = mehrfachNutzbarerScanner.next();
		
		
		System.out.println(ersteZahl);
		System.out.println(zweiteZahl);
		System.out.println(ersterString);
		System.out.println(zweiterString);
		
	}
}
