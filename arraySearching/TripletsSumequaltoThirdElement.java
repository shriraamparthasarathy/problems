package arraySearching;

//Given an array of integers you have to find three numbers such that sum of two elements equals the third element.

//Examples:

//Input : {5, 32, 1, 7, 10, 50, 19, 21, 2}
//Output : 21, 2, 19

//Input : {5, 32, 1, 7, 10, 50, 19, 21, 0}
//Output : no such triplet exist
import java.util.Arrays;

class TripletsSumequaltoThirdElement 
{
 static boolean isTripletSumEqual(int a[])
 {
     int i,j,k,n=a.length;
     Arrays.sort(a);
     for(i=n-1;i>0;i--)
     {
         j=0;
         k=i-1;
         while(j<k)
         {
             if(a[j]+a[k]==a[i])
             {
                 System.out.println("Triplet:"+a[j]+" "+a[k]+" "+a[i]);
                 return true;
             }    
             else if(a[j]+a[k]<a[i])
                 j++;
             else    
                 k--;
         }        
     }
     return false;
 }
	public static void main (String[] args) 
	{
		int a[]={ 5, 32, 1, 7, 10, 50, 19, 21, 2 }; 
		if(!isTripletSumEqual(a))
		    System.out.println("No such triplets exist");
	}
}

//algo: space complexity O(1) time complexity O(n^2) 
//Sort the given array first.
//Start fixing the greatest element of three from back and traverse the array to find other two numbers which sum upto the third element.
//Take two pointers j(from front) and k(initially i-1) to find the smallest of the two number and from i-1 to find the largest of the two remaining numbers
//If the addition of both the numbers is still less than A[i], then we need to increase the value of the summation of two numbers, thereby increase the j pointer, so as to increase the value of A[j] + A[k].
//If the addition of both the numbers is more than A[i], then we need to decrease the value of the summation of two numbers, thereby decrease the k pointer so as to decrease the overall value of A[j] + A[k].