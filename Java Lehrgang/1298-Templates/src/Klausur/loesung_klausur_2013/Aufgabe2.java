package loesung_klausur_2013;
// Name:
// Dienstgrad:
public class Aufgabe2 {
	public static void main(String[] args) {
		int[][] pascal_dreieck = new int [5][5];
		pascal_dreieck = fuelle_matrix(pascal_dreieck.length);
		printArray2D(pascal_dreieck);
		System.out.println(pascal(1,0));
	}

	private static int[][] fuelle_matrix(int length) {
		int[][] erg = new int[length][length];
		for (int z = 0; z <= length-1; z++) {
			for (int s = 0; s <= length-1; s++) {
				erg[z][s] = pascal(z,s);
			}
		}
		return erg;
	}

	private static int pascal(int z, int s) {
		int erg = 0;
		if (s == 0 || s == z) {
			erg = 1;
		} else if ( s > z) {
			erg = 0;
		} else {
			erg = pascal(z-1, s) + pascal(z-1, s-1);
		}
		return erg;
	}
	

	private static void printArray2D(int[][] arr) {
		for (int[] i : arr) {
			for (int j : i) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}
		
		
	}
}
