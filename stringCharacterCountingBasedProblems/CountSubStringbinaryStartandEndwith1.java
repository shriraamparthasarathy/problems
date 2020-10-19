package stringCharacterCountingBasedProblems;
//Given a binary string, count number of substrings that start and end with 1. For example, 
//if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
public class CountSubStringbinaryStartandEndwith1 
{
	static int countSubStr(String s,int n)
	{
		int count=0;
		for(int i=0;i<n;i++)
			if(s.charAt(i)=='1')
				count++;
		return count*(count-1)/2;
	}
	 public static void main(String[] args)  
	 { 
	    String str = "00100101"; 
	    int n = str.length(); 
	    System.out.println(countSubStr(str, n)); 
	 } 
}
//algo
//It basically states the number of way you can choose two 1. 
//This will enable you to put anything in between and hence you get all nC2 possible substring.