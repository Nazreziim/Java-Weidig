package templates;
public class Datentypen {
	
	//Lösungen zu Aufgabe 3 der Übungen
	
	public static void main(String[] args) {
		int a = 45;
		double b = 5.3;
		float c = 9.2e5F;
		long d = 7L;
	//Fehler 1:	boolean e = True;  --> Boolsche Werte werden klein geschrieben
		boolean e = true;
		char f = 'a';
	/*Fehler 2:	int g = 083; --> 083 
	(0 ist Identifier für eine Oktalzahl und das Oktalsystem kennt keine 8)*/
		int g = 83;
		double h = 5.0F;
		int i = 1386;
		long j = 0x45L;
		char k = '\'';
		float l = 0x4305F;
		float m = 0x4305FF;
		int n = 0371;
		long o = 0x4305FFL;
		boolean p = false;
		
		System.out.println(a + "\n" + b  + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h + "\n" + i + "\n" + j + "\n" + k + "\n" + l + "\n" + m + "\n" + n + "\n" + o + "\n" + p);
		
	}
}
