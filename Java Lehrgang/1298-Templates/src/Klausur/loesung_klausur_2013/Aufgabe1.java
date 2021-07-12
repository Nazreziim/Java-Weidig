package loesung_klausur_2013;
// Name:
// Dienstgrad:
public class Aufgabe1 {



	public static void main(String[] args) {
		int[] a_reihe = new int[5];
		int[] b_reihe = {2, -4, 6, 9, -10};
		int z = 0;
		
		// 1. Stufe
		for (int i = 1; i < 33; ++i) {
			if ((i % 2 == 0) && (i % 3 == 0)) {
				a_reihe[z] = i + 1;
				z++;				
			}
		}
		
		System.out.println(a_reihe[1] == 11);
		System.out.println(a_reihe[z-2]);
		System.out.println("------------");
		
		// 2. Stufe
		char[] char_reihe = new String("Riesenspass").toCharArray();
		String wort = "Riesenspass";
		
		System.out.println(char_reihe[2] == char_reihe[4]);		
		System.out.println("Riesenspass".equals(wort));
		System.out.println(char_reihe == wort.toCharArray());
		System.out.println(char_reihe.equals(wort.toCharArray()) );
		System.out.println((aendere(wort)));
		System.out.println("------------");
		
		// 3. Stufe
		boolean[] c_reihe = tu_was(b_reihe);
		for (boolean el : c_reihe) {
			System.out.print(el + ", ");
		}
		

	}

	private static char[] aendere(String wort) {
		for (char c : wort.toCharArray()) {
			c++;			
		}
		return wort.toCharArray();
	}

	
	private static boolean[] tu_was(int[] arr) {
		boolean[] erg = new boolean[arr.length];
		int z = arr.length;
		for (int el : arr) {
			
			int index = 0;
			if ((arr.length - (z - 1)) < arr.length) {
				index = arr.length - --z;
			} else {
				z--;
			}

			erg[z] = (el - arr[index]) > 0;
		}
		return erg;
	}

}
