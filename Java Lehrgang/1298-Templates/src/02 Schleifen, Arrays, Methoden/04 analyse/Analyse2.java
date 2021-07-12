package analyse;

class Analyse2 {
	public static void main(String[]args) {
		int[][] A3x1 = { {1,2}, {2,3}, {3,4} };
		for (int[] a3 : A3x1)
			System.out.println(a3);
				
		int[][] A3x2 = new int[][]{ {1,2}, {2,3}, {3,4} };
		System.out.println(A3x2[0][1]);
		
		int[][] A3x3 = new int[][]{ new int[]{1,2}, new int[]{2,3}, new int[]{3,4} };
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(A3x3[i][j] + " ");
			}
			System.out.println();
		}
	}
}
