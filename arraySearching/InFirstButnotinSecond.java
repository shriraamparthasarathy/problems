package arraySearching;

//Given two arrays which are duplicates of each other except one element, that is one element from one of the array is missing, we need to find that missing element.

//Examples:

//Input:  arr1[] = {1, 4, 5, 7, 9}
//      arr2[] = {4, 5, 7, 9}
//Output: 1
//1 is missing from second array.

//Input: arr1[] = {2, 3, 4, 5}
//    arr2[] = {2, 3, 4, 5, 6}
//Output: 6
//6 is missing from first array.

class InFirstButnotinSecond 
{
 static void findLostElement(int a1[],int a2[])
 {
     int res=0;
     for(int i=0;i<a1.length;i++)
         res=res^a1[i];
     for(int i=0;i<a2.length;i++)
         res=res^a2[i];
     if(res==0)
         System.out.println("No missing element");
     else
         System.out.println("Missing element is:"+ res);
 }
 
	public static void main (String[] args) 
	{
		int a1[] = { 4, 1, 5, 9, 7 }; 
     int a2[] = { 7, 5, 9, 4 }; 
		findLostElement(a1,a2);
	}
}
//algo: XOR time complextiy O(n) space: O(1)
//XOR property is X^(Y^Z)=X^(Z^Y)=Y^(Z^X)=....similarly other 3 combinations. Thus, extending that property to the above sequence, we get
//A^A^A^B^B^B^B^C^C^D^D. This simplifies to A.
