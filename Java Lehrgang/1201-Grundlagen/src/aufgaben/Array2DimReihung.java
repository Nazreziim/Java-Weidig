package aufgaben;

public class Array2DimReihung {

	public static void main(String[] args){
		// a)
		int [] v1 = { 1, 1, 1};
		System.out.println("v1: " + java.util.Arrays.toString(v1));
		System.out.println();
		
		// b)
		int [] [] v2_1 = { {1, 2, 3},
						   {4, 5, 6},
						   {7, 8, 9},
						   {10, 11, 12},
						   {13, 14, 15}};
		
		for ( int zeile = 0; zeile < v2_1.length; zeile++ ){						   	   
			System.out.println("v2_1: " + zeile + java.util.Arrays.toString(v2_1[zeile]));
		}
		System.out.println();
		
		// c)
		// Inhalte von v1 in das 2Dim. Array kopieren
		for ( int zeile = 0; zeile <  v2_1.length; zeile++ ){
			for ( int spalte = 0; spalte < v2_1[zeile].length; spalte++){
				v2_1[zeile] [spalte] = v1[spalte];
			}
		}
		
	    for ( int zeile = 0; zeile < v2_1.length; zeile++ ){						   	   
			System.out.println("v2_1: " + zeile + java.util.Arrays.toString(v2_1[zeile]));
		}
		
		System.out.println();
		
		// d)
		v2_1 = new int [] [] { {1, 2, 3},
				 			   {4, 5, 6},
				               {7, 8, 9},
				               {10, 11, 12},
				               {13, 14, 15}};
				               
				 
		int [] [] v2_2 = new int [v2_1.length] [v2_1[0].length];
		for ( int zeile = 0; zeile < v2_1.length; zeile++ ){
			for ( int spalte = 0; spalte < v2_1[zeile].length; spalte++ ){
				v2_2[zeile] [spalte] = v2_1[v2_1.length - zeile - 1] [v2_1[zeile].length - spalte - 1];
			}
		}
		
		for ( int zeile = 0; zeile < v2_2.length; zeile++ ){						   	   
			System.out.println("v2_2: " + zeile + java.util.Arrays.toString(v2_2[zeile]));
		}
	}

}