class Analyse1 {
	static String macheKaputt(String name) {
		name = "neuer Name";
		System.out.println("Zerstört: "+name);
		return name;
	}

	public static void main(String[]args) {
		String name = "Peter";
		macheKaputt(name);
		System.out.println(macheKaputt(name));
		System.out.println(name);
		
		String s = "Peter";
		//System.out.println(s[0]);
	}
}
