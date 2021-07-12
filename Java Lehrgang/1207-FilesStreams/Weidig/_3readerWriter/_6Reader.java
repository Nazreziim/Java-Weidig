package _3readerWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _6Reader {
	public static void main(String[] args) {
		//Datei vorher erstellen und mit Inhalt der gelesen werden soll bef�llen
		
		File datei = new File("Weidig/dateien/PrintWriterDatei.txt"); // In File Objekt damit wir es �fters
		// verwenden k�nnen ohne jedes Mal den Pfad
		// anzugeben

		/** 1. FileReader **/
		/** Funktioniert quasi wie RandomAccess Byte f�r Byte **/
		try {
			// Neues FileReaderObjekt
			FileReader fr = new FileReader(datei);

			// Muss zu (char) gecastet werden, da .read den int Wert des
			// jeweiligen Chars zur�ckliefert
			System.out.println((char) fr.read());

			// Wir schlie�en und setzen den Reader NEU um den internen Zeiger wieder auf 0
			// zu setzen. ---> Aufzeigen durch auskommentieren der beiden Zeilen am Ende.
			fr.close();
			fr = new FileReader(datei);

			int inhalt = 0; // .read gibt int zur�ck - Diesen wollen wir zwischenspeichern
			String fertigerString = ""; // Diesen hier wollen wir sp�ter ausgeben

			// IN DER WHILE BEDINGUNG wird inhalt der aktuelle Char zugewiesen. BIS
			// irgendwann -1 als int zur�ckkommt [gem. Methodenbeschreibung
			// kommt -1 als R�ckgabe, sobald das Ende der Datei erreicht ist]
			while ((inhalt = fr.read()) != -1) {
				fertigerString += (char) inhalt;
			}

			System.out.println(fertigerString);

			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** 2. Decorator-Pattern - Der Reader im Reader **/
		try {
			BufferedReader br = new BufferedReader(new FileReader(datei));

			// Gibt aus ob es eine "Markierung" zul�sst [BufferedReader JA, FileReader NEIN)
			System.out.println(br.markSupported());

			br.mark(100); // Markiert die aktuelle Stelle mit der Anzahl an Zeichen welche danach noch
							// gelesen werden K�NNTEN. Beschreibung sagt eindeutig: "Es K�NNTE FEHLSCHLAGEN"

			/*
			 * HINWEIS: Den Wert bei mark ver�ndern und schauen wie viele Zeilen man noch
			 * einlesen kann.
			 */

			br.reset(); // Springt an die Stelle welche ich vorher markiert habe

			// Erkennt quasi den Absatz, geht bis dorthin und legt es uns in unseren
			// BufferedReader
			System.out.println(br.readLine()); // Muss nicht gecastet werden da R�ckgabe = String

			// ACHTUNG: WO SIND WIR JETZT IM TEXT?
			// --> RICHTIG: In der n�chsten Zeile
			// --> HEI�T: Beim n�chsten .readline wird die n�chste Zeile in den Buffer
			// geschrieben

			String zeile = ""; // Hier wollen wir die Zeilen zwischenspeichern, da .readLine ein String
								// zur�ckgibt bzw. null sobald wir am Ende sind

			// IN DER WHILE BEDINGUNG wird zeile die aktuelle Zeile zugewiesen. BIS
			// irgendwann null zur�ckkommt [gem. Methodenbeschreibung kommt null als
			// R�ckgabe, sobald das Ende der Datei erreicht ist]
			while ((zeile = br.readLine()) != null) {
				// Gibt mir die Zeile aus
				System.out.println(zeile);
			}

			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
