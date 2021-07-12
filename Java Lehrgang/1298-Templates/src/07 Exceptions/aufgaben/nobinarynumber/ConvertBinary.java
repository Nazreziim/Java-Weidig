package aufgaben.nobinarynumber;

public class ConvertBinary {

	private String binzahl;
	private int dezzahl;
	
	public ConvertBinary(String binzahl) {
		this.binzahl = binzahl;
		convert();
	}

	private void convert() {
		int erg = 0;
		int pos = 0;
		for (char c : binzahl.toCharArray()) {
			if (c == '1') {				
				erg = erg * 2 + 1;
				pos++;
			} else {
				if (c == '0') {
					erg = erg * 2;
					pos++;
				} else {
					throw new NoBinaryNumberException(binzahl, pos);
				}
			}
		}
		 dezzahl = erg;
	}

	public String getBinzahl() {
		return binzahl;
	}


	public int getDezzahl() {
		return dezzahl;
	}

}
