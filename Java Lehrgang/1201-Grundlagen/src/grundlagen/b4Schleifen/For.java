package grundlagen.b4Schleifen;

class For {
	 public static void main(String[] args) {
	 	 // Zählschleife
	 	 for(byte i = 0; i < 10; i++) {
	 	 	 System.out.println("Wert ist "+i);
	 	 }
	 	 
	 	 int[] prim = {2, 3, 5, 7, 11, 13, 17};
	 	 for(int p : prim) {
	 	 	 System.out.println(p + " ist prim.");
	 	 }
	 	 // ganzes Array ausgeben
	 	 System.out.println(prim);

	 	 char[][] werte = { {'a', '#'}, {'b', '*'}, {'c', '?'} };
/* Durchlaufen mit einer Zählschleife 	 	 
	 	 int i = 0;
	 	 for (int j = 0; j < werte[i].length ; j++) {
	 	 	 for (; i < werte.length; i++) {
	 	 	 	 System.out.print(werte[i][j] + "\t");
	 	 	 }
	 	 	 System.out.println();
	 	 }
*/
		// Ausgabe der Arrays
		for(char[] c: werte) {
			System.out.println(c);
		}
		
		//Ausgabe der Werte
		for(char[] c: werte) {
			for(char zeichen : c) {
				System.out.print(zeichen + "\t");
			}
			System.out.println();
		}
	 	 
		
		for (int i = 1; i < 50; i++) {
			System.out.println(i);
			if((i%17) == 0) {
				continue;
			}
			System.out.println("Wirklich nicht durch 17: "+i);
		}
	}
}
