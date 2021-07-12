package aufgaben.nobinarynumber;

public class ConvertBinaryTest {

	public ConvertBinaryTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ConvertBinary cb = new ConvertBinary("10010");
		System.out.println(cb.getDezzahl());
		
		try {
			ConvertBinary cb2 = new ConvertBinary("10021");
			System.out.println(cb.getDezzahl());
		} catch (NoBinaryNumberException e) {
			System.out.println(e.getMessage());
		}

	}

}
