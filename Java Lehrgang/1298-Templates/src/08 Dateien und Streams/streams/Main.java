package streams;

import java.io.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Schreiben in einen Stream		
		File f = new File("./streams.txt");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(65);
			fos.write(255);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {}
		
		//Auslesen aus einem Stream
		try {
			FileInputStream fis = new FileInputStream(f);
			System.out.println(fis.read());
			System.out.println(fis.read());
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {}
		
		// Decorator-Pattern für einen FileInputStream
		try {
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("./streams.txt")));
			dos.writeChars("Treffen sich zwei Jaeger...");
			dos.flush();
			dos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
