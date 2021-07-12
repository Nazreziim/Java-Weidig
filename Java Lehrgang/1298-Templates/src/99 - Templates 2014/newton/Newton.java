public class Newton {
	public static void main(String[] args) {
		double start = 1.0;
		double zahl = Integer.parseInt(args[0]);
		
		System.out.println(wurzel(zahl, start));
	}
	
	public static double wurzel(double zahl, double vorgaenger) {
		if (zahl == 1.0)
			return 1.0;
		
		double erg = 0.5 * (vorgaenger + zahl / vorgaenger);
		if (Math.abs(erg - vorgaenger) <= 0.0000000001)
			return erg;
		else
			return wurzel(zahl, erg);
	}
}
