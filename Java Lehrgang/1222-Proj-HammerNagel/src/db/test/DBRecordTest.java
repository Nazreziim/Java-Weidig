package db.test;

import static org.junit.Assert.assertEquals;

import java.util.WeakHashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import db.DBRecord;

public class DBRecordTest {
	static DBRecord rec1;
	static DBRecord rec2; 
	static DBRecord rec3;
	static DBRecord rec4;
	static WeakHashMap<String, String> cont4;
	
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
	 rec1 = new DBRecord(3, false);
	 rec2 = new DBRecord(4, true);
	 rec3 = new DBRecord(0, false);
	 rec4 = new DBRecord(4, false);
	 rec4.addEntry("1", "val1");
	 rec4.addEntry("2", "val2");
	 rec4.addEntry("3", "val3");
	 rec4.addEntry("1", "val1");
	 cont4 = new WeakHashMap<>(4);
	 cont4.put("1", "val1");
	 cont4.put("2", "val2");
	 cont4.put("3", "val3");
	 cont4.put("1", "val1");	 
	}

	@Test
	public void testAddEntry() {
		String erg = rec1.addEntry("name", "me");
		assertEquals(null,	erg);
		erg = rec1.addEntry("name", "me2");
		assertEquals("me", erg);		
	}

	@Test
	public void testGetKey() {		
		int erg = rec1.getKey();
		assertEquals(0, erg);
		erg = rec2.getKey();
		assertEquals(1, erg);
		erg = rec3.getKey();
		assertEquals(2, erg);
	}

//	@Test
//	public void testSize() {
//		int erg = rec1.size();
//		assertEquals(0, erg);
//		erg = rec4.size();
//		assertEquals(3, erg);
//	}

	@Test
	public void testToString() {
		String erg = rec1.toString();
		assertEquals(" DBRecord Nr. 0 [contents={}]", erg);
		erg = rec2.toString();
		assertEquals("!DBRecord Nr. 1 [contents={}]", erg);
		erg = rec3.toString();
		assertEquals(" DBRecord Nr. 2 [contents={}]", erg);
		erg = rec4.toString();
		assertEquals(" DBRecord Nr. 3 [contents="+cont4.toString()+"]",erg);		
	}

	@Test
	public void testToStringArray() {
		String[] erg = rec4.toStringArray();
		String[] check = (String[]) cont4.values().toArray(new String[0]);
		for (int i = 0; i < check.length; i++) {
			assertEquals(check[i],erg[i]);
			System.out.println(erg[i]);
		}
	}

}
