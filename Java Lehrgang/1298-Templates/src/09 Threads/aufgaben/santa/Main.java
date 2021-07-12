package aufgaben.santa;

import java.io.*;



/**
 * Main-Klasse zum Starten des Programms
 * Ausgaben des Programms werden in einen PrintStream umgeleitet,
 * der alles in eine Datei schreibt.
 * 
 * @author LGerhard
 *
 */
public class Main {

	public static void main(String[] args) {
		try {
			PrintStream dos = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("./santa.txt"))));
			System.setOut(dos);
			Santa s = new Santa(2);
			s.join();
			dos.flush();
			dos.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
