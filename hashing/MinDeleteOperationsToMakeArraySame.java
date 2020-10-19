package hashing;
//Given an array of n elements such that elements may repeat. We can delete any number
//of elements from the array. The task is to find a minimum number of elements to be 
//deleted from array to make it equal.
//
//Examples:
//
//Input  : arr[] = {4, 3, 4, 4, 2, 4}
//Output : 2
//After deleting 2 and 3 from array, array becomes 
//arr[] = {4, 4, 4, 4} 
//
//Input : arr[] = {1, 2, 3, 4, 5}
//Output: 4
//We can delete any four elements from array.
import java.util.HashMap;
public class MinDeleteOperationsToMakeArraySame
{
	static int minDelete(int arr[],int n)
	{
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			int value;
			if(!hm.containsKey(arr[i]))
				value=0;
			else
				value=hm.get(arr[i]);
			hm.put(arr[i], ++value);
		}	

		int maxfreq=Integer.MIN_VALUE;
		for(HashMap.Entry<Integer,Integer> entry:hm.entrySet())
		{
			if(entry.getValue()>maxfreq)
				maxfreq=entry.getValue();
		}
		return n-maxfreq;
	}
	public static void main(String args[])
	{
		int arr[] = { 4, 3, 4, 4, 2, 4 }; 
	    int n =arr.length;
	    System.out.println(minDelete(arr, n)); 
	}
}
//algo
//The approach is simple, we count frequency of each element in array, then find the frequency 
//of most frequent element in count array. Let this frequence be max_freq. To get the minimum
//number of elements to be deleted from array calculate n – max_freq where n is number of elements
//in given array.