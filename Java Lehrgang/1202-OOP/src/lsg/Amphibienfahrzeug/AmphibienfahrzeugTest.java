package lsg.Amphibienfahrzeug;

import lsg.Amphibienfahrzeug.fahrzeug.AmphibienfahrzeugImpl;
import lsg.Amphibienfahrzeug.fahrzeug.Auto;
import lsg.Amphibienfahrzeug.fahrzeug.Fahrzeug;
import lsg.Amphibienfahrzeug.fahrzeug.Schiff;

public class AmphibienfahrzeugTest {

	public static void main(String... args){
		Fahrzeug f = new AmphibienfahrzeugImpl(3000.0);
		
		if( f instanceof Schiff ){
			((Schiff)f).closeGangway(true);
		}
		if( f instanceof Auto ){
			((Auto)f).closeLock(true);
		}
	}

}