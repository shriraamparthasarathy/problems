package stringOccurrenceBased;
//Given a string of both uppercase and lowercase alphabets, the task is to print the string 
//with alternate occurrences of any character dropped(including space and consider upper and
//		lowercase as same).
//
//Examples:
//
//Input : It is a long day Dear.
//Output : It sa longdy ear.
//Print first I and then ignore next i.
//Similarly print first space then 
//ignore next space.
//
//
//Input : Geeks for geeks
//Output : Geks fore
public class StringIgnorance 
{
	static void printStringAlternate(String str)
	{
		int count[]=new int[122];
		String s=str.toLowerCase();
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(++count[ch]%2!=0)
				System.out.print(str.charAt(i));
		}
		System.out.println();
	}
	public static void main (String[] args)  
    { 
        String str1 = "Geeks for geeks"; 
        String str2 = "It is a long day Dear"; 
        printStringAlternate(str1); 
        printStringAlternate(str2); 
    } 
}
//algo
//As we have to print characters in alternate manner, so start traversing the string and
//perform following two steps:-
//
//Increment the count of occurrence of current character in a hash table.
//Check if the count becomes odd, then print the current character, else not.