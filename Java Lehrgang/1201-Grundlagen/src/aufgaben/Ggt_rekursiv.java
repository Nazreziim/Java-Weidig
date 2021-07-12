package aufgaben;

import aufgaben.HilfsMeth;

public class Ggt_rekursiv {

	/**
	 * Rekursiv ggT ermitteln
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a = HilfsMeth.readInt("Geben Sie die 1. Zahl ein: ");
		int b = HilfsMeth.readInt("Geben Sie die 2. Zahl ein: ");
		
		System.out.printf("Der ggT von %d und %d ist %d.\n", a, b, ggT(a,b));
		System.out.printf("Der ggT von %d und %d ist %d.\n", a, b, ggT_1(a,b));
	}

	public static int ggT(int a, int b)
	{
		if ( b == 0)
		{
			return a;
		}
		else
		{
			return ggT(b, a % b);
		}
	}
	
	public static int ggT_1(int a, int b)
	{
		if ( a == b )
		{
			return a;
		}
		else if (a > b)
 		{	
			return ggT(b, a - b);
		}
		else
		{
			return ggT(a, b - a);
		}
	}
}
