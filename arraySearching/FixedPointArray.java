package arraySearching;
//Input: arr[] = {-10, -5, 0, 3, 7}
//Output: 3  // arr[3] == 3 
//
//Input: arr[] = {0, 2, 5, 8, 17}
//Output: 0  // arr[0] == 0 
//
//
//Input: arr[] = {-10, -5, 3, 4, 7, 9}
//Output: -1  // No Fixed Point


class FixedPointArray
{
    static int findFixedpoint(int a[])//linear search
    {
        for(int i=0;i<a.length;i++)
            if(a[i]==i)
                return i;
        return -1;        
    }
    static int findFixedpointSorted(int a[])//binary search
    {
        int l=0,r=a.length-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(a[m]==m)
                return m;
            else if(m<a[m])
                r=m-1;
            else
                l=m+1;
        }
        return -1;
    }
    public static void main(String args[])
    {
        int a[] = {-10, -1, 0, 3, 10, 11, 30, 50, 100};
        System.out.println("The fixed point is: "+findFixedpoint(a));
        int b[] = {-10, -1, 0, 3 , 10, 11, 30, 50, 100};//sorted array
        System.out.println("The fixed point is: "+findFixedpointSorted(b));
    }
}
