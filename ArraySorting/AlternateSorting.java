package ArraySorting;
import java.util.Arrays;
public class AlternateSorting 
{
	static void alternateSort(int a[])
	{
		int n=a.length,i,j=n-1;
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		for(i=0;i<j;)
		{
			System.out.print(a[j--]+" ");
			System.out.print(a[i++]+" ");
		}
		if(n%2!=0)//if a.length is odd
			System.out.print(a[i]);
	}

	public static void main(String[] args) 
	{
		int a[]= {1, 12, 4, 6, 7, 10};
		System.out.println("The alternate sorted array is:");
		alternateSort(a);
		
	}

}
