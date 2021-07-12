package aufgaben;
public class Aufgabe39 {

	public static void main(String[] args) {
		int diagOne = 0;
		int diagTwo = 0;
		int[][] arr = { { 5, 6, 23, 3, 7 }, { 2, 12, 5, 11, 57 }, { 9, 10, 21, 64, 2 }, { 32, 22, 6, 89, 1 },
				{ 56, 3, 17, 25, 4 } };

		for (int i = 0; i < arr.length; i++) {
			diagOne += arr[i][i];
			diagTwo += arr[i][arr.length - 1 - i];
		}
		System.out.printf("Die kleinere Summe hat: %s mit insgesamt %d",
				diagOne < diagTwo ? "Diagonale 1!" : "Diagonale 2!", diagOne < diagTwo ? diagOne : diagTwo);
	}
}