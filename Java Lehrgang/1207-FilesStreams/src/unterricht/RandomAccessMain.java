package unterricht;

import java.io.*;

public class RandomAccessMain {

	public static void main(String[] args) {
		File f = new File("./src/unterricht/randomAccess.txt");
		
		
		// 1.) Schreiben in eine RandomAccess-Datei
		try {
			RandomAccessFile raf = new RandomAccessFile(f,"rw");
			// 1.1 Dateiinhalt loeschen
			raf.setLength(0); // falls Datei vorhanden, wird der Inhalt nicht geloescht (FALSCH)
//			System.out.println(raf.getFilePointer());
			raf.writeBoolean(false);  // FilePointer = 1
			System.out.println(raf.getFilePointer());
			raf.writeInt(70); // FilePointer = 5
			System.out.println(raf.getFilePointer());
//			raf.writeChars("Hallo"); // FilePointer = 5 + ( 5 Zeichen * 2 Byte (16 Bit))
//			System.out.println(raf.getFilePointer());
//			System.out.println(raf.getFilePointer());
			
//			// an eine andere Stelle springen:
//			// 1.2 in der Datei navigieren (absolut)
//			//raf.seek(100); // Datei wird vergroessert
//			//raf.seek(5);  // setzt dem FilePointer an die übergebene Position
//			raf.writeUTF("Welt"); // FilePointer = -> Welt als UTF = 2 Byte fuer Laenge + 4 Byte
//			raf.writeChar(70); // 
//			// 1.3 in der Datei navigieren (relative!), wenn nicht gross genug, wird an das Dateiende navigiert!
//			//System.out.println("Skip Byptes: " + raf.skipBytes(4));  // weiterbewegen des FilePointer, falls Datei gross genug ist.
//			raf.writeChar(81);
//			System.out.println(raf.getFilePointer());
//			System.out.println("Dateilaenge: " + raf.length());
//			
//			// 1.4 nur Positionieren ohne Schreiboperation
//			//raf.seek(1000); // nur ein Positionieren
			System.out.println("Dateilaenge: " + raf.length());
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		// 2.) Auslesen aus einer RandomAccess-Datei
//		try {
//			RandomAccessFile raf = new RandomAccessFile(f,"r");
//			System.out.println(raf.getFilePointer());
//			boolean wahr  = raf.readBoolean();
//			int zahl = raf.readInt();
//			System.out.println(wahr + " - " + zahl);
//			System.out.println(raf.readChar());
//			System.out.println(raf.readChar());
//			System.out.println(raf.readChar());
//			System.out.println(raf.readChar());
//			System.out.println(raf.readChar());
//			System.out.println(raf.readUTF());
//			raf.close();
//		} catch (IOException e) {			
//			e.printStackTrace();
//		}
		
//		// 3.) Eine Datei komplett ausgeben
//		File text = new File("./src/unterricht/text.txt");
//		
//		try {
//			RandomAccessFile raf = new RandomAccessFile(text,"r");
//			
//			String s = raf.readLine();
//			while ( s != null) {	
//				System.out.println(s);
//				s = raf.readLine();
//		
//  		     }
//			
//			raf.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

}
