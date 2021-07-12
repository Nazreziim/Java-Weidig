package aufgaben.punkt2d;

public class Punkt2D {
	/*
	 * Koordinaten
	 */
	public int x, y;

	public Punkt2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object obj) {
		boolean erg = false;
		if (obj instanceof Punkt2D) {
			Punkt2D other = (Punkt2D) obj;
			erg = (other.x == x) && (other.y == y);
		}
		return erg;
	}

	public static void main(String[] args) {
		Punkt2D p1 = new Punkt2D(2, 2);
		Punkt2D p2 = new Punkt2D(3, 2);
		System.out.println(p1.equals(p2));
	}
}
