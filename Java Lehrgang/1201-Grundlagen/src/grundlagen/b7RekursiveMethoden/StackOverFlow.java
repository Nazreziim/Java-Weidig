package grundlagen.b7RekursiveMethoden;

public class StackOverFlow{

	public static void main( String... args ){
	
		System.out.println( sum( 4 ) );
		
	}
	
	public static int sum( int n ){
		int ergebnis = 0;
		
//		if( n!= 0){
			System.out.println( n );
			ergebnis = n + sum( n - 1 );
//		}
		return ergebnis;
	}
}