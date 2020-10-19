package arraySearching;


//Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number in O(n) time & constant space.
//Examples :

//Input : arr = {1, 2, 3, 2, 3, 1, 3}
//Output : 3

//Input : arr = {5, 7, 2, 7, 5, 2, 5}
//Output : 5

class FindOddnumberoftimesaNumberOccur 
{
 
 static int getOddOccurrence(int a[])
 {
     int res=0;
     for(int i=0;i<a.length;i++)
         res=res^a[i];
     return res;    
 }
	public static void main (String[] args) 
	{
		int a[]={2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2}; 
		System.out.println(getOddOccurrence(a));
	}
}
//algo: XOR time complextiy O(n) space: O(1)
//XOR property is X^(Y^Z)=X^(Z^Y)=Y^(Z^X)=....similarly other 3 combinations. Thus, extending that property to the above sequence, we get
//A^A^A^B^B^B^B^C^C^D^D. This simplifies to A.
