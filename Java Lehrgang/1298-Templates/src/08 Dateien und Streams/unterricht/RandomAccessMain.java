package unterricht;

import java.io.*;

public class RandomAccessMain {

	public static void main(String[] args) {
		File f = new File("./08 Dateien und Streams/unterricht/randomAccess.txt");
		
		
		// 1.) Schreiben in eine RandomAccess-Datei
		try {
			RandomAccessFile raf = new RandomAccessFile(f,"rw");
//			System.out.println(raf.getFilePointer());
			raf.writeBoolean(true);  // FilePointer = 1
//			System.out.println(raf.getFilePointer());
			raf.writeInt(70); // FilePointer = 5
			//System.out.println(raf.getFilePointer());
			raf.writeChars("Hallo"); // FilePointer = 5 + ( 5 Zeichen * 2 Byte (16 Bit))
			//System.out.println(raf.getFilePointer());
			raf.writeUTF("Welt"); // FilePointer = 21 -> Welt als UTF = 6 Byte
			//System.out.println(raf.getFilePointer());
			
			// an eine andere Stelle springen:
			raf.seek(5);  // setzt dem FilePointer an die übergebene Position
			raf.writeChar(70); // FilePointer = 7
			raf.skipBytes(4);  // weiterbewegen des FilePointer
			raf.writeChar(81);
			
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 2.) Auslesen aus einer RandomAccess-Datei
		try {
			RandomAccessFile raf = new RandomAccessFile(f,"r");
			boolean wahr  = raf.readBoolean();
			int zahl = raf.readInt();
			System.out.println(wahr + " - " + zahl);
			System.out.println(raf.readChar());
			System.out.println(raf.readChar());
			System.out.println(raf.readChar());
			System.out.println(raf.readChar());
			System.out.println(raf.readChar());
			System.out.println(raf.readUTF());
			raf.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		// 3.) Eine Datei komplett ausgeben
		File text = new File("./08 Dateien und Streams/unterricht/text.txt");
		
		try {
			RandomAccessFile raf = new RandomAccessFile(text,"r");
			
			String s = raf.readLine();
			while ( s != null) {	
				System.out.println(s);
				s = raf.readLine();
			}
			
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
