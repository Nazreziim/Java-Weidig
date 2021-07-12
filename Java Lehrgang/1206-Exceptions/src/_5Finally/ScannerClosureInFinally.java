package _5Finally;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerClosureInFinally {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// z.B. ein String eingeben
			int i = sc.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Das war keine Ganzzahl.");
		} finally {
			// Hier wird der Scanner geschlossen.
			// Egal ob das Einlesen erfolgreich war oder nicht.
			// Ressourcen müssen freigegeben werden.
			System.out.println("Egal was passiert. Hier komme ich hin.");
			sc.close();
		}
	}

}
