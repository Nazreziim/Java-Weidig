package file.aufgaben.verzeichnisstruktur;

import java.io.File;
import java.io.FilenameFilter;

public class FileTree {

	private class DirectoryFilter implements FilenameFilter {
		public boolean accept(File parent, String current) {
			return new File(parent, current).isDirectory();
		}
	}

	private class FileFilter implements FilenameFilter {
		public boolean accept(File parent, String current) {
			return new File(parent, current).isFile();
		}
	}

	private void printTree(File current, String indent) {
		for (File child : current.listFiles(new FileFilter())) {
			System.out.println(indent + "-<" + child.getName() + ">");
		}
		
		for (File child : current.listFiles(new DirectoryFilter())) {
			System.out.println(indent + "\\<" + current.getName() + ">");
			printTree(child, "  " + indent);
		}
	}

	public static void main(String[] args) {
		File userDir = new File(System.getProperty("user.dir"));
		new FileTree().printTree(userDir, "");
	}
}
