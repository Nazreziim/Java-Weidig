package v03_integriertesEnums;

public class InternalEnum {

	protected enum MyEnum {
		AktionPacken, AktionEssen;
	}

	public void doSomething(MyEnum me) {
		if (me.equals(MyEnum.AktionPacken)) {
			System.out.println(me.name());
		} else
			if (me.equals(MyEnum.AktionEssen)) {
				System.out.println("Aktion Essen");
			} else {
				System.out.println("unbeaknnte Aktion");
			}
	}

	public static void main(String[] args) {
		InternalEnum ie = new InternalEnum();
		ie.doSomething(MyEnum.AktionPacken);
		ie.doSomething(MyEnum.AktionEssen);
	}
}