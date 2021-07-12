package wrsv2017;

public class WettbueroTest {

	public static void main(String... strings) {

		Rennschnecke rs1 = new Rennschnecke("Alf", "Alpenschnecke", 1.3);
		Rennschnecke rs2 = new Rennschnecke("Bert", "Burgschnecke", 1.1);
		Rennschnecke rs3 = new Rennschnecke("Caesar", "Crownschnecke", 0.9);
		Rennschnecke rs4 = new Rennschnecke("Dumm", "Deltaschnecke", 1.4);
		Rennschnecke rs5 = new Rennschnecke("Egon", "Essschnecke", 0.5);

		Rennen r = new Rennen("Feldafing International", 5, 17.778);
		r.addRennschnecke(rs1);
		r.addRennschnecke(rs2);
		r.addRennschnecke(rs3);
		r.addRennschnecke(rs4);
		r.addRennschnecke(rs5);

		Wettbuero wb = new Wettbuero(r, 100, 2.5);

		wb.wetteAnnehmen("Alf", 10, "Default");
		wb.wetteAnnehmen("Egon", 100, "Dummy");
		wb.wetteAnnehmen("Caesar", 5, "Mutig");
		wb.wetteAnnehmen("Dumm", 50, "Kein Risiko");

		System.out.println(wb.toString());

		wb.rennenDurchfuehren();

		System.out.println(wb.toString());
	}

}
