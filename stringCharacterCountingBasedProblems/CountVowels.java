package stringCharacterCountingBasedProblems;

public class CountVowels 
{
	static int isVowel(Character c)
	{
		c=Character.toUpperCase(c);
		return (c=='A'||c=='E'||c=='I'||c=='O'||c=='U')?1:0;
	}
	static int countVowels(String s,int n)
	{
		int res=0;
		for(int i=0;i<n;i++)
			if(isVowel(s.charAt(i))==1)
				res++;
		return res;
	}
	static int countVowelsRecurs(String s,int n)
	{
		if(n==1)
			return isVowel(s.charAt(n-1));
		return countVowelsRecurs(s,n-1) + isVowel(s.charAt(n-1));
	}
	public static void main(String args[]) 
    { 
        String str = "abc de"; 
        System.out.println(countVowels(str,str.length())); 
        System.out.println(countVowelsRecurs(str,str.length())); 
    } 
}
