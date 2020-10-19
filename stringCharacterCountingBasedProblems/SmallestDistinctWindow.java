package stringCharacterCountingBasedProblems;
import java.util.Arrays; 
public class SmallestDistinctWindow 
{
	static String findMinimum(String str)
	{
		int n=str.length(),dist_count=0;
		int hash_str[]=new int[256];
		boolean[] visited = new boolean[256]; 
	    Arrays.fill(visited, false); 
	    for (int i = 0; i < n; i++) 
	    { 
	    	if (visited[str.charAt(i)] == false) 
	    	{ 
	    		visited[str.charAt(i)] = true; 
	            dist_count++; 
	        } 
	    } 		
		int start=0,count=0,start_index=-1,minlen=Integer.MAX_VALUE;

		for(int j=0;j<n;j++)
		{
			hash_str[str.charAt(j)]++;
			if(hash_str[str.charAt(j)]==1)
				count++;
			if(count==dist_count)
			{
				while(hash_str[str.charAt(start)]>1)
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
		return str.substring(start_index,start_index+minlen);
	}
	public static void main(String args[])
	{
		String str = "aabcbcdbca";
        System.out.println(findMinimum(str));
	}
}
