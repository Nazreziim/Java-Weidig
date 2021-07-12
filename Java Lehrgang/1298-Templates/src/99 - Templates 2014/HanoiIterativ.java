public class HanoiIterativ {
	public static void main (String[] args) {
		hanoi(3);
	}
	
	public static void hanoi(int n) {
		int[][] scheiben = new int [3][n+1];
		int[] start = {n, 0, 0};
		int pS = 0;
		int pos1, pos2, step = 2;
		
		for (int i = 0; i < n+1; i++) {
			scheiben[0][i] = n+1-i;
		}
		scheiben[1][0] = n+1;
		scheiben[2][0] = n+1;
		
		while(scheiben[2][n] != 1) {
			System.out.printf("Kleinste Scheibe von %d nach %d\n", pS, (pS + step) % 3);
			scheiben[pS][start[pS]--] = 0;
			pS = (pS + step) % 3;
			scheiben[pS][++start[pS]] = 1;
			
			pos2 = (scheiben[(pS+1)%3][start[(pS+1)%3]] > scheiben[(pS+2)%3][start[(pS+2)%3]]) ? (pS+2)%3 : (pS+1)%3;
			
			pos1 = 2*(pS+pos2) % 3;
			
			if (scheiben[pos1][start[pos1]] != scheiben[pos2][start[pos2]]) {
				System.out.printf("--------------> Scheibe von %d nach %d\n", pos2, pos1);
				scheiben[pos1][++start[pos1]] = scheiben[pos2][start[pos2]];
				scheiben[pos2][start[pos2]--] = 0;
			}
		}
	}
}
