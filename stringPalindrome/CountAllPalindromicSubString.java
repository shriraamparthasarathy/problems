package stringPalindrome;
//Given a string, the task is to count all palindrome substring in a given string.
//Length of palindrome substring is greater then or equal to 2.
//
//Examples:
//Input : str = "abaab"
//Output: 3
//Explanation : 
//All palindrome substring are :
// "aba", "aa", "baab" 
//
//Input : str = "abbaeae"
//Output: 4
//Explanation : 
//All palindrome substring are : 
//"bb", "abba", "aea", "eae":
public class CountAllPalindromicSubString 
{
	static int countPS(String str)
	{
		StringBuffer sb;
		String temp=new String();
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<=str.length();j++)
			{
				temp=str.substring(i, j);
				if(temp.length()>=2)
				{
					sb=new StringBuffer(temp);
					sb.reverse();
					if(temp.compareTo(sb.toString())==0)
						count++;
				}
			}
		}
		return count;
	}
	public static void main(String args[]) throws Exception { 
        // Declare and initialize the string 
        String str = "abbaeae"; 
        // Call the method 
        System.out.println(countPS(str)); 
    } 
}
//algo
//Iterate the loop twice for substring, get the substring of a string using substring() method.
//Reverse the substring using StringBuffer Class method reverse()
//Check for palindrome with substring and reverse substring
//If it is palindrome increment the count and return the count at last
//filter_none