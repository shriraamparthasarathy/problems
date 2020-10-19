package ArraySorting;
//Sort the array of size n.
//For the 1st element of array its min absolute difference is calculated using the 2nd array element.
//For the last array element its min absolute difference is calculated using the 2nd last array element.
//For the rest of the array elements, 1 <= i <= n-2, minimum absolute difference for an element at index i is calculated as: minAbsDiff = min( abs(arr[i] – arr[i-1]), abs(ar[i] – arr[i+1]) ).
import java.util.Arrays;
class MinAbsoluteDiff 
{
    static int minimum(int x,int y)
    {
        return x<y?x:y;
    }
    static int findMiniAbsDiff(int a[])
    {
        int sum=0,n=a.length;
        Arrays.sort(a);
        if(n==1)
            return a[0];
        sum+=a[1]-a[0];
        sum+=a[n-1]-a[n-2];
        for(int i=1;i<n-1;i++)
            sum+=minimum((a[i]-a[i-1]),(a[i+1]-a[i]));
        return sum;    
    }
	public static void main (String[] args) 
	{
	    int a[] = {5, 10, 1, 4, 8, 7};
		System.out.println("Sum of mini abs diff: "+findMiniAbsDiff(a));
	}
}