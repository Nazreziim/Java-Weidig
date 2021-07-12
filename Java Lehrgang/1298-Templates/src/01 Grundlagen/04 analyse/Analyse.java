package analyse;


public class Analyse {
	static String president = "Gauck";
	
	public static void main(String[] args) {
			//String president = "Barack Bin Laden II";
			int gehalt = 400000;
			long erh = 3000;
			boolean ehrlich = false;
			System.out.println(president + " " + gehalt + erh);
			gehalt += erh;
			System.out.println(gehalt);
			ehrlich = (ehrlich = true || false);
			System.out.println(ehrlich);

	}

}

