//package analyse;

/**
 * Analyseaufgabe für den 11.04.2013
 *
 * Was wird hier ausgegeben und vor allem warum?
 * 
 * 
 * @author LGerhard
 *
 */
public class Analyse31 {
	public static void main(String args[] ) {
		int[] arr1 = new int[4];
		arr1[0]=3;
		
		for (int i=1; i<arr1.length; i++) {
			arr1[i] = arr1[i-1] << 1;
			if (arr1[i] % 6 == 0) {
				arr1[i] = arr1[i]*-1;
			}
		}
		
		for (int i=0; i< arr1.length; i++) {
			System.out.println(arr1[i] + " ");
		}
		
	}
}
