package ArraySorting;

import java.util.Arrays;
class PairsDifflessthanK
{
    static int findPairCount(int a[],int k)
    {
        Arrays.sort(a);
        int n=a.length,res=0;
        for(int i=0;i<n;i++)
        {
            int j=i+1;
            while(j<n&&a[j]-a[i]<k)
            {
                res++;
                j++;
            }
        }
        return res;
    }
	public static void main (String[] args) 
	{
		int a[]={1, 10, 4, 2},k=3;
		System.out.println("The number of pairs is: "+findPairCount(a,k));
	}
}
