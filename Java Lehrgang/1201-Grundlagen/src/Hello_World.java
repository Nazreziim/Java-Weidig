public class Hello_World {

	public static void main(String[] args) {
		int[][] arrEins = { { 1, 2, 3 }, 
							{ 1, 2, 3 }, 
							{ 1, 2, 3 } };
			
		double[][] arrZwei = new double[3][4];

		System.out.println();

		for (int zeile = 0; zeile < arrZwei.length; zeile++) {
			for (int spalte = 0; spalte < arrZwei[zeile].length; spalte++) {
				arrZwei[zeile][spalte] = 40.0;
			}
		}
		
		for(double[] arr : arrZwei) {
			for(double inhalt : arr) {
				System.out.println(inhalt);
				System.out.println("nächstes Feld");
			}
			System.out.println("Nächste Zeile");
		}

	}

}
