package aufgaben;
class Bananas {
	public static void main(String[] args) {
		int bruttoKilo = Integer.parseInt(args[0]);
		int gew = Integer.parseInt(args[1]);
		int mwst = Integer.parseInt(args[2]);
		
		long bruttoPreisCent = Math.round((float)gew / 1000.0f * (float)bruttoKilo);
		long nettoPreisCent = Math.round(bruttoPreisCent / (mwst / 100.0f + 1));
		long mwStCent = bruttoPreisCent - nettoPreisCent;
		
		
		System.out.print("Brutto ");
		//System.out.printf("%.2f", bruttoPreisCent / 100.0f);
		System.out.print(bruttoPreisCent / 100 + "." + bruttoPreisCent % 100);
		System.out.println(" Euro");
		
		System.out.print("MWSt ");
		//System.out.printf("%.2f", mwStCent / 100.0f);
		System.out.print(mwStCent / 100 + "." + mwStCent % 100);
		System.out.println(" Euro");
		
		System.out.print("Netto ");
		//System.out.printf("%.2f", nettoPreisCent / 100.0f);
		System.out.print(nettoPreisCent / 100 + "." + nettoPreisCent % 100);
		System.out.println(" Euro");
	}
}
