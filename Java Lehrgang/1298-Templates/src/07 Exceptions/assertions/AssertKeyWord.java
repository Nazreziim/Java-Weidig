package assertions;
// Anleitung zum Aktivieren von Assertions
// openbook.galileocomputing.de/javainsel9/javainsel_06_006.htm
public class AssertKeyWord {

	public static double subAndSqrt(double a, double b) {
		double diff = a-b;
		double result = Math.sqrt(diff);
		assert !Double.isNaN(result) : "Berechnungsergebnis ist NaN!";
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Sqrt(10-2)=" + subAndSqrt(10, 2));
		System.out.println("Sqrt(2-10)=" + subAndSqrt(2, 10));
	}
}