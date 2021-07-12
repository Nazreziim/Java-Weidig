package _006ReflectionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class _01Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/* ACHTUNG: 
		 * Nur eine Möglichkeit in Code implementieren
		 * und diese dann anpassen.
		 */
		
		
		/******************* Möglichkeit 1 *****************/
		// Aufzeigen über vorherige Factory, dass man .getClass().getTypeName() als Name
		// braucht um die Klasse zu finden.

		_02Tier hund = _04TierFactory.getTier("_03Hund");
		_02Tier katze = _04TierFactory.getTier("_03Katze");
		_02Tier maus = _04TierFactory.getTier("_03Maus");

		hund.macheGeräusche();
		katze.macheGeräusche();
		maus.macheGeräusche();

		/******************* Möglichkeit 2 *****************/
		// Die Klassennamen können natürlich auch auf andere Weise gespeichert werden
		// [Arrays, Listen, Dateien, Datenbanken]
		Scanner sc = new Scanner(System.in);

		System.out.println("Welches Tier möchten sie? (Hund, Katze, Maus)");

		// while(true) {
		String tier = sc.next();

		_02Tier einTier = _04TierFactory.getTier(tier);

		einTier.macheGeräusche();
		// }

		/******************* Möglichkeit 3 *****************/
		// Einmal in Datei reinschreiben und dann einmal daraus lesen
		System.out.println("Welches Tier möchten sie? (Hund, Katze, Maus)");
		String tier2 = sc.next();
		String tierKlasse = null;

		try {
			PrintWriter pw = new PrintWriter("dateien/tierConfig.cfg");
			pw.write(tier2);
			pw.close();

			tierKlasse = new BufferedReader(new FileReader("dateien/tierConfig.cfg")).readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}

		_02Tier einTier2 = _04TierFactory.getTier(tierKlasse);

		einTier2.macheGeräusche();

		/******************* Möglichkeit 4 *****************/
		/*
		 * Alles aus der Datei lesen: - Zeile 50-52 auskommentieren - Vorhandene
		 * Klassennamen in Datei reinschreiben - Nur Möglichkeit 4 ausführen
		 * [Bestenfalls Zeile 45 bis 65 auskommentieren oder Code dahingehend anpassen]
		 */

		try {

			_02Tier tier3 = null;
			BufferedReader br = new BufferedReader(new FileReader("dateien/tierConfig.cfg"));
			while ((tier3 = _04TierFactory.getTier(br.readLine())) != null) {
				tier3.macheGeräusche();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
