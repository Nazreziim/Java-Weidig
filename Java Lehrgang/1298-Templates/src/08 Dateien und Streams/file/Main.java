package file;

import java.io.*;
import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 1.) File als Datei
		File datei = new File("test.txt");		
		//System.out.println(datei.exists());		
		if (!datei.exists()) {
			try {
				datei.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Date datum = new Date(datei.lastModified());		
		
		System.out.println(datum);
		System.out.println(datei.length());
		datei.setReadOnly();
		System.out.println(datei.canWrite());			
		datei.delete();
		
		
		// 2.) File als Ordner
		File ordner = new File("./08 Dateien und Streams/ordner1");
		ordner.mkdir();
		
		System.out.println(ordner.isDirectory());
		System.out.println(datei.isDirectory());
		
		//ordner.deleteOnExit();
		
		ordner = new File("./");
		File[] contents =  ordner.listFiles();
		
		for (int i=0; i<contents.length; i++) {
			System.out.println(contents[i]);
			//System.out.println(contents[i].getName());
		}
		
//		File[] roots = File.listRoots();
//		for (File i : roots) {
//			System.out.println(i);
//		}
//		
//		JavaFileFilter filter = new JavaFileFilter(".java");
//		contents = ordner.listFiles(filter);
//		for (int i=0; i<contents.length; i++) {
//			System.out.println(contents[i].getName());
//		}
//		
//		filter = new JavaFileFilter(".txt");
//		contents = ordner.listFiles(filter);
//		for (int i=0; i<contents.length; i++) {
//			System.out.println(contents[i].getName());
//		}
		
	}

}
