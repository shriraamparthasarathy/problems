package stringPalindrome;

public class CheckPalindrome 
{
	static String isPalindrome(String str)
	{
		int l=0,r=str.length()-1;
		while(l<=r)
		{
			if(str.charAt(l)!=str.charAt(r))
				return "Not a palindrome";
			l++;
			r--;
		}
		return "Palindrome";
	}
	public static void main(String args[])
	{
		String str="malayalam";
		System.out.println(isPalindrome(str));
	}
}
