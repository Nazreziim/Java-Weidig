package client.local.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.local.LocalClient;

public class LocalClientTest {

	static LocalClient c1;
	static LocalClient c2;
	
	private static File f;
	private static File tmp;
	
	private class LocalThread extends Thread {
		private LocalClient c;
		private int id;
		private int countUnbooked;
		
		public LocalThread(LocalClient c, int id) {
			this.c = c;
			this.id = id;
			this.countUnbooked =0;
		}
		
		@Override
		public void run() {
//			String[] book = null; 
//			book = c.getContractor(13L);
			String[] book = {"Buonarotti & Company            ", "Bali Hai                                                        ", "Plumbing, Air Conditioning, Air Conditioning                    ", "9     ", "$70.00  ",null};
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					fail("Unexpected InterruptedException: " + e.getMessage());
				}
				if (!c.bookContractor(book, "12345678")) {
					countUnbooked++;
				}
			}
		}
		
		@Override
		public String toString() {
			return "Thread " + id + " did not book " + countUnbooked + " times.";
		}

		/**
		 * @return the countUnbooked
		 */
		public int getCountUnbooked() {
			return countUnbooked;
		}	
	}
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void oneTimeSetUp() throws Exception {
		f = new File(System.getProperty("user.dir")+"\\db-2x1.db");
		tmp = new File("tmp.db");
		FileChannel sourceChannel = new FileInputStream(f).getChannel();
		FileChannel destChannel = new FileOutputStream(tmp).getChannel();
		destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		sourceChannel.close();
		destChannel.close();
		c1 = new LocalClient(f.getPath());
		c2 = new LocalClient(f.getPath());
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
	public void testBookContractors() {
		// No match
		assertFalse(c1.bookContractor(new String[]{"gibts nicht", null,null,null,null,null},"12345678"));
		// More than one match
		assertFalse(c1.bookContractor(new String[]{"Buona", null,null,null,null,null},"12345678"));
		// Positive test:
		assertTrue(c1.bookContractor(new String[]{"Buonarotti & Company            ", "Bali Hai                                                        ", "Plumbing, Air Conditioning, Air Conditioning                    ", "9     ", "$70.00  ",null},"12345678"));
	}
	@Test
	public void testBookContractorThreads() {
		
		//Single thread should not have a problem
		LocalThread t1 = new LocalThread(c1,1);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			fail(e1.getMessage());
		}
		assertEquals(0,t1.getCountUnbooked());
		
		//Multiple threads should be able to block each other
		t1 = new LocalThread(c1,1);
		LocalThread t2 = new LocalThread(c1,2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			fail(e.getMessage());
		}
		assertNotEquals(0, t1.getCountUnbooked());
		assertNotEquals(0, t2.getCountUnbooked());
//		System.out.println(t1);
//		System.out.println(t2);
	}

	@Test
	public void testGetContractor() {
		assertNotNull(c1.getContractor(11L));
		assertNull(c1.getContractor(1234L));
		
	}
}
