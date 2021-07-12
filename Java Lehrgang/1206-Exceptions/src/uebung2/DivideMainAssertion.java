package uebung2;

public class DivideMainAssertion {

	public static void main(String[] args) {
		int divident = 0;
		int divisor = 0;

		assert args.length == 2 : "Falsche Anzahl an Parametern!";

		try {
			divident = Integer.parseInt(args[0]);
			divisor = Integer.parseInt(args[1]);

			assert divisor != 0 : "Der Divisor darf nicht Null sein!";

			System.out.println(divident / divisor);
		} catch (NumberFormatException e) {
			System.err.println("Dieses Programm akzeptiert nur ganze Zahlen als Argumente.");
		}

	}

}
