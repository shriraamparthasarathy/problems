package arrayorderstatistics;

public class MinimumDistanceBetweenElements 
{
	static int min(int a,int b)
	{
		return a<b?a:b;
	}
	static int findMinimumDistance(int a[],int x,int y)
	{
		int mini_dist=Integer.MAX_VALUE,p=-1;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==x || a[i]==y)
			{
				if(p!=-1 && a[i]!=a[p])
					mini_dist=min(mini_dist,i-p);
				p=i;
					
			}
		}
		if(mini_dist==Integer.MAX_VALUE)
			return -1;
		else
			return mini_dist;
	}
	public static void main(String[] args)
	{
		int a[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3},x=3,y=6;
		System.out.print("The minimum distance between "+ x + " and "+ y+" is "+findMinimumDistance(a,x,y));
	}
}
