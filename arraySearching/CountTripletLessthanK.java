package arraySearching;
//Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).
//
//Examples:
//
//Input : arr[] = {-2, 0, 1, 3}
//        sum = 2.
//Output : 2
//Explanation :  Below are triplets with sum less than 2
//               (-2, 0, 1) and (-2, 0, 3) 
//
//Input : arr[] = {5, 1, 3, 4, 7}
//        sum = 12.
//Output : 4
//Explanation :  Below are triplets with sum less than 12
//               (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
//               (1, 4, 5)
import java.util.Arrays;
class CountTripletLessthanK
{
    static int findTripletSum(int a[],int sum)
    {
        int count=0,n=a.length;
        Arrays.sort(a);
        for(int i=0;i<n-2;i++)//since the last triplet will start in n-3
        {
           int j=i+1,k=n-1;
           while(j<k)
           {
                if(a[i]+a[j]+a[k]>=sum)
                    k--;
                else
                {
                    count+=(k-j);
                    j++;
                }
           }
        }
        return count;
    }
    public static void main(String args[])
    {
        int a[]={5, 1, 3, 4, 7};
        int sum=12;
        System.out.println("The number of triplets with sum less than given is: "+findTripletSum(a,sum));
    }
}
//algo:

//1) Sort the input array in increasing order.
//2) Initialize result as 0.
//3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all
//   triplets with arr[i] as first element.
//     a) Initialize other two elements as corner elements of subarray
//        arr[i+1..n-1], i.e., j = i+1 and k = n-1
//     b) Move j and k toward each other until they meet, i.e., while (j = sum), then do k--
//
//            // Else for current i and j, there can (k-j) possible third elements
//            // that satisfy the constraint.
//            (ii) Else Do ans += (k - j) followed by j++ 

//time complexity O(n^2) you sort the array before you begin solving for the triplets. You are adding NOT multiplying O(nlogn) and O(n2) . This turns out to be O(n2) upon dropping the constant.
//space complxity O(1)