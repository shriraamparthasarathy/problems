package stringOccurrenceBased;
//Given a string, a character, and a count, the task is to print the string 
//after the specified character has occurred count number of times.Print “Empty string” in 
//case of any unsatisfying conditions.(Given character is not present, or present but less than
//		given count, or given count completes on last index). If given count is 0, then given 
//character doesn’t matter, just print the whole string.
//
//Examples:
//
//Input  :  str = "This is demo string" 
//          char = i,    
//          count = 3
//Output :  ng
//
//Input :  str = "geeksforgeeks"
//         char = e, 
//         count = 2
//Output : ksforgeeks
public class PrintStringAfterSpecifiedCharacterOccurrence 
{
	static String printString(String str,char ch,int k)
	{
		int count=0,i=0;
		for(i=0;i<str.length();i++)
		{
			if(str.charAt(i)==ch)
				count++;
			if(count==k)
				break;
		}
		return str.substring(i+1);
	}
	public static void main(String[] args) 
    { 
        String str = "geeks for geeks"; 
        System.out.println(printString(str, 'e', 2)); 
    } 
}
