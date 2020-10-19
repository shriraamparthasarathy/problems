package ArrayRearrangement;

public class SortArrayof0s1s2s 
{
	static void sortArray(int a[])
	{
	    int c1=0,c2=0,c3=0;
	    for(int i=0;i<a.length;i++)
	    {
	        switch(a[i])
	        {
	            case 0: 
	                c1++;
	                break;
	            case 1:
	                c2++;
	                break;
	            case 2:
	                c3++;
	                break;
	        }
	    }
	    int i=0;
	    while(c1>0)
	    {
	        a[i++]=0;
	        c1--;
	    }
	    while(c2>0)
	    {
	        a[i++]=1;
	        c2--;
	    }
	    while(c3>0)
	    {
	        a[i++]=2;
	        c3--;
	    }
	}
	public static void main(String[] args)
	{
		int[] a = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		sortArray(a);
		for(int i: a)
			System.out.print(i+" ");

	}
}
