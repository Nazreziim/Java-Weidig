package streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReaderTest {

	public static void main(String[] args) {
		// 1 Moeglichkeit zum Anlegen einer Datei
		FileWriter fw = null;
		try {
			// Dient zur Reduzierung von Speicherplatz
			fw = new FileWriter("./src/streams/Test.txt");
			fw.write(14);
			fw.write("Schreiben mit FileWriter");
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 2. Moeglichkeit Daten anhaengen
		
		try {
			fw = new FileWriter("./src/streams/Test.txt", true);
			fw.write(20);
			fw.write("Weitere Daten mit FileWriter anhaengen.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 3. Moeglichkeit mit File
		File f = new File("./src/streams/Test1.txt");
		
		try {
			// bisheriger Dateiinhalt wird geloescht
			fw = new FileWriter(f);	
			// zahlen werden reduziert als Binaerwert, hier ein Byte abgelegt.
			fw.write(30); 
			fw.write(System.lineSeparator());
			fw.write("Anhaengen von Strings und Zeichen moeglich.");
			fw.write("Einen weiteren Text anhaengen");
			fw.write("\n");   // nur ein 0x0A
			fw.write("\r\n"); // 0x0D 0x0A
			fw.write(System.lineSeparator()); // 0x0D 0x0A
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
		/******************************************************************/
		
		FileReader fr = null;
		int wert = 0;
		StringBuilder sb = new StringBuilder();
		try {
			fr = new FileReader(f);
			// Byteweises Lesen der Datei
			while ((wert = fr.read()) != -1 ){
				// Datentyp ?
				sb.append((char)wert);
			}
			
			System.out.println(sb.toString());
			
			fr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		String zeile = null;
		// bei Interface: AutoClosable moeglich
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			 			
			while ( (zeile = br.readLine()) != null){
				System.out.println(zeile);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
