package stringSubsequenceandSubstring;
//Given a string, count number of subsequences of the form aibjck, i.e., it consists of i ’a’ characters, followed by j ’b’ characters, followed by k ’c’ characters where i >= 1, j >=1 and k >= 1.
//
//Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
//
//Expected Time Complexity: O(n)
//
//Examples:
//
//Input  : abbc
//Output : 3
//Subsequences are abc, abc and abbc
//
//Input  : abcabc
//Output : 7
//Subsequences are abc, abc, abbc, aabc
//abcc, abc and abc
public class AiBjCkSubsequence 
{
	static int countSubsequences(String s)
	{
		int a=0,b=0,c=0;
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch=='a')
				a+=a+1;
			else if(ch=='b')
				b+=b+a;
			else if(ch=='c')
				c+=c+b;
		}
		return c;
	}
	public static void main(String args[]) 
    { 
        String s = "abbc"; 
        System.out.println(countSubsequences(s)); 
    } 
}
//algo
//Going from left to right, keep track of the number of sequences until the current position, 
//which are of these three forms:
//1) a^i 
//2) a^i b^j 
//3) a^i b^j c^k 
//Suppose that these are stored in three variables a,b,c respectively.
//Whenever you see the character 'a', it can extend the strings of type 1, and also, 
//be the starting position for a string of type 1, so a+=(a+1),
//whenever you see a 'b', it can extend previous strings of type 1 and 2, so b+=(a+b),
//for 'c', it will extend all strings of type 2 and 3, so c+=(b+c).

