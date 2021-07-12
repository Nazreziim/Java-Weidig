package _6NIO;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * This class is the java.nio version of one of the exercises done in the "old-stlye" java.io
 * way within the training AnwProgBw - Java. It is adapted from an example used in the JavaSE
 * Tutorials for java.nio by Oracle.
 * @author lgerhard
 * @see https://docs.oracle.com/javase/tutorial/essential/io/walk.html
 */
public class FileTree extends SimpleFileVisitor<Path> {
	// Print information about
	// each type of file.
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		if (attr.isRegularFile()) {
			System.out.format("Regular file: %s ", file);
		} 
		System.out.println("(" + attr.size() + " bytes)");
		return FileVisitResult.CONTINUE;
	}

	// Print each directory visited.
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		System.out.format("Directory: %s%n", dir);
		return FileVisitResult.CONTINUE;
	}

	// If there is some error accessing
	// the file, let the user know.
	// If you don't override this method
	// and an error occurs, an IOException
	// is thrown.
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) {
		System.err.println(exc);
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {
		Path startDir = Paths.get(".");
		FileTree ft = new FileTree();
		Files.walkFileTree(startDir, ft);

	}

}
