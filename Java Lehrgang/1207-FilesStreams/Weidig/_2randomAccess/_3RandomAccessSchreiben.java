package _2randomAccess;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFiles werden genutzt wenn man 100% Kontrolle über die Datei haben
 * möchte. Man kann die Daten durch den Pointer an jeder beliebigen Stelle
 * nutzen.
 **/

public class _3RandomAccessSchreiben {
	public static void main(String[] args) {
		File datei = new File("Weidig/dateien/randomAccess.txt");

		try {
			// Verlangt Exceptionhandling falls eine Datei nicht vorhanden ist
			RandomAccessFile raf = new RandomAccessFile(datei, "rw");
			// ^ bei RAF gucken was es mit dem String auf sich hat
			/*
			 * Wichtiger Unterschied: Datei vorhanden? NEIN -> nur read (r) = EXCEPTION ->
			 * read und write (rw) = Datei wird einfach leer erstellt
			 */

			/** 1. Befüllen **/
			raf.setLength(0); // falls Datei vorhanden, wird der Inhalt nicht geloescht (FALSCH)
			System.out.println("PointerPosition: " + raf.getFilePointer()); // Quasi unser Cursor

			raf.writeBoolean(true); // Schreibt Bytes rein und setzt FilePointer = 1
			System.out.println("PointerPosition: " + raf.getFilePointer());

			raf.writeInt(70); // Schreibt den Int in Form von Bytes und setzt FilePointer = 5 [benötigt 4
								// Bytes dafür]
			System.out.println("PointerPosition: " + raf.getFilePointer());

			raf.writeChars("Hallo"); // Schreibt die einzelnen Chars und setzt FilePointer = 5 + ( 5 Zeichen * 2 Byte
										// [2Byte pro Zeichen]) = 15
			System.out.println("PointerPosition: " + raf.getFilePointer());

			// 1.2 in der Datei navigieren (absolut)
			raf.seek(100); // Datei wird vergroessert, da es Leerzeichen hinzufügt und setzt den Pointer
							// auf 100
			System.out.println("PointerPosition: " + raf.getFilePointer());
			raf.seek(5); // setzt dem FilePointer an die übergebene Position [ACHTUNG: Stelle 5 - 15 =
							// Hallo]
			System.out.println("PointerPosition: " + raf.getFilePointer());
			raf.writeUTF("Welt"); // FilePointer = -> Welt als UTF = 2 Byte fuer Laenge + 4 Byte = 6 --> Pointer
									// von 5 auf 11
			System.out.println("PointerPosition: " + raf.getFilePointer());
			raf.writeChar(70); // Pointer +2 da 70 EINEM Char entspricht der aus 2 Bytes besteht
			System.out.println("PointerPosition: " + raf.getFilePointer());

			// 1.3 in der Datei navigieren (relative!), wenn nicht gross genug, wird an das
			// Dateiende navigiert!
			System.out.println("Skip Bytes: " + raf.skipBytes(4)); // weiterbewegen des FilePointer, falls Datei gross
																	// genug ist und gibt zurück wie viele er
																	// Überspringen konnte
			// Pointer konnte nur 2 überspringen somit jetzt auf Position 15

			raf.writeChar(81); // Schreibt einen Char bestehnd aus 2 Bytes --> Pointer = 17
			System.out.println("PointerPosition: " + raf.getFilePointer());

			System.out.println("Dateilaenge: " + raf.length()); // Gibt die Länge der Datei in Bytes aus

		//	raf.setLength(0); // Setzt den Inhalt auf 0 [löscht alles]

			raf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
