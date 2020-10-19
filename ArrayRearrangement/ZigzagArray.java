package ArrayRearrangement;

public class ZigzagArray 
{
	static void zigZag(int a[])
    {
        int t;
        boolean f=true;
        for(int i=0;i<a.length-1;i++)
        {
            if(f)
            {
                if(a[i]>a[i+1])
                {
                    t=a[i];
                    a[i]=a[i+1];
                    a[i+1]=t;
                }
            }
            else
            {
                if(a[i]<a[i+1])
                {
                    t=a[i];
                    a[i]=a[i+1];
                    a[i+1]=t;
                }
            }
            f=!f;
        }
    }
    public static void main(String args[])
    {
        int a[]={4, 3, 7, 8, 6, 2, 1};
        zigZag(a);
        for(int i=0;i<a.length;i++)
         System.out.print(a[i]+" ");
    }
}
