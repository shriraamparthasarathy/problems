package arraySearching;

//Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.
//Examples:


//Input: arr[] = {3, 1, 3}
//Output: Missing = 2, Repeating = 3
//Explanation: In the array, 
//2 is missing and 3 occurs twice 

//Input: arr[] = {4, 3, 6, 2, 1, 1}
//Output: Missing = 5, Repeating = 1

class MissingandRepeating 
{
 static void findMissingandRepeating(int a[])
 {
     System.out.print("Repeating element: ");
     for(int i=0;i<a.length;i++)
     {
         int abs=Math.abs(a[i]);
         if(a[abs-1]>0)
             a[abs-1]*=-1;
         else
             System.out.print(abs+" ");
     }
     System.out.print("\nThe missing element is: ");
     for(int i=0;i<a.length;i++)
     {
         if(a[i]>0)
             System.out.print((i+1)+" ");
     }
 }
 
	public static void main (String[] args) 
	{
		int a[]={7, 3, 4, 5, 5, 6, 2};
		findMissingandRepeating(a);
	}
}
//algo: Use elements as Index and mark the visited places: complextiy O(n) space: O(1)//modifies the value
//alternate solution: Using hashmap time complextiy O(n) and space O(n)

//Traverse the array. While traversing, use the absolute value of every element as an index and
//make the value at this index as negative to mark it visited. 
//If something is already marked negative then this is the repeating element.
//To find missing, traverse the array again and look for a positive value.
