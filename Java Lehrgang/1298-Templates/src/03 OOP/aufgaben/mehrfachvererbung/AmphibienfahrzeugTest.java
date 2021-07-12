import fahrzeug.Auto;
import fahrzeug.Schiff;
import fahrzeug.Fahrzeug;
import fahrzeug.AmphibienfahrzeugImpl;

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