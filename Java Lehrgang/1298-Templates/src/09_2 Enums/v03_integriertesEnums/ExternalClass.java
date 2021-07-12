package v03_integriertesEnums;

import v03_integriertesEnums.InternalEnum.MyEnum;


public class ExternalClass {

	public static void main(String[] args) {
		InternalEnum ie = new InternalEnum();
		ie.doSomething(MyEnum.AktionPacken);
		ie.doSomething(InternalEnum.MyEnum.AktionEssen);
		ie.doSomething(MyEnum.AktionEssen);
	}

}
