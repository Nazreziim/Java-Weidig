package alt.components.dialoge.dialog3;

import java.awt.Color;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ColorChooserDemo {
	public static void main(String[] args) {
		JColorChooser cc = new JColorChooser();

		Color color = cc.showDialog(null, "Farben", Color.red);
		System.out.println(color.toString());

		System.exit(0);
	}
}
