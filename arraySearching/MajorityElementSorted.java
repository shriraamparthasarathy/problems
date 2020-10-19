package arraySearching;



class MajorityElementSorted
{
    static int firstOccurenceBinarySearch(int a[],int x)
    {
        int l=0,r=a.length-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            
            //  Check if arr[mid] is the first occurrence of x. 
            //     arr[mid] is first occurrence if x is one of the following 
            //     is true: 
            //     (i)  mid == 0 and arr[mid] == x 
            //     (ii) arr[mid-1] < x and arr[mid] == x 
            
            if((m==0||a[m]>a[m-1])&&a[m]==x)
                return m;
            else if(x>a[m])
                l=m+1;
            else // not using else if(x<a[m]) since x might equal to a[m] but we have x in a[m-1] as well
                r=m-1;
        }
        return -1;
    }
    static boolean isMajorityElement(int a[],int x)
    {
        int i=firstOccurenceBinarySearch(a,x);
        if(i==-1)
            return false;
        if((i+a.length/2)<a.length&&(a[i+a.length/2]==x))
            return true;
        return false;    
        
    }
    
	public static void main (String[] args) 
	{
	    int a[] = {1, 2, 3, 3, 3, 3, 10},x=3;
	    if(isMajorityElement(a,x))
	        System.out.println("The element is present n/2 times.");
	   else 
	        System.out.println("The element is not present n/2 times.");
	}
}
