package streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterReaderTest {

	public static void main(String[] args) {
				
		try {
			// Wandelt primitive Datentypen in Strings
			PrintWriter pw = new PrintWriter("./src/streams/Ausdruck.txt");
			
			pw.println("Formatierter Ausgabe ist auch moeglich");
			pw.printf("Die Datei ist %02d gross.\n", 12);
			pw.println(12);
						
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String zeile = null;
		// PrintReader gibt es nicht!
		try {
			BufferedReader br = new BufferedReader(new FileReader("./src/streams/Ausdruck.txt"));
		
			while (br.ready()){
				zeile = br.readLine();
				
				System.out.println(zeile);	
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
