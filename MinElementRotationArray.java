package githubprograms;

public class MinElementRotationArray 
{

	public static void main(String[] args) 
	{
		int a[]= {5,6,1,2,3,4};
		int n=a.length;
		int low=0,high=n-1;
		while(low<high)
		{
			int mid=low + (high-low)/2;
			//eg array 2 1
			if(a[mid]==a[high])
				high--;
			//eg array 3 4 5 1 2 
			else if(a[mid]>a[high])
				low=mid+1;
			//eg array 5 6 1 2 3 4
			else
				high=mid;
		}
		System.out.println("The minimum is :"+a[high]);
		
	}

}
