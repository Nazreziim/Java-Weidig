package grundlagen.b4Schleifen;

class While {
	 public static void main(String[] args) {
	 	 /* While Fuss
	 	 int i = (int)((Math.random()) * 10);
	 	 int eingabe = 0;
	 	 do {
	 	 	 eingabe = HilfsMeth.readInt("Rate: ");
	 	 	 if (eingabe != i) {
	 	 	 	 System.out.println("HaHaHa HaHa");
	 	 	 }
	 	 } while (eingabe != i);

	 	 System.out.println("Endlich!");
	 	 */ 

	 	 /*
	 	 // While Kopf
	 	 int i = (int)((Math.random()) * 10);
	 	 int eingabe = 11
	 	 while (eingabe != i) {
	 	 	 eingabe = HilfsMeth.readInt("Rate: ");
	 	 	 if (eingabe != i) {
	 	 	 	 System.out.println("HaHaHa HaHa");
	 	 	 }
	 	 }
	 	 System.out.println("Endlich!");
	 	 */
	 	 
	 	 
	 	 int[] prim = {2, 3, 5, 7, 11, 13};
	 	 int i = 0;
	 	 while (i < prim.length) {
	 	 	 System.out.println(prim[i]);
	 	 	 i++;
	 	 }

	 	 char[] prim2 = {'a', '3', 'v', '#'};
	 	 int j = 0;
	 	 while (j < prim2.length) {
	 	 	 System.out.println(prim2[j]);
	 	 	 j++;
	 	 }
	 }
}
