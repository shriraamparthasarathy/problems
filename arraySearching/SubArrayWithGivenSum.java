package arraySearching;
//Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
//Ouptut: Sum found between indexes 2 and 4
//Sum of elements between indices
//2 and 4 is 20 + 3 + 10 = 33
//
//Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
//Ouptut: Sum found between indexes 1 and 4
//Sum of elements between indices
//1 and 4 is 4 + 0 + 0 + 3 = 7
//
//Input: arr[] = {1, 4}, sum = 0
//Output: No subarray found
//There is no subarray with 0 sum


class SubArrayWithGivenSum
{
    static void findSubarray(int a[],int x)
    {
        int sum=a[0],start=0;
        for(int i=1;i<=a.length;i++)
        {
            while(sum>x&&start<i-1)
            {
                sum-=a[start];
                start++;
            }
            if(sum==x)
            {
                System.out.println("The subarray is between: "+start+" and "+(i-1));
                return;
            }
            if(i<a.length)
                sum+=a[i];
        }
        System.out.println("No subarray");
    }
	public static void main (String[] args) 
	{
		 int a[]={15, 2, 4, 8, 9, 5, 10, 23  },x=23;
		 findSubarray(a,x);
		
	}
}
//algo
//Create three variables, l=0, sum = 0
//Traverse the array from start to end.
//Update the variable sum by adding current element, sum = sum + array[i]
//If the sum is greater than the given sum, update the variable sum as sum = sum – array[l], and update l as, l++.
//If the sum is equal to given sum, print the subarray and break the loop.
//filter_none
