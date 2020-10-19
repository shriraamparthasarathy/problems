package stringReverse;
//Given a string, that contains special character together with alphabets
//(‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.
//
//Examples:
//
//Input:   str = "a,b$c"
//Output:  str = "c,b$a"
//Note that $ and , are not moved anywhere.  
//Only subsequence "abc" is reversed
//
//Input:   str = "Ab,c,de!$"
//Output:  str = "ed,c,bA!$"
public class ReverseSpecial 
{
	static void reverse(char[] ch)
	{
		int l=0,r=ch.length-1;
		while(l<r)
		{
			if(!Character.isAlphabetic(ch[l]))
				l++;
			else if(!Character.isAlphabetic(ch[r]))
				r--;
			else
			{
				char t=ch[l];
				ch[l]=ch[r];
				ch[r]=t;
				l++;
				r--;
			}
		}
	}
	public static void main(String[] args)  
    { 
        String str = "a!!!b.c.d,e'f,ghi"; 
        char[] ch = str.toCharArray(); 
  
        System.out.println("Input string: " + str); 
        reverse(ch); 
        String revStr = new String(ch); 
  
        System.out.println("Output string: " + revStr); 
    } 
}
