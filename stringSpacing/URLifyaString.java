package stringSpacing;
//
//Write a method to replace all the spaces in a string with ‘%20’. 
//You may assume that the string has sufficient space at the end to hold the additional characters, 
//and that you are given the “true” length of the string.
//
//Examples:
//
//Input : "Mr John Smith", 13
//Output : Mr%20John%20Smith
//
//Input : "Mr John Smith   ", 13
//Output : Mr%20John%20Smith
public class URLifyaString 
{
	static String urlifyString(String str)
	{
		String res="";
		int i=str.length()-1;
		while(str.charAt(i)==' '&&i>=0)
			i--;
		for(;i>=0;i--)
		{
			if(str.charAt(i)==' ')
				res="%20"+res;
			else
				res=str.charAt(i)+res;
		}
		return res;
	}
	public static void main(String args[])
	{
		String str="Mr John Smith    ";
		str=urlifyString(str);
		System.out.println(str);
	}
}
