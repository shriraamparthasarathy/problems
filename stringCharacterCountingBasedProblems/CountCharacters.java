package stringCharacterCountingBasedProblems;

public class CountCharacters 
{
	static void count(String s)
	{
		int upper=0,lower=0,number=0,special=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
				upper++;
			else if(s.charAt(i)>='a'&&s.charAt(i)<='z')
				lower++;
			else if(s.charAt(i)>='0'&&s.charAt(i)<='9')
				number++;
			else
				special++;
		}
		System.out.println("Uppercase: "+upper);
		System.out.println("Lowercase: "+lower);
		System.out.println("Numbers: "+number);
		System.out.println("Symbols: "+special);
	}
	public static void main(String args[])
	{
		String s="#GeeKs01fOr@gEEks07";
		count(s);
	}
}
