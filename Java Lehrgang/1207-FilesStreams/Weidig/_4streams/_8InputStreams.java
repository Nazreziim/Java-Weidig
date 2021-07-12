package _4streams;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _8InputStreams {
	public static void main(String[] args) {
		// Festlegen um welche Datei es sich wieder handelt
		File datei = new File("Weidig/dateien/stream.txt");

		/** 1. FileInputStream **/
		System.out.println("\n----------FileInputStream----------\n");
		try {
			// Neues F I S Objekt
			FileInputStream fis = new FileInputStream(datei);

			// Gibt mir die Anzahl der noch lesbaren Zeichen aus
			System.out.println("Noch lesbare Zeichen : " + fis.available());

			// Unser Ausgabestring
			String ausgabe = "";

			// Solange bis available = 0 (Siehe JavaDoc)
			while (fis.available() != 0) {
				ausgabe += (char) fis.read();

				/*
				 * Erklärung: fis.read gibt Byte zurück -> Wir casten zu (char) um ein einzelnes
				 * Zeichen zu erhalten. Hier würde es jedoch dazu kommen, dass wenn wir nur die
				 * chars ausgeben lassen es total seltsam aussehen würde. Deswegen bietet es
				 * sich an es mit allen dazugehörigen Daten in einem String zu speichern und
				 * diesen dann ausgeben zu lassen.
				 */
			}

			// Ausgabe
			System.out.println(ausgabe);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** 2. BufferedInputStream **/
		System.out.println("\n----------BufferedInputStream----------\n");
		try {
			// Irgendwoher holt sich der BufferedInputStream seine Daten.
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(datei));

			// Gibt mir die Anzahl der noch lesbaren Zeichen aus
			System.out.println("Noch lesbare Zeichen : " + bis.available() + "\n");

			// Unser Ausgabestring
			String ausgabe = "";

			// Solange bis available = 0 (Siehe JavaDoc)
			while (bis.available() != 0) {
				ausgabe += (char) bis.read();

				/*
				 * Erklärung: fis.read gibt Byte zurück -> Wir casten zu (char) um ein einzelnes
				 * Zeichen zu erhalten. Hier würde es jedoch dazu kommen, dass wenn wir nur die
				 * chars ausgeben lassen es total seltsam aussehen würde. Deswegen bietet es
				 * sich an es mit allen dazugehörigen Daten in einem String zu speichern und
				 * diesen dann ausgeben zu lassen.
				 */
			}

			// Ausgabe
			System.out.println(ausgabe);
			bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** 3. Wieder Streams in Streams **/
		System.out.println("\n----------Streams in Streams----------\n");
		try {
			// Neue Datei erstellen
			File leereDatei = new File("Weidig/dateien/leereDatei.txt");
			leereDatei.createNewFile();

			try {
				// Neuer Outputstream der in unsere Datei etwas in UTF schreibt
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(leereDatei));
				dos.writeUTF("Hallo lieber Datenstrom");
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			/*
			 * Irgendwoher holt sich der BufferedInputStream seine Daten. Zeigen:
			 * Unterscheid zwischen dos der direkt UTF schreibt [leereDatei] und [datei]
			 * welche verschiedene Arten (chars etc.) reingeschrieben bekommen hat und somit
			 * nicht automatisch in UTF formattiert ist. Somit kommt es zu einer EOF
			 * Exception weil er sucht aber kein explizites UTF findet
			 */
			DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(leereDatei)));

			// Gibt mir die Anzahl der noch lesbaren Zeichen aus
			System.out.println("Noch lesbare Zeichen : " + dis.available() + "\n");

			System.out.println(dis.readUTF());

			dis.close();
		} catch (FileNotFoundException e) {
			System.out.println("FNFE");
		} catch (EOFException e) {
			System.out.println("EOF");
		} catch (IOException e) {
			System.out.println("IO");
		}
	}
}
