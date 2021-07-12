package randomAccess;

import java.io.*;

public class RandomAccessTest {

	public static void anlegenDatei(File file){
		
		if (!file.exists()) {
			try {
				if ( file.createNewFile() ){
					System.out.printf("Datei: %s erfolgreich angelegt.\n", file.getName());
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void schreibenInDatei(File file, boolean anhaengen){
		
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(file,"rw");
			if ( anhaengen ){
				raf.seek(raf.length());
			}
			
			System.out.println("Positionszeiger: " + raf.getFilePointer());
			raf.writeInt(51);
			raf.writeUTF("Hoelzle");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				System.out.println("Dateileange: " + raf.length()); // datei muss geoeffnet sein?
				raf.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Dateileange: " + file.length() + " Bytes");
	}
	
	public static void lesenAusDatei(File file){
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(file,"r");
			while (raf.getFilePointer() != raf.length()){
				System.out.println("->" + raf.readInt());
				System.out.println("->" + raf.readUTF());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Dateileange: " + file.length() + " Bytes");
	}
	
	// nicht geeignet, da Datentypen nicht interpretiert werden.
	public static void lesenAusDateiBytes(File file){
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile(file,"r");
			String s = "";
			try {
				
				while ((s = raf.readLine()) != null) {				
					System.out.println(s);				
				}
				raf.close();
			} catch (IOException e) {					
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {				
			e.printStackTrace();
		} 
		
		System.out.println("Dateileange: " + file.length() + " Bytes");
	}
	
	public static void schreibenInDateiWahlfrei(File file){

		try {
			RandomAccessFile raf1 = new RandomAccessFile(file, "rw");
			System.out.println(raf1.getFilePointer());
			
			// absolutes positionieren
			raf1.seek(100);
			System.out.println(raf1.getFilePointer());
			
			raf1.writeChar('A');
			System.out.println(raf1.getFilePointer());
			
			raf1.seek(13);
			raf1.write('X');
			System.out.println(raf1.getFilePointer());
			
			// relatives positionieren
			raf1.skipBytes(10);
			raf1.write('X');
			System.out.println(raf1.getFilePointer());
			
			System.out.println(raf1.length());
			raf1.seek(raf1.length());
			
			System.out.println(raf1.readLine());
			raf1.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Dateileange: " + file.length() + " Bytes");
	}
	
	public static void loescheDateiInhalte(File file){
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			// Hinweis:
			// Eine Positionsanweisung .seek(0) bewirkt kein Loeschen der Inhalte!
			raf.setLength(0);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Dateileange: " + file.length() + " Bytes");
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("./src/randomAccess/randomaccess.txt");
		
		//anlegenDatei(f);
			
		
		// in Datei schreiben, die nicht existiert?
		// Datei wird automatisch neu erzeugt.
		// 1.) Schreiben
		schreibenInDatei(f, false);
		
		// 2.) Lesen 
		lesenAusDatei(f);
				
		
		// Daten anhaengen 
//		schreibenInDatei(f, true);
//		lesenAusDatei(f);
		
//		lesenAusDateiBytes(f);	// mit readline()
		
//		f.delete(); // Datei loeschen
		

//		loescheDateiInhalte(f);
//		lesenAusDatei(f);
		
		
		// 3.) Zufälliger Zugriff
		//schreibenInDateiWahlfrei(f);
			
//		f.delete(); // Datei loeschen
			
		
	
	}

}
