package arraySearching;

//1) Initialize leftsum  as 0
//2) Get the total sum of the array as sum
//3) Iterate through the array and for each index i, do following.
//  a)  Update sum to get the right sum.  
//        sum = sum - arr[i] 
//    // sum is now right sum
//  b) If leftsum is equal to sum, then return current index. 
//    // update leftsum for next iteration.
//  c) leftsum = leftsum + arr[i]
//4) return -1 
//// If we come out of loop without returning then
//// there is no equilibrium index
class EquilibriumIndex
{
 static int findEquilibrium(int a[])
 {
     int sum=0,leftsum=0;
     for(int i=0;i<a.length;i++)
         sum+=a[i];
     for(int i=0;i<a.length;i++)
     {
         sum-=a[i];
         if(sum==leftsum)
             return i;
         leftsum+=a[i];    
     }
     return -1;
 }
	public static void main (String[] args) 
	{
	    int a[] = { -7, 1, 5, 2, -4, 3, 0 };
	    System.out.println("The first Equilibrium Index is at: "+findEquilibrium(a));
	}
}