package loesung_klausur_2014;

/**
*Name:
*DG:
*/

public class Aufgabe1 {
	
	public static void main(String[] args) {
		int[] a = {-3, 7, -5, 12, 0};
		int[][] b = new int[2][5];
		boolean[] c = methode(a);
		b[0] = a;
		for(int i = 0; i < a.length; i++) {
			if (c[i]) {
				b[1][i] = a[i];
			}
			else {
				b[1][i] = -a[i];
			}
		}
		System.out.println( b[0][1] );
		System.out.println( b[1][0] );
		System.out.println( c[2]);
		System.out.println( a[2] * b[1][2] );
		a[0] = 100;
		System.out.println( a == b[0] );
	}
	
	public static boolean[] methode(int[] x) {
		boolean[] y = new boolean[x.length];
		y[0] =  ( x[0] < 0 );
		for (int i = 1; i < x.length; i++) {
			y[i] =  y[i - 1] || ( x[i] > 0 );
		}
		return y;
	}
}



/**
*	Lösung:
* 	7
*	-3
* 	true
* 	25
* 	true
*/