package objektorientierung;

public class Schulhof {

	public void newSchueler() {

		Schueler eins = new Schueler("Doerte", 15, 10);
		
		System.out.println();
		System.out.println(eins.getName());
		
		Schueler zwei = new Schueler("MrBizeps", 22);
		
		System.out.println();
		System.out.println(eins.getName() + " , " + zwei.getName());

		Schueler drei = new Schueler("Jan");
		
		System.out.println();
		System.out.println(eins.getName() + " , " + zwei.getName() + " , " + drei.getName());
		
		System.out.println();
		Schueler irgendwer = new Schueler();
		
		System.out.println(eins.getName() + " , " + zwei.getName() + " , " + drei.getName() + " , " + irgendwer.getName());

		eins.setName("PETER");
		
		
		//Was passiert hier?
		System.out.println();
		System.out.println(eins.getName() + " , " + zwei.getName() + " , " + drei.getName() + " , " + irgendwer.getName());
	}

}
