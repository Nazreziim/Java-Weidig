package grundlagen.b5Arrays;

import java.util.Arrays;

public class Hoersaal {

	public static void main(String[] args) {
		String[] hoersaal = null;
		int anzahlLt = 0;
		
		anzahlLt = HilfsMeth.readInt("Wie viele Teilnehmer hat der Hoersaal: ");
		
		hoersaal = new String[anzahlLt];
		
		for ( int i = 0; i < hoersaal.length; i++){
			hoersaal[i] = HilfsMeth.readString("Geben Sie den " + (i +1) + ".Teilnehmer ein:");
		}
		
		System.out.println("Ausgabe aller Teilnehmer");
		System.out.println("========================");
		
		for (String name : hoersaal){
			System.out.println(name);
		}
		
		System.out.println("Namen sortiert ausgeben");
		Arrays.sort(hoersaal);
		
		for (String name : hoersaal){
			System.out.println(name);
		}
	}

}
