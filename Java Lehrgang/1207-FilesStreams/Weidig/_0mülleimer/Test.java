package _0mülleimer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
	public static void main(String[] args) {
		File file = new File("Weidig/dateien/WriterDatei");
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.write(9);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
