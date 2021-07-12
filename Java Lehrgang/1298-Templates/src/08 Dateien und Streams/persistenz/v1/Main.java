package persistenz.v1;

import java.io.*;



public class Main {
	private static final String FILENAME = "./08 Dateien und Streams/persistenz/persistenz.dta";
	
	public static void main(String[] args) {
		Soldat s1 = new Soldat("Gerhard", "Lars", "211183-G-XXXXX", "Hptm");
		
		File f = new File(FILENAME);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		// Schreiben eines Objekts
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(FILENAME);
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(s1);
			o.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Lesen eines Objekts
		Soldat neuer_soldat = new Soldat();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
			neuer_soldat = (Soldat)ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(neuer_soldat);


	}

}
