package templates;

public class Template_03_MultiDimArrays
{
	public static void main(String[] args)
	{
		
		// Zweidimensionales Array mit Allokation
		int[][] zweiDim = new int[5][3];
		
		zweiDim[4][0] = 15;
		zweiDim[3][1] = 30;
		zweiDim[2][2] = 45;
		zweiDim[1][1] = 60;
		zweiDim[0][0] = 75;
		
		/*
		 * int[][]zweiDim = new int[5][3];
		 * 
		 * Vorstellbar als:
		 * 
		 *    0  1  2  3  4
		 * 0 [ ][ ][ ][ ][ ]
		 * 1 [ ][ ][ ][ ][ ]
		 * 2 [ ][ ][ ][ ][ ]
		 * 
		 */
		// Zweidimensionales Array mit Initialisierung
		int[][] reihe = { 
							{0, 0, 15, 0, 0}, 
							{0, 30, 0, 0, 0}, 
							{45, 0, 0, 0, 0}
						};
						
		for (int zeile = 0; zeile < reihe.length; zeile++)
		{
			for (int spalte = 0; spalte < reihe[zeile].length; spalte++)
			{
				System.out.print(reihe[zeile][spalte] + " ");
			}
			System.out.println();
		}
	}
}