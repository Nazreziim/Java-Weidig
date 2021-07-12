package streams;

import java.io.*;

public class FileOutputInputTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Schreiben in einen Stream		
		File f = new File("./src/streams/streams.dat");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			// kann nur bytes und int wegschreiben
			fos.write(65);
			fos.write(255);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {}
		
		//Auslesen aus einem Stream
		try {
			FileInputStream fis = new FileInputStream(f);
			while (fis.available() != 0){
				System.out.println(fis.read());
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {}
		
		// Decorator-Pattern für einen FileOutStream
		try {
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("./src/streams/streams1.dat")));
			// schreibt auch UTF-8 in Datenstrom
			dos.writeChars("Treffen sich zwei Jaeger...");
			dos.flush();
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
