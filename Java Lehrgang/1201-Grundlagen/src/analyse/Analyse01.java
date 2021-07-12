package analyse;

public class Analyse01 {

	public static void main(String[] args) {
		int [] reihe = {5,7,0,3,4};
		int j = 0;
		int w = 0;
		
		for ( int i = 1; i < reihe.length; i++){
			j = i;
			w = reihe[j];
			
			while( j > 0 && reihe[j - 1] > w ){
				reihe[j] = reihe[j - 1];
				j--;
			}
			reihe[j] = w;
		}
		
		for ( int wert : reihe){
			System.out.println(wert);
		}
	}


}
