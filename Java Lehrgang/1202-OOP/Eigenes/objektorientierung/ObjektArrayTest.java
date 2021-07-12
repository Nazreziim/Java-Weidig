package objektorientierung;

public class ObjektArrayTest {
	public static void main(String[] args) {
		Objekt[] oa = new Objekt[10];

		oa[0] = new Objekt("Worscht");
		oa[1] = new Objekt("Käse");
		oa[2] = new Objekt("Brot");
//
//		for (int i = 0; i < 2; i++) {
//
//			System.out.println(oa[i].getName());
//
//		}

		for (Objekt element : oa) {
			if (element != null) {
				if (element.getID() == 2) {
					System.out.println(element.getName());
				}
			}

		}

	}
}
