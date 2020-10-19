package ArrayRearrangement;
import java.util.Arrays;

public class EvenminimumOddmaximimElement 
{
	static void displayArray(int a[])
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	static void changeArray(int a[])
	{
		int min=0,maxind=a.length-1;
		int max=a[maxind]+1;
		for(int i=0;i<a.length;i++)
		{
			if(i%2==0)
			{
				a[i]+=(a[min]%max)*max;
				min++;
			}
			else
			{
				a[i]+=(a[maxind]%max)*max;
				maxind--;
			}
			
		}
		for(int i=0;i<a.length;i++)
			a[i]=a[i]/max;
		
	}
	public static void main(String[] args)
	{
		int a[]= {5, 8, 1, 4, 2, 9, 3, 7, 6 };
		Arrays.sort(a);
		changeArray(a);
		displayArray(a);
	}
}
