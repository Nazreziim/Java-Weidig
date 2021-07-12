package singleton;

public class SingletonMain {

	public static void main(String[] args) {
		MichGibtsNurEinmal einmal = MichGibtsNurEinmal.getInstance();
		System.out.println(einmal);

	}

}
