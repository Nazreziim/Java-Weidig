package _3readerWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _5Writer {
	public static void main(String[] args) {
		/** 1. Datei anlegen **/
		FileWriter fw = null;
		
		try {
			//ENTWEDER
//			fw = new FileWriter("Weidig/dateien/WriterDatei.txt");
			
			//ODER
			File file = new File("Weidig/dateien/WriterDatei.txt");
			fw = new FileWriter(file);
			
			fw.write(54); //Befüllt den Writer mit dem Byte 54 --> 6 [ASCII]
			fw.write(" - Schreiben mit FileWriter");
			
			/** HINWEIS: Hier wird alles in das FileWriter Objekt reingelegt
			 *  --> ERST MIT FOLGENDER METHODE WIRD ES IN DIE DATEI GESCHRIEBEN
			 */
			
			fw.flush(); //Legt die sich aktuell im FileWriter befindlichen Daten in die Datei
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/** 2. Daten anhängen **/
		
		try {
			fw = new FileWriter("Weidig/dateien/WriterDatei.txt", true); //true bedeutet, dass alle Daten angehängt werden statt an den Start geschrieben zu werden [Verknüpfung mit RandomAccess] 
			fw.write('\n'); //Erzeugt einen Absatz
			fw.write("Diese Daten wurden angehängt");
			
			
			fw.flush(); //Alles wieder in die Datei reinschreiben
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/** 3. Weitere Möglichkeit z.B. PrintWriter **/
		try {
			PrintWriter pw = new PrintWriter("Weidig/dateien/PrintWriterDatei.txt");
			pw.println("Das ist eine normale Zeile.");
			pw.printf("Das ist eine Zahl: %02d\n", 12); //\n macht wieder einen Absatz
			pw.print("Das ist auch eine Zahl: ");
			pw.println(12);
			
			pw.flush();
			
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/** HINWEIS: Es gibt extrem viele Writer Möglichkeiten **/
		
	}
}
