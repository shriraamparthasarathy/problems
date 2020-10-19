package ArraySorting;
import java.util.Arrays;
//This task is simple and O(m+n) if we are allowed to use extra space. But it becomes really complicated when extra space is not allowed and doesn’t look possible in less than O(m*n) worst case time.
//
//The idea is to begin from last element of ar2[] and search it in ar1[]. If there is a greater element in ar1[], then we move last element of ar1[] to ar2[]. To keep ar1[] and ar2[] sorted, we need to place last element of ar2[] at correct place in ar1[]. We can use Insertion Sort type of insertion for this. Below is algorithm:
public class Merge2sortedArraysO1space 
{

	static void merge(int a1[],int a2[])
	{
		int m=a1.length,n=a2.length;
		for(int i=n-1;i>=0;i--)
		{
			int last=a1[m-1],j;
			for(j=m-2;a2[i]<a1[j] && j>=0;j--)
				a1[j+1]=a1[j];
			if(j!=m-2||a2[i]<last)
			{
				a1[j+1]=a2[i];
				a2[i]=last;
			}	
		}
	}
	public static void main(String[] args) 
	{
		int a1[] = {1, 5, 9, 10, 15, 20}; 
	    int a2[] = {2, 3, 8, 13};
	    merge(a1,a2);
	    System.out.println("The arrays after merging:");
	    System.out.println("Array 1: "+Arrays.toString(a1));
	    System.out.println("Array 2: "+Arrays.toString(a2));

	}

}
