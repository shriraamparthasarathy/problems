package stringReverse;
//Write a program to Reverse the given string while preserving the position of spaces.
//
//Examples:
//
//Input  : "abc de"
//Output : edc ba
//
//Input : "intern at geeks"
//Output : skeegt an retni
//
//Input : "Help others"
//Output : sreh topleH
public class ReverseSpace 
{
	static char[] reverse(char[] ch)
	{
		int l=0,r=ch.length-1;
		while(l<r)
		{
			if(ch[l]==' ')
				l++;
			else if(ch[r]==' ')
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
		return ch;
	}
	public static void main(String[] args) 
    { 
		char ch[]="internship at geeks for geeks".toCharArray();
        String s=new String(reverse(ch)); 
        
        System.out.println(s);
        
    }
}
//algo similar to reverse with special characters