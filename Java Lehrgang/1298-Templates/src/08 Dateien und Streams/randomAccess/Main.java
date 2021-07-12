package randomAccess;

import java.io.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("./08 Dateien und Streams/randomAccess/randomaccess.txt");
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		// 1.) Schreiben
		try {
			RandomAccessFile raf = new RandomAccessFile(f,"rw");
			raf.writeInt(36);
			raf.writeUTF("Gerhard");
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {}
		
		
		// 2.) Lesen 
		try {
			RandomAccessFile raf = new RandomAccessFile(f,"r");
			System.out.println(raf.readInt());
			System.out.println(raf.readUTF());
			raf.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {}

		f.delete();
		
		
		// 2.1) Eine existierende Datei öffnen und komplett ausgeben
		
		f = new File("./08 Dateien und Streams/randomAccess/text.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
							
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(f,"r");
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
		
		
		// 3.) Zufälliger Zugriff
				try {
					RandomAccessFile raf1 = new RandomAccessFile(f, "rw");
					System.out.println(raf1.getFilePointer());
					raf1.seek(100);
					System.out.println(raf1.getFilePointer());
					raf1.writeChar('A');
					System.out.println(raf1.getFilePointer());
					raf1.seek(13);
					raf1.write('X');
					System.out.println(raf1.length());
					raf1.seek(raf1.length());
					System.out.println(raf1.readLine());
					raf1.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			
				f.delete();
			
		
	
	}

}
