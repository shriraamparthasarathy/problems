package ArraySorting;

import java.util.Arrays;
class SortArraysWithEquation
{
    static void sortwithEqn(int a[],int A,int B,int C)
    {
        int n=a.length;
        int t[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=A*a[i]*a[i]+B*a[i]+C;
        int index=-1,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {    
            if(a[i]>max)
            {
                max=a[i];
                index=i;
            }    
        }
        int l=0,r=n-1,k=0;
        while(l<index && r>index)
        {
            if(a[l]<a[r])
                t[k++]=a[l++];
            else
                t[k++]=a[r--];
        }
        while(l<index)
            t[k++]=a[l++];
        while(r>index)    
            t[k++]=a[r--];
        t[n-1]=max;    
        for(int i=0;i<n;i++)
            a[i]=t[i];
    }
	public static void main (String[] args) 
	{
		int a[]= {-21 ,-15, 12, 13, 14 }; 
       		 int A = -6, B =-7, C = 2; 
		sortwithEqn(a,A,B,C);
		System.out.println("The sorted and merged array: "+Arrays.toString(a));
	}
}