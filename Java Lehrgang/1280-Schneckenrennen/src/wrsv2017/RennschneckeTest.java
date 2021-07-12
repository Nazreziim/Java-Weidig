package wrsv2017;

public class RennschneckeTest {

	public static void main(String... strings) {
		Rennschnecke rs = new Rennschnecke("Max", "Weinbergschnecke", 5.55);
		System.out.println(rs);
		rs.krieche();
		System.out.println(rs);

		Rennen r = new Rennen("Monte Carlo", 4, 101.12);

		r.addRennschnecke(new Rennschnecke("Moritz", "Braun", 3.9));
		r.addRennschnecke(rs);
		r.addRennschnecke(new Rennschnecke("Chip", "Hornschnecke", 5.56));
		r.removeRennschnecke("Moritz");
		r.addRennschnecke(new Rennschnecke("Micha", "Alpen", 5.5));
		r.addRennschnecke(new Rennschnecke("Steffen", "Schimmel", 4.99));

		System.out.println(r);

		r.durchfuehren();
		System.out.println("Gewinner:\n" + r.ermittleGewinner());
	}
}
