package singleton;

public class MichGibtsNurEinmal {

	private static MichGibtsNurEinmal mgne;
	
	private MichGibtsNurEinmal() {		
	}
	
	public static MichGibtsNurEinmal getInstance() {
		if (mgne != null) {
			return mgne;
		} else {
			return mgne = new MichGibtsNurEinmal();
		}
	}
	
	@Override
	public String toString() {
		return "MichGibtsNurEinmal []";
	}
	
	
}
