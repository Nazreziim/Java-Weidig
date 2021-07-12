class Unterprogramme {
	

	public static void main(String[]args) {
		ausgabeUeberschrift();
		
		int[][] zahlenArray = {{1,5,6},{7,8,12,13,15,14,11}};
		//zahlenArray = new int[10];
		
		/*for (int i = 0; i < 10; i++) {
			zahlenArray[i] = eingabeDaten(i + 1);
		}*/
		
		ausgabeDaten(zahlenArray);
		
		/*
		int zahl1 = eingabeDaten(1);
		int zahl2 = eingabeDaten(2);
		
		ausgabeDaten(gebeGroessere(zahl1, zahl2));*/
	}
	
	public static void ausgabeUeberschrift() {
		System.out.println("### JAVA-Lehrgang ###");
	}
	
	public static int eingabeDaten(int i) {
		
		System.out.println(i + ". Zahl eingeben:");
		int daten = new java.util.Scanner(System.in).nextInt();
		
		return daten;
	}
	
	public static void ausgabeDaten (int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Hier sind wir im Array " + i);
			for (int j = 0; j < array[i].length; j++) {
				System.out.println("Hier ist der Wert " + array[i][j] + " aus dem Array im Array " + i);
			}
		}
	}
	
	public static int gebeGroessere (int[] array) {
		int groesster = array[0];
		
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] > groesster) {
				groesster = array[i];	
			}
		}
		
		return groesster;
	}
}
