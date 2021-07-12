package v02_mitEnums;

public enum MyEnum {
	AktionPacken, AktionEssen;
	
	public String Beschreibung() {
		String erg = "";
		if (this.equals(AktionEssen))
			erg = "Viel Essen tut gut!";
		if (this.equals(AktionPacken))
			erg = "Packen ist blöd - da wird er Rucksack so schwer!";
		return erg;
	}
}