package aufgaben.lotto;

public class LottoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LottoTipps schein1 = new LottoTipps();
		schein1.fillLottoSchein(10);
		schein1.printLottoSchein();
		schein1.pruefeDoppelteZahl();

	}

}
