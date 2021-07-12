package view.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import view.View;

public class ViewTest {

	static LinkedList<String> menu;
	
	@BeforeClass
	public static void setUp() throws Exception {
		menu = new LinkedList<>();
		menu.add("Ueberschrift");
		menu.add("Erster Eintrag");
		menu.add("Zweiter Eintrag");
		menu.add("Letzter Eintrag");
	}

	@Test
	public void testReadInt() {
		int z1 = View.readInt("Zahl 5 eingeben:");
		assertTrue(z1 == 5);
		z1 = View.readInt("Zahl -17 eingeben:");
		assertTrue(z1 == -17);
		z1 = View.readInt("Zahl 0 eingeben:");
		assertTrue(z1 == 0);
	}
	
	@Test (expected = NumberFormatException.class)
	public void testReadIntException() {
		int z1 = View.readInt("String eingeben:");		
	}

	@Test
	public void testReadString() {
		String s = View.readString("Bitte AAA eingeben:");
		assertTrue("String AAA nicht korrekt eingelesen", "AAA".equals(s));
		s = View.readString("Bitte einen leeren String eingeben:");
		assertTrue(new String().equals(s));
	}

	@Test
	public void testShowEntscheidung() {
		assertTrue(View.showEntscheidung("J"));
		assertTrue(View.showEntscheidung("j"));
		assertFalse(View.showEntscheidung("n"));
		assertFalse(View.showEntscheidung("N"));
		//assertFalse(View.showEntscheidung("Irgendwas anderes fuer ne Entscheidung"));		
	}

	@Test
	public void testShowMenu() {
		System.out.println("Bitte nacheinander alle Menuepunkte auswaehlen");
		int i = View.showMenu(menu);
		assertTrue(i == 1);
		i = View.showMenu(menu);
		assertTrue(i == 2);
		i = View.showMenu(menu);
		assertTrue(i == 3);
	}

}
