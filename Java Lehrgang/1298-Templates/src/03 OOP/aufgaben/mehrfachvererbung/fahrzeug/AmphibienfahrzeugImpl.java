package fahrzeug;

public class AmphibienfahrzeugImpl extends AutoImpl implements Amphibienfahrzeug{

	private SchiffImpl schiff;
	
	public AmphibienfahrzeugImpl(double gewicht){
		super(gewicht);
		schiff = new SchiffImpl(gewicht);
	}

	public boolean closeGangway(boolean b){
		return this.schiff.closeGangway(b);
	}

}
