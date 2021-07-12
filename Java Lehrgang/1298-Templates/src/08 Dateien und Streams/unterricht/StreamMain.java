package unterricht;

import java.io.*;

public class StreamMain {

	public static void main(String[] args) {
		File datei = new File("./08 Dateien und Streams/unterricht/streams.txt");
		
		
		// 1.) Schreiben in einen Stream
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(datei);
			fos.write(65);
			fos.write(256);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
		// 2.) Lesen aus einem Stream
		try {
			FileInputStream fis = new FileInputStream(datei);
			System.out.println(fis.read());
			System.out.println(fis.read());
			System.out.println(fis.read());  // -1, da Dateiende erreicht			
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		// 3.) Streams in Streams - das Decorator-Pattern
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(datei));
			dos.writeUTF("Hallo lieber Datenstrom");
			dos.flush(); // Hier noch nicht nötig!
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(datei));
			System.out.println(dis.readUTF());
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
