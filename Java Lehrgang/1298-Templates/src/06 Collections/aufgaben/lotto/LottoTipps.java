package aufgaben.lotto;

import java.util.*;

public class LottoTipps {
	
	private Set<Set<Integer>> lottoschein = new HashSet<Set<Integer>>();

	
	private Set<Integer> generateTipp() {
		int anzahl = 6;
		Set<Integer> tipp = new HashSet<Integer>(anzahl);
				
		for (int i=0; i < anzahl; i++) {
			while (!tipp.add( (int)(Math.random() * 49 + 1) ));
		}
		
		return tipp;
	}
	
	public void fillLottoSchein(int anz) {
		for (int i=0; i<anz; i++) {
			if (lottoschein.size() < 10) {
				lottoschein.add(generateTipp());
			} else {
				System.out.println("Alle Tipps sind schon befüllt!");
			}
		}
	}
	
	public void printLottoSchein() {
		Iterator<Set<Integer>> it = lottoschein.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
