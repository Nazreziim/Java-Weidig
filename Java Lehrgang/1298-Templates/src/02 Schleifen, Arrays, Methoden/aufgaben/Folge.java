package aufgaben;

public class Folge {

public static void main(String[] args) {
	System.out.println(folge_it(6));
	System.out.println(folge_rek(6));
}

// Durchzählen der Elemente beginnt bei 0 - Die ersten Folgenglieder sind 0,1,3,8,20,49,119
public static int folge_it(int z) {
	int erg =  0;
	int vorg = 1;
	int vorvorg = 0;
	if (z == 0 || z == 1) {
		erg = z;
	} else {
		for (int i = 2; i <= z; i++) {
			erg = vorg * 2 + vorvorg + 1;
			vorvorg = vorg;
			vorg = erg;
		}
	}	
	return erg;
}

public static int folge_rek(int z) {
	int erg;
	if (z == 0 || z == 1)  {
		erg = z;
	} else {
		erg = folge_rek(z-1) * 2 + folge_rek(z-2) +1;
	}
	
	return erg;
}

}
