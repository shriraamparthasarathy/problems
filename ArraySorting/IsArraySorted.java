package ArraySorting;

public class IsArraySorted
{

	static boolean isSortedIterat(int a[],int n)
	{
		if(n==0||n==1)
			return true;
		for(int i=0;i<n-1;i++)
			if(a[i]>a[i+1])
				return false;
		return true;
	}
	static boolean isSortedRecurs(int a[],int n)
	{
		if(n==0||n==1)
			return true;
		if(a[n-2]>a[n-1])
			return false;
		return isSortedRecurs(a,n-1);
	}
	public static void main(String[] args) 
	{
		int a[] = { 20, 23, 23, 45, 78, 88 };
		if(isSortedIterat(a,a.length))
			System.out.println("It is sorted");
		else
			System.out.println("It is not sorted");
		if(isSortedRecurs(a,a.length))
			System.out.println("It is sorted");
		else
			System.out.println("It is not sorted");
		

	}

}
