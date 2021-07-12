package grundlagen.b5Arrays;

public class Template_02_CharArrays
{
	public static void main(String[] args)
	{
		char[] mein_name = {'C', 'h', 'r', 'i', 's'};
		System.out.println(mein_name);
		
		char[] name = ("Test").toCharArray();
		System.out.println(name);
		
		char[] pwd = ("PaSsW0rd").toCharArray();
		char[] umgewandelt = umwandelnByVal(pwd);
		System.out.println(umgewandelt);
		System.out.println(pwd);
		
		char[] umgewandelt2 = umwandelnByRef(pwd);	// VORSICHT: Seiteneffekt, da pwd in Funktion veraendert wird
		System.out.println(umgewandelt2);
		System.out.println(pwd);
		
	}
	
	public static char[] umwandelnByVal(char[] wort)
	{
		char[] erg = new char[wort.length];
		int diff = 'a' - 'A';
		
		for(int i = 0; i < wort.length; i++)
		{
			char temp = wort[i];
			if (temp >= 'A' && temp <= 'Z')
			{
				temp = (char)(temp + diff);
			}
			erg[i] = temp;
		}
		
		return erg;
	}
	
	public static char[] umwandelnByRef(char[] wort)
	{
		int diff = 'a' - 'A';
		
		for(int i = 0; i < wort.length; i++)
		{
			if (wort[i] >= 'A' && wort[i] <= 'Z')
			{
				wort[i] = (char)(wort[i] + diff);
			}
		}
		
		return wort;
	}
}