package grundlagen.b5Arrays;

class Array {
	public static void main(String[] args) {
		int z = HilfsMeth.readInt("L�nge: ");
		int[] j;
		j = new int[z];
		j[z - 1] = 4;
		System.out.println(j[z - 1]);
	}
}
