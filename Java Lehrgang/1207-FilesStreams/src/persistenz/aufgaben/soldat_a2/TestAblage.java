package persistenz.aufgaben.soldat_a2;

import java.io.File;
import java.util.Arrays;

public class TestAblage {

	public static void main(String[] args) {

		Soldat s1 = new Soldat();
		s1.setName("Max");
		s1.setVorname("Mustermann");
		s1.setPk("120363-M-93857");
		s1.setDienstgrad("Lt");

		File datei = new File("./src/persistenz/aufgaben/soldat_a2/ablage.dat");
		Ablage.speichern(Arrays.asList(s1), datei);

		for (Soldat s : Ablage.laden(datei)) {
			System.out.println("Name      : " + s.getName());
			System.out.println("Vorname   : " + s.getVorname());
			System.out.println("PK        : " + s.getPk());
			System.out.println("Dienstgrad: " + s.getDienstgrad());
			System.out.println();
		}
	}
}
