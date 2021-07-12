package ausgabe;

//Name:
//Dienstgrad:


public class Aufgabe1 {

	public static void main(String[] args) {
		// Stufe 1
		int[] a = { 3, 2, -1, 0, 17};
		int[] b = {-4, 3, -1, 6, -8};
		int[][] c = new int[2][5];
		methode1(a,b,c);
		
		System.out.println( c[0][1] );
		System.out.println( c[1][2] );
		
		// Stufe 2
		int[][] d = new int[2][5];
		d[0] = b;
		d[1] = c[1];
		
		boolean[] e = methode2(d);
		
		System.out.println(e[e.length-1]);
		
		if (!e[2]) {
			System.out.println("Falsch");
		} else {
			System.out.println("Richtig");
		}
		
		// Stufe 3
		b[2] *= -1;
		d[1][1] += 2;
		
		System.out.println(d[0][2] += a[1]);
		System.out.println(c[1][1] + b[2]);
		
		
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
			System.out.println(i);
			if (d[0][i] < d[1][i]) {
				z[i] = true;
			}
		}
		return z;
	}


	
}


