package hashing2;
//Given an array of n integers. The task is to find the difference of first and 
//last index of each distinct element so as to maximize the difference.
//
//Examples:
//
//Input : {2, 1, 3, 4, 2, 1, 5, 1, 7}
//Output : 6
//Element 1 has its first index = 1
//and last index = 7
//Difference = 7 - 1 = 6
//Other elements have a smaller first and last
//index difference
//
//Input : {2, 2, 1, 1, 8, 8, 3, 5, 3} 
//Output : 2
//Maximum difference is for indexes of element 3.
import java.util.HashMap; 
public class MaxDiffOfElementsIndexWise
{ 

	static class Element 
	{ 
		int first; 
		int second; 

		Element()
		{
			this.first=0;
			this.second=0;
		}
		Element(int first, int second) 
		{ 
			this.first = first; 
			this.second = second; 
		} 
	} 
	static int maxDiffIndices(int[] arr)
	{ 
		int n = arr.length; 
		int maxDiffIndex = Integer.MIN_VALUE; 
		HashMap<Integer, Element> map = new HashMap<Integer, Element>(); 

		for(int i=0;i<n;i++)
		{
			if(!map.containsKey(arr[i]))
			{
				Element e=new Element();
				e.first=i;
				map.put(arr[i], e);
			}
			else
			{
				Element e=map.get(arr[i]);
				e.second=i;
			}
		}
		for(HashMap.Entry<Integer,Element> entry:map.entrySet())
		{
			Element e=entry.getValue();
			if((e.second-e.first)>maxDiffIndex)
				maxDiffIndex=e.second-e.first;
		}

		return maxDiffIndex; 
	} 
	public static void main(String[] args) 
	{ 

		int arr[]={2, 1, 3, 4, 2, 1, 5, 1, 7}; 
		System.out.println("Maximum Difference= "+ maxDiffIndices(arr)); 
	} 
}		 
//algo
//Traverse the input array from left to right.
//For each distinct element map its first and last index in the hash table.
//Traverse the hash table and calculate the first and last index difference for each element.
//Accordingly update the max_diff.