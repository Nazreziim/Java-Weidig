package db.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import db.Data;
import db.DuplicateKeyException;
import db.RecordNotFoundException;

public class DataTest {
	private static Data d;
	private static File f;
	private static File tmp;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void oneTimesetUp() throws Exception {
		f = new File(System.getProperty("user.dir")+"\\db-2x1.db");
		tmp = new File("tmp.db");
		FileChannel sourceChannel = new FileInputStream(f).getChannel();
		FileChannel destChannel = new FileOutputStream(tmp).getChannel();
		destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		sourceChannel.close();
		destChannel.close();
		d = new Data(f.getPath());
	}
	
	@SuppressWarnings("resource")
	@AfterClass
	public static void oneTimeTearDown() throws IOException {
		f = new File(System.getProperty("user.dir")+"\\db-2x1.db");
		tmp = new File("tmp.db");
		FileChannel sourceChannel = new FileInputStream(tmp).getChannel();
		FileChannel destChannel = new FileOutputStream(f).getChannel();
		destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		sourceChannel.close();
		destChannel.close();
		tmp.delete();
	}
	
	@Test
	public void testReadRecord() {
		try {
			assertNotNull(d.readRecord(0));
			assertNotNull(d.readRecord(28));
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: "+e.getMessage());
		}
	}

	@Test
	public void testReadRecordExcpetion() {
		try {
			d.readRecord(99);
			fail("RecordNotFoundException not thrown");
		} catch (RecordNotFoundException e) {
			assertTrue(e.getMessage().contains("99"));
		}
		try {
			d.readRecord(-1);
			fail("RecordNotFoundException not thrown");
		} catch (RecordNotFoundException e) {
			assertTrue(e.getMessage().contains("-1"));
		}	
	}

	@Test
	public void testLockRecord() {
		long cookie1 = 0;
		long cookie2 = 0;
		try {
			cookie1 = d.lockRecord(0);
			assertTrue(cookie1 != 0);
			long tmpcookie = cookie1;
			tmpcookie = d.lockRecord(0);
			assertTrue(tmpcookie == 0);
			cookie2 = d.lockRecord(28);
			assertTrue(cookie2 != 0);
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: "+e.getMessage());			
		} finally {
			d.unlock(0, cookie1);
			d.unlock(28, cookie2);
		}

		try {
			d.lockRecord(99);
			fail("RecordNotFoundException not thrown");
		} catch (RecordNotFoundException e) {
			assertTrue(e.getMessage().contains("99"));
		}

	}

	@Test
	public void testUnlock() {
		long cookie = 0L;
		try {
			cookie = d.lockRecord(0);
			d.unlock(0, cookie);
			cookie = d.lockRecord(28);
			d.unlock(28, cookie);
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: "+e.getMessage());	
		}


		try {
			cookie = d.lockRecord(0);
			d.unlock(0, 15);
		} catch (SecurityException e) {
			assertTrue(e.getMessage().contains("15"));
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: "+e.getMessage());
		} finally {
			d.unlock(0, cookie);
		}

	}

	@Test
	public void testCreateRecord() {
		String[] vals = null;
		try {
			vals = d.readRecord(0);
			//System.out.println(Arrays.toString(vals));
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: "+e.getMessage());
		}
		long id;
		try {
			id = d.createRecord(vals);
			assertEquals(29, id);
			id = d.createRecord(vals);
			assertEquals(30, id);
			long cookie = d.lockRecord(29);
			d.deleteRecord(29, cookie);
			d.unlock(29, cookie);
			cookie = d.lockRecord(30);
			d.deleteRecord(30, cookie);
			d.unlock(30, cookie);
		} catch (DuplicateKeyException e) {
			fail("Unexpected DuplicateKeyException: " + e.getMessage());
		} catch (SecurityException e) {
			fail("Unexpected SecurityException: " + e.getMessage());
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: " + e.getMessage());
		} 
	}

	@Test
	public void testUpdateRecord() {

		// 0.) Preparation
		String[] vals = null;
		long cookie = 0L;
		try {
			vals = d.readRecord(25);
			for (int i = 0; i < vals.length; i++) {
				vals[i] = vals[i].replace(' ', '*');
			}
			//System.out.println(Arrays.toString(vals));
			cookie = d.lockRecord(25);
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: " + e.getMessage());
		}

		//1.) SecurityException
		try {
			d.updateRecord(25, vals, cookie+42);
			fail("SecurityException should have been thrown.");
		} catch (SecurityException e) {
			assertTrue(e.getMessage().contains("25"));
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: " + e.getMessage());
		}

		//2.) RecordNotFoundException
		try {
			d.updateRecord(99, vals, cookie);
			fail("RecordNotFoundException should have been thrown.");
		} catch (RecordNotFoundException e) {
			assertTrue(e.getMessage().contains("99 can not be updated"));
		}

		//3.) RecordNotFoundException 2
		try {
			d.updateRecord(25, new String[]{"Hi there","Array","Not long enough"} , cookie);
			fail("RecordNotFoundException should have been thrown.");
		} catch (RecordNotFoundException e) {
			assertTrue(e.getMessage().contains("Wrong field length"));
		}

		// 4.) Everything fine :-)
		try {
			d.updateRecord(25, vals, cookie);
			String[] retVals = d.readRecord(25);
			for (int i = 0; i < retVals.length; i++) {
				assertTrue(retVals[i].contains("*"));
			}
		} catch (SecurityException e) {
			fail("Unexpected SecurityException: " + e.getMessage());
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: " + e.getMessage());			}

	}

	@Test
	public void testDeleteRecord() {
		long cookie = 0L;
		try {
			cookie = d.lockRecord(15);
			d.deleteRecord(15, cookie);
		} catch (RecordNotFoundException e) {
			fail("Unexpected RecordNotFoundException: " + e.getMessage());
		} finally {
//			d.unlock(15, cookie);
		}
		
		// Test isDeleted flag
		try {
			cookie = d.lockRecord(15);
			fail("RecordNotFoundException should have been thrown");
		} catch (RecordNotFoundException e) {
			assertTrue(true);
		}
		try {
			d.readRecord(15);
			fail("RecordNotFoundException should have been thrown");
		} catch (RecordNotFoundException e) {
			assertTrue(true);
		}
	}
	
	
	@Test
	public void testFindByCriteria() {
		String[] criteria = {"F", "X", null, null, null, null};
		long[] erg = d.findByCriteria(criteria);
		assertEquals(1, erg.length);
		String[] criteria2 = {"Buona", null, null, null, null, null};
		erg = d.findByCriteria(criteria2);
		assertEquals(4,erg.length);
		long[] compare = {25,0,5,18};
		Arrays.sort(compare);
		Arrays.sort(erg);
		assertTrue(Arrays.equals(compare, erg));
		
	}
}
