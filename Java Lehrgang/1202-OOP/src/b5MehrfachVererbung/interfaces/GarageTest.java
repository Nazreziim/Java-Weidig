package b5MehrfachVererbung.interfaces;

public class GarageTest {

	public static void main(String... args) {

		Garage g1 = new Garage();
		Garage g2 = (Garage) g1.clone();
		Garage g3 = new Garage();
		System.out.println(g1.garagenNr);
		System.out.println(g2 != null ? g2.garagenNr : null);
		System.out.println(g3.garagenNr);
	}

}
