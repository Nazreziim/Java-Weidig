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

			// Einen String schreiben und aus diesem das zugeh�rige ByteArray holen.
			fos.write("Heute ist ein wundersch�ner Tag.\nWas k�nnten wir heute machen?".getBytes());
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
		// Zeigen was man alles in BufferedOutputStream packen k�nnte ( new ...(new HIER
		// AUTOVERVOLLST�NDIGUNG))
		try {
			//Irgendwo muss der Stream (Zweck) seine Daten reinf�llen
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(datei));
			// Methoden zeigen durch bos. AUTOVERVOLLST�NDIGUNG
			/*
			 * Unterschied: 
			 * FOS KANN die Daten direkt in eine Datei "sp�len" (flush) 
			 * BOS "sp�lt" (flush) die Daten in einen unterliegenden OutputStream
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
			// WARUM? - Zur Veranschaulichung, dass man �ber verschiedenste Streams hinweg
			// zu letztendlich dem kommen kann bei dem ich dann meine gew�nschten Daten in
			// den Stream setzen kann. [z.B. k�nnte ich den B O S auch weglassen, da der
			// DataOutput einen FileOutput akzeptiert]
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(datei, true)));
			// ^ bedeutet append = true

			dos.write("\n\nWie w�re es mit McDonalds?".getBytes()); // Sichere Methode f�r Umlaute etc.
			dos.writeUTF("\n\nWie w�re es mit McDonalds?"); // Unichere Methode f�r Umlaute etc.
			dos.writeChars("\n\nWie w�re es mit McDonalds?"); // M�chte man das so?

			// Flush (Siehe Beschreibung) "sp�lt" vom obersten bis durch den untersten und
			// ruft in diesem Fall flush im FOS auf
			
			//HIER IST ES NOTWENDIG
			dos.flush();
			dos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
