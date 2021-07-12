package geo;

import sichtbarkeiten.Punkt;

public class PunktTest {

	public static void main(String[] args) {

		Punkt p = new Punkt(3, 4);
		Punkt p2 = new Punkt();
		
		
		Punkt.d = 4;

		System.out.println("x = " + p.getX());
		System.out.println("y = " + p.getY());

		System.out.println(p2);

	}

}
