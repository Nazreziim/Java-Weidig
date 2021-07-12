package v02_mitEnums;

public class WithEnum {

	public void doSomething(MyEnum me) {
		/*
		if (me.ordinal() == 0) {
			System.out.println("Aktion Packen");
		} else if (me.ordinal() == 1) {
			System.out.println("Aktion Essen");
		} else {
			System.out.println("unbeaknnte Aktion");
		}
		*/
		if (me.equals(MyEnum.AktionPacken)) {
			System.out.println(me.name());
		} else if (me.equals(MyEnum.AktionEssen)) {
			System.out.println(me.Beschreibung());
		} else {
			System.out.println("unbeaknnte Aktion");
		}
	}

	public static void main(String[] args) {
		WithEnum we = new WithEnum();
		we.doSomething(MyEnum.AktionPacken);
		we.doSomething(MyEnum.AktionEssen);
//		we.doSomething(3);
	}
}