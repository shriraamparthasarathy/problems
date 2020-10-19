package bitAlgorithms;

public class SingleOccurrenceElement
{
	static int findOneOccurrence(int a[],int n)
	{
		int res=0;
		for(int i=0;i<32;i++)
		{
			int sum=0;
			int x=1<<i;
			for(int j=0;j<n;j++)
			{
				if((a[j]&x)>0)
					sum++;
			}
			if(sum%3==1)
				res|=x;
		}
		return res;
	}
	public static void main(String args[])
	{
		int a[]={12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
		System.out.println("The element that occurs once is: "+findOneOccurrence(a,a.length));
	}
}
//algo: time complexity O(n) space O(1)
// We can sum the bits in same positions for all the numbers and take modulo with 3. 
// The bits for which sum is not multiple of 3, are the bits of number with single occurrence.
//Let us consider the example array {5, 5, 5, 8}. The 101, 101, 101, 1000
//Sum of first bits%3 = (1 + 1 + 1 + 0)%3 = 0;
//Sum of second bits%3 = (0 + 0 + 0 + 0)%0 = 0;
//Sum of third bits%3 = (1 + 1 + 1 + 0)%3 = 0;
//Sum of fourth bits%3 = (1)%3 = 1;
//Hence number which appears once is 1000