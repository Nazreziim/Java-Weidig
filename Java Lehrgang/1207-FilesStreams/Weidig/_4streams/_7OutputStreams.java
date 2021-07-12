package _4streams;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _7OutputStreams {
	public static void main(String[] args) {
		// Festlegen um welche Datei es sich wieder handelt
		File datei = new File("Weidig/dateien/stream.txt");

		/** 1. FileOutputStream **/
		try {
			// Neues FOS Objekt
			FileOutputStream fos = new FileOutputStream(datei);

			// Einen String schreiben und aus diesem das zugehörige ByteArray holen.
			fos.write("Heute ist ein wunderschöner Tag.\nWas könnten wir heute machen?".getBytes());
			// In die Datei schreiben. NICHT NOTWENDIG DA BEI OUTPUTSTREAMS FLUSH NICHTS MACHT
			fos.flush();

			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** 2. BufferedOutputStream **/
		// Zeigen was man alles in BufferedOutputStream packen könnte ( new ...(new HIER
		// AUTOVERVOLLSTÄNDIGUNG))
		try {
			//Irgendwo muss der Stream (Zweck) seine Daten reinfüllen
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(datei));
			// Methoden zeigen durch bos. AUTOVERVOLLSTÄNDIGUNG
			/*
			 * Unterschied: 
			 * FOS KANN die Daten direkt in eine Datei "spülen" (flush) 
			 * BOS "spült" (flush) die Daten in einen unterliegenden OutputStream
			 */
			
			bos.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** 3. Streams in Streams **/
		try {
			// WARUM? - Zur Veranschaulichung, dass man über verschiedenste Streams hinweg
			// zu letztendlich dem kommen kann bei dem ich dann meine gewünschten Daten in
			// den Stream setzen kann. [z.B. könnte ich den B O S auch weglassen, da der
			// DataOutput einen FileOutput akzeptiert]
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(datei, true)));
			// ^ bedeutet append = true

			dos.write("\n\nWie wäre es mit McDonalds?".getBytes()); // Sichere Methode für Umlaute etc.
			dos.writeUTF("\n\nWie wäre es mit McDonalds?"); // Unichere Methode für Umlaute etc.
			dos.writeChars("\n\nWie wäre es mit McDonalds?"); // Möchte man das so?

			// Flush (Siehe Beschreibung) "spült" vom obersten bis durch den untersten und
			// ruft in diesem Fall flush im FOS auf
			
			//HIER IST ES NOTWENDIG
			dos.flush();
			dos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
