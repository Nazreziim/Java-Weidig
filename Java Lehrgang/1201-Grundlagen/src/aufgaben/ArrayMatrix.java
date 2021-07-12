package aufgaben;

public class ArrayMatrix{

	public static void main(String[] args){
		// 5 x 5 Matrix immer symetrisch
		int [] [] matrix = {{ 5,  2,  9, 32, 56},
							{ 6, 12, 10, 22,  3},
							{23,  5, 21,  6, 17},
							{ 3, 11, 64, 89, 25},
							{ 7, 57,  2,  1,  4} };
		int diagonale1 = 0;
		int diagonale2 = 0;
		
		// Summenberechnung
		for ( int n = 0; n < matrix.length; n++ ){
			diagonale1 = diagonale1 + matrix[n][n];
			diagonale2 = diagonale2 + matrix[matrix.length - n - 1] [n];
		}
		
		// Ausgabe
		if (diagonale1 < diagonale2){
			System.out.printf("Diagonale 1: %d ist kleiner als Diagonale 2: %d\n", diagonale1, diagonale2 );
		}
		else if (diagonale1 > diagonale2){
			System.out.printf("Diagonale 1: %d ist groesser als Diagonale 2: %d\n", diagonale1, diagonale2 );
		}
		else{
			System.out.printf("Die Diagonalen sind gleich gross: %d\n", diagonale1 );
		}
	}
}