package arraySearching;

//Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
//Output : 4
//Explanation: The frequency of 4 is 5 which is greater
//than the half of the size of the array size. 

//Input : {3, 3, 4, 2, 4, 4, 2, 4}
//Output : No Majority Element
//Explanation: There is no element whose frequency is
//greater than the half of the size of the array size.
//algo: Using Moore’s Voting Algorithm: explanation below program
class MajorityElement
{
 static boolean isMajor(int a[],int candidate)
 {
     int count=0;
     for(int i=0;i<a.length;i++)
     {
         if(a[i]==candidate)
             count++;
     }
     if(count>a.length/2)
         return true;
     else
         return false;
 }
 
 static int findCandidate(int a[])
 {
     int index=0,count=1;
     for(int i=1;i<a.length;i++)
     {
         if(a[i]==a[index])
             count++;
         else
             count--;
         if(count==0)
         {
             index=i;
             count=1;
         }    
     }
     return a[index];
 }
 
 
 static void findMajorityElement(int a[])
 {
     int candidate=findCandidate(a);
     if(isMajor(a,candidate))
         System.out.println("The majority element is: "+candidate);
     else
         System.out.println("No majority element");
     
 }
	public static void main (String[] args) 
	{
	    int a[] = {3, 3, 4, 2, 4, 4, 2, 4, 4};
	    findMajorityElement(a);
	}
}

//algo
//Loop through each element and maintains a count of majority element, and a majority index, maj_index
//If the next element is same then increment the count if the next element is not same then decrement the count.
//if the count reaches 0 then changes the maj_index to the current element and set the count again to 1.
//Now again traverse through the array and find the count of majority element found.
//If the count is greater than half the size of the array, print the element
//Else print that there is no majority element