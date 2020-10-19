package arraySearching;
//Given an array of n integers, we need to find the no. of ways of choosing pairs with maximum difference.
//
//Examples:
//
//Input : a[] = {3, 2, 1, 1, 3}
//Output : 4
//Explanation:- Here, the maximum difference 
//you can find is 2 which is from (1, 3).
//No. of ways of choosing it:
// 1) Choosing the first and third elements,
// 2) Choosing the first and fourth elements,
// 3) Choosing the third and fifth elements,
// 4) Choosing the fourth and fifth elements.
//Hence ans is 4.
public class MaxDiffElements 
{
	static int findMaxDiffElements(int a[])
	{
		int minv=Integer.MAX_VALUE;
		int maxv=Integer.MIN_VALUE;
		int n=a.length;
		for(int i=0;i<a.length;i++)
		{
			minv=Math.min(minv, a[i]);
			maxv=Math.max(maxv, a[i]);
		}
		if(minv==maxv)
			return n*(n-1)/2;
		int c1=0,c2=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]==minv)
				c1++;
			if(a[i]==maxv)
				c2++;
		}
		return c1*c2;
	}
	public static void main(String args[])
	{
		int a[]={ 3, 2, 1, 1, 3 }; 
		System.out.println("The no of pairs is: "+findMaxDiffElements(a));
	}
}
//An efficient approach will be:
//
//Case I (if all the elements are equal): The ans is no. of ways of choosing 2 elements from a set of n elements nC2 which is n(n-1)/2.
//Case II (If all the elements are not equal) : The answer is product of count of no. of minimum elements(c1) and count of no. of maximum elements(c2), i.e., c1*c2
//filter_none