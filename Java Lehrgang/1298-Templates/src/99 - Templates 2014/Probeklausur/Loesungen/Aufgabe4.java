//Name:
//Dienstgrad:

import java.util.Scanner;

public class Aufgabe4  {
	
	public static void main(String[] args) {
		Scanner eingabe = new Scanner(System.in);
		
		int a = eingabe.nextInt();
		int b = eingabe.nextInt();
		int c = eingabe.nextInt();
		int d =eingabe.nextInt();
		System.out.println("Der g.g.T. ihrer Eingaben ist: " + ggTXXL(a,b,c,d));
	}

	/**
	 * Groesster gemeinsamer Teiler von zwei Zahlen
	 * @param a
	 * @param b
	 * @return
	 */
	private static int ggT(int a, int b)
	{
		while ( a != b )
		{
			if ( a > b )
			{
				a = a - b;
			}
			else
			{
				b = b - a;
			}
		}
		return a;
	}
	
	/*
	Hier ist Ihre Methode "ggtXXL" zu ergänzen.
    */
	
	private static int ggTXXL(int a, int b, int c, int d) {
		int ergebnis = 0;
		
		ergebnis = ggT(a, b);
		ergebnis = ggT(ergebnis, c);
		ergebnis = ggT(ergebnis, d);
		
		return ergebnis;
	}
	


}
