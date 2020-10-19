package ArrayRearrangement;

public class SortBinaryNumber 
{
	static void sortArraybinary(int a[])
    {
        for(int start=0,end=a.length-1;start<end;)
        {
            if(a[start]==1&&a[end]==0)
            {
                a[start]=0;
                a[end]=1;
            }
            if(a[start]==0)
                start++;
            if(a[end]==1)
                end--;
        }
    }
    public static void main(String args[])
    {
        int a[]={0, 1, 0, 1, 1, 1};
        sortArraybinary(a);
        for(int i:a)
            System.out.print(i+" ");
    }
}
