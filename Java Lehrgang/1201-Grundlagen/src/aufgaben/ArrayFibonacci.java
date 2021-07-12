package aufgaben;

public class ArrayFibonacci {

	public static void main(String[] args) {

		int[] reiheFibo = null;
		
		if ( args.length == 1){
			
			reiheFibo = new int[Integer.parseInt(args[0])];
			
			
			for (int i = 0; i < reiheFibo.length; i++){
				reiheFibo[i] = 1;
			}
					
				
			for( int i = 2; i < reiheFibo.length; i++){
				reiheFibo[i] = reiheFibo[i -2] + reiheFibo[i - 1];
			}
			
				
			// Ausgabe der Reihung
			for ( int wert : reiheFibo){
				System.out.print(wert + " ");
			}
			System.out.println();
			
		}
		else{
			System.out.println("Fehler: Sie muessen die Laenge der Reihung als Zahl angeben!");
		}
	}

}
