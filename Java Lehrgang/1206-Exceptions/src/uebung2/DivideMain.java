package uebung2;

public class DivideMain {

	public static void main(String[] args) {
		int divident = 0;
		int divisor = 0;
		if (args.length != 2) {
			throw new IllegalArgumentException("Genau 2 Argumente sind notwendig.");
		}
		try {
			divident = Integer.parseInt(args[0]);
			divisor = Integer.parseInt(args[1]);
			if (divisor == 0) {
				throw new IllegalArgumentException("Das zweite Argument darf nicht 0 sein.");
			}
			System.out.println(divident / divisor);
		} catch (NumberFormatException e) {
			System.err.println("Dieses Programm akzeptiert nur ganze Zahlen als Argumente.");
		}

	}
}
