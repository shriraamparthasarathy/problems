package stringSpacing;
//A String str is given which contains lowercase English letters and spaces. 
//It may contain multiple spaces. Get the first letter of every word and return the
//		result as a string. The result should not contain any space.
//
//Examples:
//
//Input : str = "geeks for geeks"
//Output : gfg
//
//Input : str = "happy   coding"
//Output : hc
public class WordsFirstLetter 
{
	static String firstLetterWord(String str)
	{
		String res="";
		boolean space=true;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
				space=true;
			else if(str.charAt(i)!=' '&& space==true)
			{
				space=false;
				res+=str.charAt(i);
			}
		}
		return res;
	}
	public static void main(String[] args)  
    { 
        String str = "geeks for geeks"; 
        System.out.println(firstLetterWord(str)); 
    } 
}
//algo
//1. Traverse string str. And initialize a variable v as true.
//2. If str[i] == ' '. Set v as true.
//3. If str[i] != ' '. Check if v is true or not.
//   a) If true, copy str[i] to output string and set v as false.
//   b) If false, do nothing.