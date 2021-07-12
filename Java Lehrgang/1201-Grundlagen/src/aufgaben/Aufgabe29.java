package aufgaben;

import java.util.Scanner;

public class Aufgabe29 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Zahl:");
		int zahl = sc.nextInt();
		boolean prime = 1 < zahl;
		for (int i = 2; prime && i * i <= zahl; ++i) {
			if (zahl % i == 0) {
				prime = false;
			}
		}
		if (prime) {
			System.out.println(zahl + " ist eine Primzahl!");
		} else {
			System.out.println(zahl + " ist keine Primzahl.");
		}
		sc.close();
	}
}
