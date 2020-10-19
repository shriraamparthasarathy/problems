package stringOccurrenceBased;

public class MostRepeatingCharacter 
{
	static int MAX_CHAR=256;
	static char getMaxOccuringChar(String str)
	{
		int count[]=new int[MAX_CHAR];
		for(int i=0;i<str.length();i++)
			count[str.charAt(i)]++;
		int maxvalue=Integer.MIN_VALUE;
		char maxchar=' ';
		for(int i=0;i<str.length();i++)
		{
			if(count[str.charAt(i)]>maxvalue)
			{
				maxvalue=count[str.charAt(i)];
				maxchar=str.charAt(i);
			}
		}
		return maxchar;
	}
	public static void main(String[] args) 
    { 
        String str = "sample string"; 
        System.out.println("Max occurring character is " + 
                            getMaxOccuringChar(str)); 
    } 
}
