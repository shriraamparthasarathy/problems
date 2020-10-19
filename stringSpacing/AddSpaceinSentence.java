package stringSpacing;

public class AddSpaceinSentence 
{
	static boolean isUpper(char ch)
	{
		return ch>='A'&&ch<='Z';
	}
	static String amendSentence(String s)
	{
		String res="";
		res+=isUpper(s.charAt(0))?(char)(s.charAt(0)+32):s.charAt(0);
		for(int i=1;i<s.length();i++)
		{
			if(isUpper(s.charAt(i)))
			{
				res+=' ';
				res+=(char)(s.charAt(i)+32);
			}
			else
				res+=s.charAt(i);
				
		}
		return res;
	}
	 public static void main (String[] args)  
	    { 
	        String str ="BruceWayneIsBatman"; 
	        System.out.println(amendSentence(str)); 
	    } 
}
