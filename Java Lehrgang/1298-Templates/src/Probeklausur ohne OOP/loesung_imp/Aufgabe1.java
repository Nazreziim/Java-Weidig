package loesung_imp;

// Name:
// Dienstgrad:


public class Aufgabe1 {

	public static void main(String[] args) {
		// Stufe 1
		int[] a = { 3, 2, -1, 0, 17};
		int[] b = {-4, 3, -1, 6, -8};
		int[][] c = new int[2][5]; // {{3,3,-1,6,17},{1,-1,-1,-1,1}}
		methode1(a,b,c);
		
		System.out.println( c[0][1] ); // 3
		System.out.println( c[1][2] ); // -1
		//ausgabe(c);
		
		// Stufe 2
		int[][] d = new int[2][5];  // { {-4,3,-1,6,-8},{1,-1,-1,-1,1}}
		d[0] = b;
		d[1] = c[1];
		
		//ausgabe(d);
		
		boolean[] e = methode2(d);  // {true, true, false, false, true}
		
		System.out.println(e[e.length-1]);  // true
		
//		for (int i = 0; i < e.length; i++)
//		{
//			System.out.println(e[i]);
//		}
		
		if (!e[2]) {
			System.out.println("Falsch");  // Falsch
		} else {
			System.out.println("Richtig");
		}
		
		// Stufe 3

		
		b[2] *= -1;  // 1
		d[1][1] += 2;  // 1
		
//		System.out.println("Array d:");
//		for (int i=0; i < d.length; i++) {
//			for (int j = 0; j< d[i].length; j++) {
//				System.out.print(d[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("------");
//		
//		System.out.println("Array c:");
//		for (int i=0; i < c.length; i++) {
//			for (int j = 0; j< c[i].length; j++) {
//				System.out.print(c[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("------");
		
		
		System.out.println(d[0][2] += a[1]); // 3
		System.out.println(c[1][1] + b[2]);  // 4
		
		
	}
	
	private static void ausgabe(int[] reihe)
	{
		System.out.println("Ausgabe Reihe");
		
		for (int index = 0; index < reihe.length; index++)
		{
			System.out.print(reihe[index] + " ");
		}
		System.out.println();
	}
	
	private static void ausgabe(int[][] feld)
	{  
		System.out.println("Ausgabe 2.Dim Array");
		for (int zeile = 0; zeile < feld.length; zeile++)
		{
//			for (int spalte = 0; spalte < feld[zeile].length; spalte++)
//			{
//				System.out.print(feld[zeile][spalte] + " ");
//			}
//			System.out.println();
	
			ausgabe(feld[zeile]);
		}
		System.out.println();
	}


	private static void methode1(int[] x, int[] y, int[][] z) {
		for (int i=x.length-1; i >= 0; i--) {
			if (x[i] > y[i]) {
				z[0][i] = x[i];
				z[1][i] = 1;
			} else {
				z[0][i] = y[i];
				z[1][i] = -1;
			}
		}
		
	}
	
	private static boolean[] methode2(int[][] d) {
		boolean[] z = {false, true, false, false, false};
		for (int i = 0; i<d[1].length; i++) {
			System.out.println(i);		//  0 1 2 3 4			
			if (d[0][i] < d[1][i]) {
				z[i] = true;
			}
		}
		return z;  // {true, true, false, false, true}
	}


	
}


