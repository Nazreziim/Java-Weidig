package analyse;

public class Analyse02 {

	public static void main(String[] args) {

		char[] [] uebersicht = { 
			{'T', 'e', 'i', 'l', 'n', 'e', 'h', 'm', 'e', 'r'},
			{'U', 'e', 'b', 'e', 'r', 's', 'i', 'c', 'h', 't'},
			{'V', 'e', 'r', 'f', 'u', 'e', 'g', 'u', 'n', 'g'},
			{' ', ' ', 'B', 'a', 'd', 'e', 'h', 'o', 's', 'e'},
			{'F', 'r', 'i', 'e', 'd', 'b', 'e', 'r', 'g', ' '},
			{'E', 'h', 'e', 'm', 'a', 'n', 'n', ' ', ' ', ' '},
			{' ', 'G', 'r', 'u', 'n', 'd', 'l', 'a', 'g', 'e'},
			{'P', 'o', 'l', 'i', 'z', 'i', 's', 't', 'i', 'n'},
			{' ', 'L', 'e', 'h', 'r', 'g', 'a', 'n', 'g', ' '},
			{'H', 'u', 'g', 'e', 'n', 'd', 'u', 'b', 'e', 'l'}  };
		
		final char[] b = {'B', 'i', 'e', 'r'};
		
		boolean ok = false;
		int z = 0;
		int idx = 0;
		
		for ( int s = 0; s < uebersicht[0].length; s++){
			idx = 0;
			z   = 0;
			
			while ( !ok && z < uebersicht.length ){
				
				if ( uebersicht [z] [s] == b[idx] ){
					idx++;
				}
				else{
					idx = 0;
				}
				
				if (idx == b.length){
					ok = true;
				}
				
				z++;
			}
		}
		
		System.out.println(ok);
	}

}
