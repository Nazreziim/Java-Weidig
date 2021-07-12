package arrays;

public class Template_Arrays {
public static void main(String[] args) {
	// 1.) Deklaration einer Array-Variablen - mit Initialisierung
	int[] temps = { 10, 12 , 13, 14, 15, 14, 16, 17, 22, 21, 23 };
	
	// 2.) Deklaration ohne Initialisierung - aber trotzdem mit Angabe der Größe
	int[] temperaturen = new int[5];
	temperaturen[0] = 10;
	temperaturen[1] = 12;
	temperaturen[2] = 13;
	temperaturen[temperaturen.length - 1] = 99;   // Befüllen des letzten Wertes des Arrays
	
	// 3.) Array mit einer Schleife befüllen
	// Die Nummerierung eines Arrays beginnt bei 0 !!!
	for (int i = 0; i < temperaturen.length ; i++) {
		temperaturen[i] = (int)(Math.random() * 10.0) + 20; // HilfsMeth.readInt();
	}
	// Bitte nicht mit einer for-each Schleife befüllen - das führt zu unkontrollierbaren Ergebnissen
	
	
	// System.out.println(temperaturen);  // So wird nur die Adresse ausgegeben
	
	// 4.) Array mit einer Schleife auslesen
	for (int i = 0; i < 5; i++) {
		System.out.print(temperaturen[i]);
	}
	System.out.println();
	
	// temps.length liefert die Anzahl der Elemente im Array
	// Das ist aber nicht der Index des letzten Elements
	for (int i = 0; i < temps.length ; i++) {
			System.out.print(temps[i] + ", ");
	}
	
	System.out.println("Im Array sind " + temps.length + " Elemente");
	
	
	// 5.) Array mit einer for-each Schleife auslesen
	for (int t : temperaturen) {
		System.out.print(t + ", ");
	}
	System.out.println();
	
	// 6.) Character-Arrays
	char[] mein_name = {'L', 'a','r' ,'s'};
	System.out.println(mein_name);  // Das geht jetzt auf einmal
	String nachname = "Gerhard";
	
	for (char c : nachname.toCharArray()) {
		System.out.print(c + ", ");
	}
	
	for(char c : mein_name) {
		System.out.print(c + ", ");
	}
	
	// Alle Großbuchstaben in Kleinbuchstaben umwandeln und umgekehrt
	char[] pwd = {'P','a','S','$','W','0','R','t'};
	char[] umgewandelt = umwandeln(pwd, false);
	System.out.println(umgewandelt);
	
	
	// 7.) Mehrdimensionale Arrays
	int[][] matrix_1 = { {1,2,3,0},{0,4,5,6},{0,7,8,9} };  //das ist ein int[3][4]  
	int[][] matrix_2 = new int[5][5];
	int[] eine_zeile = { 2 , 2 }; 
	matrix_1[1] = eine_zeile;
	
	
	// 7.1.) Ausgabe:
	
	for (int i = 0; i < matrix_1.length ; i++) {  // Zeilen
		for(int j = 0 ; j < matrix_1[i].length ; j++) {  // Spalten
			System.out.print(matrix_1[i][j] + " ");
		}
		System.out.println(); 
	}
	
	/*
	for (int j = 0; j < 4 ; j++) {  // Spalten
		for(int i = 0 ; i < 3; i++) {  // Zeilen
			System.out.print(matrix_1[i][j] + " ");
		}
		System.out.println(); 
	}*/
	
	// 7.2) Ein Schachbrett
	boolean[][] schachbrett = new boolean[8][8];
	
	// Schachbrett passend belegen: true = schwarz, false = weiß
	for(int z = 0; z < schachbrett.length; z++) { // Zeilen = z
		for (int s = 0; s < schachbrett[z].length; s++) { // Spalten = s
			if ((z + s) % 2 != 0) { // z+s ist eine ungerade Zahl!
				schachbrett[z][s] = true;	
			}
		}
	}
	
	
	// Ausgabe
	for(int z = 0; z < schachbrett.length; z++) {
		for (int s = 0; s < schachbrett[z].length; s++) {
			if (schachbrett[z][s] == true) {
				System.out.print("S ");
			} else {
				System.out.print("W ");
			}			
		}
		System.out.println();
	}

}

/*
Diese Methode wandelt Groß- in Kleinbuchstaben um, oder umgekehrt.
In welche Richtung die Umwandlung geschieht, hängt vom Parameter in_klein ab.
Das Ergebnis der Umwandlung wird zurückgegeben.
*/
public static char[] umwandeln(char[] buchstaben, boolean in_klein) {
	int diff = Math.abs('A' - 'a');
	
	for (int i = 0; i < buchstaben.length; i++) {
		if (in_klein) {
			// Groß in Kleinbuchstaben
			if ((buchstaben[i] >= 'A') && (buchstaben[i] <= 'Z')) {
				buchstaben[i] = (char)(buchstaben[i] + diff);
			}
		} else {
			// klein in Großbuchstaben
			if ((buchstaben[i] >= 'a') && (buchstaben[i] <= 'z')) {
				buchstaben[i] = (char)(buchstaben[i] - diff);
			}
		}
	}
	return buchstaben;
}


}
