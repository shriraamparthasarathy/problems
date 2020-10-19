package ArrayRearrangement;
import java.util.HashMap;

public class DistinctAdjacentArrayElement 
{
	public static void AdjacentDistinct(int a[],int n)
	{
		HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		int t,max=0;
		for(int i=0;i<n;i++)
		{
			if(h.containsKey(a[i]))
			{
				t=h.get(a[i])+1;
				h.put(a[i], t);
			}
			else
				h.put(a[i], 1);
		}
		for(int i=0;i<n;i++)
		{
			if(max<h.get(a[i]))
				max=h.get(a[i]);
		}
		if(max<=(n+1)/2)
			System.out.println("Yes");
		else
			System.out.println("NO");
	}
	public static void main(String[] args)
	{
		int arr[]= {7,7,7,7},n=4;
		AdjacentDistinct(arr,n);
	}
}
