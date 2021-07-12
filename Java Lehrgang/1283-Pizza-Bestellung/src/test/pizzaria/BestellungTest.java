package pizzaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BestellungTest {

	private static Bestellung testBestellung;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testBestellung = new Bestellung(new Gericht("Salami", 3.0),
				PizzaGroesse.ErzeugeObjekt(PizzaGroesse.GROESSE.MITTEL), new Extras("Pilz", 0.5), false, false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testBestellung = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBestellungGerichtPizzaGroesseExtrasBooleanBoolean() {
		assertNotNull(testBestellung);
	}


	@Test
	public void testGetEndPreis() {
		testBestellung.Berechne();
		assertEquals(testBestellung.getEndPreis(), 3.5, 0.001);
		
	}

	@Test
	public void testIstNeueBestellung() {
		assertTrue(testBestellung.IstNeueBestellung());
	}

}
