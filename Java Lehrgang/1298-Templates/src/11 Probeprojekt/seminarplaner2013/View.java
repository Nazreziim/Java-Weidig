package seminarplaner2013;

public abstract class View {
	protected void clearScreen() {
		for (int i = 0; i < 15; i++) {
			System.out.println();
		}
	}
}
