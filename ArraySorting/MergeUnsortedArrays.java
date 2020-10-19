package ArraySorting;

import java.util.Arrays;
class MergeUnsortedArrays
{
    static void arraysSortandMerge(int a[],int b[],int res[])
    {
        int i=0,j=0,k=0;
        Arrays.sort(a);
        Arrays.sort(b);
        while(i<a.length&&j<b.length)
        {
            if(a[i]<b[j])
            {
                res[k]=a[i];
                i++;
            }
            else
            {
                res[k]=b[j];
                j++;
            }
            k++;
        }
        while(i<a.length)
        {
            res[k]=a[i];
            k++;
            i++;
        }
        while(j<b.length)
        {
            res[k]=b[j];
            k++;
            j++;
        }
    }
	public static void main (String[] args) 
	{
		int a[] = { 10, 5, 15 }; 
        int b[] = { 20, 3, 2, 12 }; 
		int res[]=new int[a.length+b.length];
		arraysSortandMerge(a,b,res);
		System.out.println("The sorted and merged array: "+Arrays.toString(res));
	}
}
