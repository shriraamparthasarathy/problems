package stringCharacterCountingBasedProblems;
import java.util.Arrays;
public class NumberofUniquekCharSubstrings 
{
	static int countkDist(String s,int k)
	{
		int countarr[]=new int [26];
		int res=0,n=s.length();
		for(int i=0;i<n;i++)
		{
			int dist_count=0;
			Arrays.fill(countarr, 0);
			for(int j=i;j<n;j++)
			{
				countarr[s.charAt(j)-'a']++;
				if(countarr[s.charAt(j)-'a']==1)
					dist_count++;
				if(dist_count==k)
					res++;
			}
		}
		return res;
	}
	public static void main(String args[])
	{
		String ch = "abcbaa"; 
        int k = 3; 
        System.out.println("Total substrings with exactly " + k +" distinct characters : "+countkDist(ch, k)); 
	}
}
