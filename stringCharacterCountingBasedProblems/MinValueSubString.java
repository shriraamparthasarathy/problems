package stringCharacterCountingBasedProblems;

public class MinValueSubString 
{
	static String findMinimum(String str,String pat)
	{
		int l1=str.length(),l2=pat.length();
		int hash_str[]=new int[256],hash_pat[]=new int[256];
		int start=0,count=0,start_index=-1,minlen=Integer.MAX_VALUE;
		if(l1<l2)
		{
			System.out.println("No such window exist");
			return "";
		}	
		for(int i=0;i<l2;i++)
			hash_pat[pat.charAt(i)]++;
		for(int j=0;j<l1;j++)
		{
			hash_str[str.charAt(j)]++;
			if(hash_pat[str.charAt(j)]!=0&&(hash_str[str.charAt(j)]<=hash_pat[str.charAt(j)]))
				count++;
			if(count==l2)
			{
				while((hash_str[str.charAt(start)]>hash_pat[str.charAt(start)]))
				{
					hash_str[str.charAt(start)]--;
					start++;
				}
				int lenwindow=j-start+1;
				if(minlen>lenwindow)
				{
					minlen=lenwindow;
					start_index=start;
				}
			}
		}
		if(start_index==-1)
		{
			System.out.println("No such window exist");
			return "";
		}	
		return str.substring(start_index,start_index+minlen);
	}
	public static void main(String args[])
	{
		String str = "this is a test"; 
        String pat = "tist"; 
        System.out.println(findMinimum(str,pat));
	}
}
