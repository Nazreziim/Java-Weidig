package _2randomAccess;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class _4RandomAccessLesen {
	// 2.) Auslesen aus einer RandomAccess-Datei
	public static void main(String[] args) {
		File f = new File("Weidig/dateien/randomAccess.txt");

		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			System.out.println("PointerPosition: " + raf.getFilePointer());

			// ACHTUNG: Er wird hier immer einfach weitergehen und es als das lesen was ich
			// angebe

			raf.writeBoolean(true);
			raf.writeInt(5);
			raf.writeChars("Hallo");
			raf.writeUTF(" Welt.");
			System.out.println("PointerPosition: " + raf.getFilePointer());

			// POINTER WIEDER AUF 0 SETZEN
			raf.seek(0);
			System.out.println("PointerPosition: " + raf.getFilePointer());

			boolean wahr = raf.readBoolean();
			int zahl = raf.readInt();
			System.out.println(wahr + " - " + zahl);
			System.out.println(raf.readChar());
			System.out.println(raf.readChar());
			System.out.println(raf.readChar());
			System.out.println(raf.readChar());
			System.out.println(raf.readChar());
			System.out.println(raf.readUTF());

			System.out.println("PointerPosition: " + raf.getFilePointer());
			// POINTER WIEDER AUF 0 SETZEN
			raf.seek(0);
			System.out.println("PointerPosition: " + raf.getFilePointer());

			// Gibt eine ganze Zeile aus
			System.out.println(raf.readLine());
			System.out.println("PointerPosition: " + raf.getFilePointer() + "\n");

			// LEEREN
			raf.setLength(0);
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3.) Eine Datei komplett ausgeben
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");

			String string = "Heute wollen wir marschier'n,\n" + "Einen neuen Marsch probier'n.\n"
					+ "In den schoenen Westerwald,\n" + "Ja da pfeift der Wind so kalt.\n"
					+ "In den schoenen Westerwald,\n" + "Ja da pfeift der Wind so kalt.";

			raf.writeUTF(string);
			raf.seek(0);

			String s = raf.readLine();
			while (s != null) {
				System.out.println(s);
				s = raf.readLine();
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
