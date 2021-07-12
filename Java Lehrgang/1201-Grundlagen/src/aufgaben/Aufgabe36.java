package aufgaben;

import java.util.Arrays;
import java.util.Scanner;

public class Aufgabe36 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int search;
		int low = 0;
		int high;
		int mid;
		int res = 0;
		boolean found = false;
		int[] arr;

		System.out.println("Wie groß soll das Array sein?");
		arr = new int[sc.nextInt()];
		arr = Arrays.stream(arr).map(i -> (int) (Math.random() * 100)).toArray();
		Arrays.sort(arr);
		high = arr.length - 1;

		System.out.println("Das Array sieht wie folgt aus:\n" + Arrays.toString(arr));

		System.out.println("Nach welcher Zahl soll gesucht werden?");
		search = sc.nextInt();

		while (low <= high && !found) {
			mid = (low + high) / 2;
			if (arr[mid] < search) {
				low = mid + 1;
			} else if (arr[mid] > search) {
				high = mid - 1;
			} else if (arr[mid] == search) {
				res = mid;
				found = true;
			}
		}
		if (found == true) {
			System.out.println("Die gesuchte Zahl befindet sich auf dem Index " + res);
		} else {
			System.out.println("Wert nicht gefunden");
		}

		System.out
				.println("Eine kürzere Möglichkeit ist 'Arrays.binarySearch(arr, search);'. Das ergebnis lautet hier: "
						+ Arrays.binarySearch(arr, search));
	}
}
