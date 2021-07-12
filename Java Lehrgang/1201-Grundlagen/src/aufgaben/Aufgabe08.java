package aufgaben;

public class Aufgabe08 {
	public static void main(String[] args) {

		System.out.println("a)");
		System.out.println("a.    7 = " + Integer.toBinaryString(7));
		System.out.println("b.   20 = " + Integer.toBinaryString(20));
		System.out.println("c.   51 = " + Integer.toBinaryString(51));
		System.out.println("d.  121 = " + Integer.toBinaryString(121));
		System.out.println("e.  514 = " + Integer.toBinaryString(514));
		System.out.println("f. 1023 = " + Integer.toBinaryString(1023));

		System.out.println("b)");
		System.out.println("a. 0010 1110 = " + 0b0010_1110);
		System.out.println("b. 1010 0101 = " + 0b1010_0101);
		System.out.println("c. 1001 1010 = " + 0b1001_1010);
		System.out.println("d. 1100 1101 = " + 0b1100_1101);

		// ODER

		System.out.println("b)");
		System.out.println("a. 0010 1110 = " + Integer.parseInt("00101110", 2));
		System.out.println("b. 1010 0101 = " + Integer.parseInt("10100101", 2));
		System.out.println("c. 1001 1010 = " + Integer.parseInt("10011010", 2));
		System.out.println("d. 1100 1101 = " + Integer.parseInt("11001101", 2));

		System.out.println("c)");
		System.out.println("a. 39 = " + 0x39);
		System.out.println("b. 1A = " + 0x1A);
		System.out.println("c. CA = " + 0xCA);
		System.out.println("d. FE = " + 0xFE);

	}
}
