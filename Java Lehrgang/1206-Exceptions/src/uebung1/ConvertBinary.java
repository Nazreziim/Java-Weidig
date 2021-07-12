package uebung1;

public abstract class ConvertBinary {

	public static int convert(String binaryNumber) throws NoBinaryNumberException {
		int result = 0;

		for (int i = 0; i < binaryNumber.length(); ++i) {
			int current = binaryNumber.charAt(i) - '0';
			if (current != 0 && current != 1) {
				throw new NoBinaryNumberException(binaryNumber, i);
			} else {
				result += current * Math.pow(2, binaryNumber.length() - i - 1);

			}
		}
		return result;
	}

	public static int convert2(String binaryNumber) throws NoBinaryNumberException {
		try {
			int result = Integer.parseInt(binaryNumber, 2);
			return result;
		} catch (Exception ex) {
			throw new NoBinaryNumberException();
		}
	}

	public static int convert3(String binaryNumer) throws NoBinaryNumberException {
		int result = 0;
		String s = binaryNumer.replace("0", "");
		s = s.replace("1", "");
		s = s.trim();

		if (s.equals("")) {
			result = Integer.parseInt(s, 2);
		} else {
			throw new NumberFormatException();
		}
		
		return result;
	}

}
