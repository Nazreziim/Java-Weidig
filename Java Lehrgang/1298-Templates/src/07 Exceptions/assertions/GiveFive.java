package assertions;

public class GiveFive {

	public static String g5(int i) {
		String erg = "";
		// nicht vergessen, in Eclipse f�r run "-ea" zu setzen"
		assert i == 5 : "Zahl muss f�nf sein!";
		if (i == 5)
			erg = "Das waren 5";
		else
			erg = "Das war keine 5";
		return erg;
	}

	public static void main(String[] args) {
		System.out.println(GiveFive.g5(4));
	}
}
