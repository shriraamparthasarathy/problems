package stringSubsequenceandSubstring;

public class LengthofLastWord 
{
	static int lengthOfLastWord(String s)
	{
		int l=0;
		boolean char_flag=false;
		for(int i=s.length()-1;i>=0;i--)
		{
			if(Character.isAlphabetic(s.charAt(i)))
			{
				char_flag=true;
				l++;
			}
			else
				if(char_flag==true)
					return l;
		}
		return l;
	}
	public static void main(String[] args) 
    { 
        String input = "Geeks For Geeks  "; 
        System.out.println("The length of last word is " + lengthOfLastWord(input)); 
    } 
}
