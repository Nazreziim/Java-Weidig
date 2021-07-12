package aufgaben;

import java.util.Arrays;

public class Aufgabe38 {

	public static void main(String[] args) {
//		a)		
		int[] v1 = { 1, 1, 1 }; 
		int[][] v2_1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
		int[][] v2_2 = new int[5][3];

//		b)
		for (int i = 0; i < v2_1.length; i++) {
			System.out.print(Arrays.toString(v2_1[i]));
		}

//		c)
//		for (int i = 0; i < v2_1.length; i++) {
//		v2_1[i] = v1;
//		}

//		d)
		System.out.println();
		for (int i = 0, j = v2_2.length - 1; i < v2_1.length; i++, j--) {
			for (int k = 0, l = v2_1[i].length - 1; k < v2_1[i].length; k++, l--) {
				v2_2[j][l] = v2_1[i][k];
			}
		}

		for (int i = 0; i < v2_2.length; i++) {
			System.out.print(Arrays.toString(v2_2[i]));
		}
	}
}