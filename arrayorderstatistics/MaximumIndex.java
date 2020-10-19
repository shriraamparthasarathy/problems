package arrayorderstatistics;

public class MaximumIndex 
{
	static int min(int a,int b)
	{
	 return a<b?a:b;
	}
	static int max(int a,int b)
	{
		return a>b?a:b;
	}
	static int findMaxIndexDifference(int a[])
	{
		int lmin[]=new int[a.length];
		int rmax[]=new int[a.length];
		lmin[0]=a[0];
		for(int i=1;i<a.length;i++)
		{
			lmin[i]=min(a[i],lmin[i-1]);
		}
		rmax[a.length-1]=a[a.length-1];
		for(int i=a.length-2;i>=0;i--)
		{
			rmax[i]=max(a[i],rmax[i+1]);
		}
		int maxdiff=-1,i=0,j=0;
		while(i<a.length&&j<a.length)
		{
			if(lmin[i]<rmax[j])
			{
				maxdiff=max(j-i,maxdiff);
				j++;
			}
			else
				i++;
		}
		return maxdiff;
	}
	public static void main(String[] args)
	{
		int a[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}; //34, 8, 10, 3, 2, 80, 30, 33, 1//1, 2, 3, 4, 5, 6//6, 5, 4, 3, 2, 1
		System.out.print("TheMaximum difference in index possible is: "+findMaxIndexDifference(a));
	}
}
