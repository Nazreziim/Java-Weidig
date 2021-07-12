package aufgaben;

import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe34 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		int[] arr = { 40, 40, 40, 40, 40, 40, 40 };
		int day;
		int seats;

		do {
			System.out.println("\nBitte wählen Sie: ");
			System.out.println(" B = Buchen\n S = Storno\n N = Neu\n E = Ende");
			input = sc.next().toUpperCase();

			switch (input.charAt(0)) {
			case 'B':
				System.out.println("\nBitte wählen Sie den Tag: ");
				System.out.println(
						"1: Montag, 2: Dienstag, 3: Mittwoch, 4: Donnerstag, 5: Freitag, 6: Samstag, 7: Sonntag");
				day = sc.nextInt() - 1;

				System.out.println("Bitte geben Sie die Anzahl der Sitzplätze ein: ");
				seats = sc.nextInt();

				if (arr[day] >= seats) {
					arr[day] -= seats;
				} else {
					System.out.printf("Es sind nur noch %d Plätze an diesem Tag verfügbar.", arr[day]);
				}

				break;

			case 'S':
				System.out.println("\nBitte wählen Sie den Tag: ");
				System.out.println(
						"1: Montag, 2: Dienstag, 3: Mittwoch, 4: Donenrstag, 5: Freitag, 6: Samstag, 7: Sonntag");
				day = sc.nextInt() - 1;

				System.out.println("Wieviel Plätze wollen Sie zurückgeben?");
				seats = sc.nextInt();

				if (40 - arr[day] < seats) {
					System.out.printf("Es wurden nur %d Plätze an diesem Tag gebucht.", 40 - arr[day]);
				} else {
					arr[day] += seats;
				}

				break;
			case 'N':
				System.out.println("\nBitte wählen Sie den Tag: ");
				System.out.println(
						"1: Montag, 2: Dienstag, 3: Mittwoch, 4: Donnerstag, 5: Freitag, 6: Samstag, 7: Sonntag");
				day = sc.nextInt() - 1;

				arr[day] = 40;

				break;
			case 'E':
				System.out.println("Auf Wiedersehen! ");
				break;
			default:
				System.out.println("Falsche Eingabe !");
				break;
			}
		} while (input.charAt(0) != 'E');
		System.out.println(Arrays.toString(arr));
	}
}
