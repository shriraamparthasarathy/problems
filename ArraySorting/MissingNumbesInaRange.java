package ArraySorting;
import java.util.HashSet;
class MissingNumbesInaRange 
{
    static void findMissingNumbersHashing(int a[])
    {
        HashSet<Integer> hs=new HashSet<>();
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        int flag=-1;
        for(int i=0;i<a.length;i++)
        {
            hs.add(a[i]);
            if(max<a[i])
                max=a[i];
            if(min>a[i])
                min=a[i];
        }    
        for(int i=min+1;i<max;i++)
        {
            if(!hs.contains(i))
            {
                System.out.print(i+" ");
                flag=0;
            }    
        }
        if(flag==-1)
            System.out.print("0");
            
    }
	public static void main (String[] args) 
	{
		int a[]={4,3,5,8,10};
		findMissingNumbersHashing(a);
	}
}