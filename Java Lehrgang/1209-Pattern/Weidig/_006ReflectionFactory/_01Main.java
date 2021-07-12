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
		 * Nur eine M�glichkeit in Code implementieren
		 * und diese dann anpassen.
		 */
		
		
		/******************* M�glichkeit 1 *****************/
		// Aufzeigen �ber vorherige Factory, dass man .getClass().getTypeName() als Name
		// braucht um die Klasse zu finden.

		_02Tier hund = _04TierFactory.getTier("_03Hund");
		_02Tier katze = _04TierFactory.getTier("_03Katze");
		_02Tier maus = _04TierFactory.getTier("_03Maus");

		hund.macheGer�usche();
		katze.macheGer�usche();
		maus.macheGer�usche();

		/******************* M�glichkeit 2 *****************/
		// Die Klassennamen k�nnen nat�rlich auch auf andere Weise gespeichert werden
		// [Arrays, Listen, Dateien, Datenbanken]
		Scanner sc = new Scanner(System.in);

		System.out.println("Welches Tier m�chten sie? (Hund, Katze, Maus)");

		// while(true) {
		String tier = sc.next();

		_02Tier einTier = _04TierFactory.getTier(tier);

		einTier.macheGer�usche();
		// }

		/******************* M�glichkeit 3 *****************/
		// Einmal in Datei reinschreiben und dann einmal daraus lesen
		System.out.println("Welches Tier m�chten sie? (Hund, Katze, Maus)");
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

		einTier2.macheGer�usche();

		/******************* M�glichkeit 4 *****************/
		/*
		 * Alles aus der Datei lesen: - Zeile 50-52 auskommentieren - Vorhandene
		 * Klassennamen in Datei reinschreiben - Nur M�glichkeit 4 ausf�hren
		 * [Bestenfalls Zeile 45 bis 65 auskommentieren oder Code dahingehend anpassen]
		 */

		try {

			_02Tier tier3 = null;
			BufferedReader br = new BufferedReader(new FileReader("dateien/tierConfig.cfg"));
			while ((tier3 = _04TierFactory.getTier(br.readLine())) != null) {
				tier3.macheGer�usche();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
