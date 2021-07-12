import java.util.Scanner;

public class Template_07_Methoden
{
	// static int zahl = 0; // ACHTUNG: Verwendung von globalen Variablen zwingend vermeiden --> Seiteneffekte
	
	public static void main(String[] args)
	{
		ausgabe();
		ausgabePlusZehn(32);
		
		// direkte Verwendung der Funktionsrückgabe
		System.out.println(addition(5, 6));
		
		// Zuweisung der Funkttionsrückgabe
		int zahl = addition(5, 6);
		manipulation();
		System.out.println(zahl);
		
		// Aufruf der gleichen Methode unter verschiedenen Bedingungen
		System.out.println("Pauschal mit 10 addiert: " + addition(32));
		System.out.println("Addition mit zwei Werten " + addition(12, 11));
		
		
		// Werte für Addition einlesen
		int zahl1 = wertEinlesen();
		int zahl2 = wertEinlesen();
		char op = operatorEinlesen();
		System.out.println(zahl1 + " " + op + " " + zahl2 + " = " + berechnen(op,zahl1, zahl2));
	}
	
	public static int berechnen(char operator, int a, int b)
	{
		int erg = 0;
		
		switch(operator)
		{
		case '+':
			erg = a + b;
			break;
		case '-':
			erg = a - b;
			break;
		case '/':
			erg = a / b;
			break;
		case '*':
			erg = a * b;
			break;
		case '%':
			erg = a % b;
			break;
		}
		
		return erg;
	}
	
	public static int wertEinlesen()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Operand eingeben: ");
		int zahl = sc.nextInt();
		
		return zahl;
	}
	
	public static char operatorEinlesen()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Operator eingeben: ");
		char op = sc.next().charAt(0);
		
		return op;
	}
	
	//Methodendefinition
	public static void ausgabe()
	{
		System.out.println("Hier wird etwas ausgegeben!");	
	}
	
	public static void ausgabePlusZehn(int a)
	{
		System.out.println("Ausgabe: " + (a + 10));	
	}
	
	public static void manipulation()
	{
		int zahl = 42;
	}
	
	// Funktion (also mit Rückgabe)
	public static int addition(int a, int b)
	{
		// 1. Rückgabevariable definieren
		int erg = 0;
		
		// 2. Werte der Rückgabevariable durch Algorithmus zuweisen
		erg = a + b;
		
		// 3. Rückgabevariable zurückgeben
		return erg;
	}
	
	// Überladung von Methoden NUR anhand der unterschiedlichen Parameterliste (nicht durch Rückgabetyp
	public static int addition(int a)
	{
		/*
		int erg = 0;
		
		erg = a + 10;
		
		return erg;
		*/
		
		return addition(a, 10);
	}
}