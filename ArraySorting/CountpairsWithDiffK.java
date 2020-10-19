package ArraySorting;

import java.util.Arrays;
import java.util.HashSet;
public class CountpairsWithDiffK 
{
	static int findCountDiffHash(int a[],int k)
	{
		HashSet<Integer> hs=new HashSet<>();
		int count=0;
		for(int i:a)
			hs.add(i);
		for(int i:a)
			if(hs.contains(i+k))
				count++;
		return count;
	}
	static int findCountDiff(int a[],int k)
	{
		Arrays.sort(a);
		int l=0,r=0,count=0;
		while(r<a.length)
		{
			if(a[r]-a[l]==k)
			{
				count++;
				l++;
				r++;
			}
			else if(a[r]-a[l]>k)
				l++;
			else
				r++;
		}
		return count;
	}
	public static void main(String[] args)
	{
		int a[]= {1, 5, 3, 4, 2},k=3;//1,2,3,4,5
		System.out.println("The count is: "+findCountDiff(a,k));
		System.out.println("The count is: "+findCountDiffHash(a,k));

	}

}
