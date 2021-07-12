class Analyse3 {
	public static void main(String[]args) {
		int[] prim = {2, 3, 5, 7, 11, 13, 17, 19, 23};
		int[] zahlen = prim;
		for(int i = 0; i < zahlen.length; i++) {
			zahlen[i] = 5;
		}
		for(int i = 0; i < prim.length; i++) {
			System.out.println(prim[i]);
		}
	}
}
