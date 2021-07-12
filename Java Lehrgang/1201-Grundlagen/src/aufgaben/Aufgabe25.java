package aufgaben;

import java.util.Scanner;

public class Aufgabe25 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welche aufgabe (a-f)?:");
		String aufgabe = scanner.next();

		switch (aufgabe) {
		case "a":
			for (int i = 1; i < 100; i++, System.out.println(i)) {
			}
			break;

		case "b":
			for (int i = 1; i < 20; i = i + i * i, System.out.println(i)) {
			}
			break;

		case "c":
			for (int i = 1; i < 50 && i % 2 == 0; i = i + 1 / i, System.out.println(i)) {
			}
			break;

		case "d":
			for (double n = scanner.nextInt(); 1 <= n; n = n + Math.sqrt(n), System.out.println(n)) {
			}
			break;

		case "e":
			for (double i = scanner.nextInt(); i <= scanner.nextInt(); i++, System.out.println(i)) {
			}
			break;

		case "f":
			for (int n = scanner.nextInt(); n > 1 && n % n == 0 && n / 1 == 0; System.out.println(n), n++) {
			}
			break;
		}
		scanner.close();
	}

}
