package stringOccurrenceBased;
//Implement a space efficient algorithm to check First repeated character in a string 
//without using any additional data structure in one traversal. Use additional data structures
//like count array, hash, etc is not allowed.
//
//Examples :
//
//Input :  abcfdeacf
//Output : char = a, index= 6
public class FirstRepeatingCharacterWithoutextraDS 
{
	
	static int firstRepeated(String s)
	{
		int check=0;
		for(int i=0;i<s.length();i++)
		{
			int val=s.charAt(i)-'a';
			if((check&(1<<val))>0)
				return i;
			else
				check|=1<<val;
		}
		return -1;
	}
	public static void main(String args[]) 
    { 
        String s = "abcfdeacf"; 
        int i=firstRepeated(s); 
        if (i!=-1) 
           System.out.println("Char = "+ s.charAt(i) + "   and Index = "+i); 
        else
            System.out.println( "No repeated Char"); 
    }
}
//algo
//The idea is to use an integer variable and uses bits in its binary representation 
//to store whether a character is present or not. Typically an integer has at-least 32 bits
//and we need to store presence/absence of only 26 characters.