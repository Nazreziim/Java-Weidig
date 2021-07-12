package schritt4UebungTriple;

public class TripleTest {

	public static void main(String[] args) {
			
		//Array mit verschiedenen Konstellationen erzeugen
		int[][] testDaten=new int[][] 
		{ 
			{1,2,3}, //ascending
			{3,2,1}, //descending
			{1,3,2}, //not ordered
			{1,1,1} //all values equal
			
		};
		
		//Testaufruf
		System.out.println("Anzahl Eintraege: " + testDaten.length);
		
		for(int i=0; i<testDaten.length; i++) {
					
			//Aufruf Ausgabe-Methode
			tripleOutput(testDaten[i][0], testDaten[i][1], testDaten[i][2]);
			
		}
		
		
		
	}
	
	private static void tripleOutput(Integer el1, Integer el2, Integer el3 ) {
		
		
		//Triple erzeugen
		Triple <Integer> triple =new Triple <Integer>();
		
		//Elemente füllen
		triple.setElem1(new Integer(el1));
		triple.setElem2(new Integer(el2));		
		triple.setElem3(new Integer(el3));
	
			
		
		//Methoden aufrufen
		System.out.println("--------------Eingabe: ---------");
		System.out.printf("%d  %d  %d\n", el1, el2, el3);
		
		System.out.println("isAscending: "+triple.isAscending());
		System.out.println("isDescending: "+triple.isDescending());
		System.out.println("isOrdered: "+triple.isOrdered());
		System.out.println("AllValuesEqual: "+triple.allValuesEqual());
		System.out.println("AllValuesDifferent: "+triple.allValuesDifferent());		
		System.out.println();
		
	}

}
