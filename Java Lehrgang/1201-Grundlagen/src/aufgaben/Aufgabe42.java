package aufgaben;
public class Aufgabe42 {

	public static void main(String[] args) {
		System.out.println("   **** Volumen eines Zylinders ****");
		System.out.println("  Radius        Hoehe        Volumen");
		System.out.println("--------------------------------------");
		for (double r = 0.5; r <= 2.0; r += 0.5) {
			for (double h = 0.5; h <= 2.0; h += 0.5) {
				System.out.printf("   %.1f           %.1f           %9.6f\n", r, h, cylinderVolume(r, h));
			}
		}
	}

	public static double cylinderVolume(double r, double h) {
		return Math.PI * Math.pow(r, 2) * h;
	}
}