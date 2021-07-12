package aufgaben.gartenparty;

import java.util.Arrays;

public class Gartenparty {
	PartyBesucher[] gaeste;
	static int counter = 0;
	
	
	public Gartenparty(int anzahl_besucher) {
		gaeste = new PartyBesucher[anzahl_besucher];
		init_gaeste();
	}
	
	
	private void init_gaeste() {
		for (int i = 0; i < gaeste.length; i++) {
			gaeste[i] = new PartyBesucher("Gast Nr. " + counter++, 'm');
		}
		
	}


	public static void main(String[] args) {
		System.out.println(Bierlager.getBierlager());
		Gartenparty gp = new Gartenparty(30);
		System.out.println(gp);
		gp.getraenke_verteilen();
		System.out.println(gp);

	}
	
	private void getraenke_verteilen() {
		int gast_index = 0;
			for (Bierkiste k : Bierlager.getBierlager().getKisten()) {
				int flaschen_in_kiste = k.getAnzahlFlaschen();
				while (flaschen_in_kiste > 0) {
					gaeste[gast_index].trinkeBier(k.getAlkohol());
					flaschen_in_kiste--;
					gast_index++;
					if (gast_index >= gaeste.length) {
						gast_index = 0;
					}
					
				}
				k.setAnzahlFlaschen(0);
			}
		}
	@Override
	public String toString() {
		return "Gartenparty [gaeste=" + Arrays.toString(gaeste) + "]";
	}
	
		
	}

