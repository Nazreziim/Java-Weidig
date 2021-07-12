public class Vergleich {
	public static void main(String[] args) {
		int[] array1 = {1,2,3,5,6};
		int[] array2 = {1,2,3,5};
		
		System.out.println(vergleich(array1, array2));
	}
	
	public static Boolean vergleich(int[] array1, int[] array2) {
		if (array1.length != array2.length)
			return false;
		else {
			int i = 0;
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] != array2[i])
					return false;
			}
		}
		
		return true;
	}
}
