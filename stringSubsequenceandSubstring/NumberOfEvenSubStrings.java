package stringSubsequenceandSubstring;
//Given a string of digits 0 – 9. The task is to count number of substrings which when convert into integer form an even number.
//
//Examples :
//
//Input : str = "1234".
//Output : 6
//"2", "4", "12", "34", "234", "1234" 
//are 6 substring which are even.
//
//Input : str = "154".
//Output : 3
//
//Input : str = "15".
//Output : 0

public class NumberOfEvenSubStrings 
{
	static int evenNumSubstring(String s)
	{
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			if((s.charAt(i)-'0')%2==0)
				count+=i+1;
		}
		return count;
	}
	public static void main(String args[]) 
    { 
          
        String str= "1234"; 
          
        System.out.println(evenNumSubstring(str)); 
    } 
}
//algo
//For a number to be even, substring must end wit an even digit. We find all the even digits 
//in the string and for each even digit, count the number of substrings ending with it.
//Now, observe that the number of substrings will be index of that even digit plus one.
//filter_none