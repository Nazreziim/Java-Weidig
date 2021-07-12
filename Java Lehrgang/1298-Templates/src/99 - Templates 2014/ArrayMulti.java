class ArrayMulti {
	 public static void main(String[] args) {
	 	 char[][] feld = new char[8][4];
	 	 feld[1][1] = 1;
	 	 feld[2][2] = 4;
	 	 feld[3][3] = 9;
	 	 feld[4][0] = 133;
	 	 int index = 1;
	 	 System.out.println(feld[index][index]);
	 	 index = 2;
	 	 System.out.println(feld[index][index]);
	 	 index = 3;
	 	 System.out.println(feld[index][index]);
	 	 System.out.println(feld[4][1]);
	 	 System.out.println(feld[4][1]);
	 	 System.out.println(feld[4][0]);
	 	 System.out.println(feld[4][0]);
	}
}
