package binaryHeap2;
import java.util.HashMap;
import java.util.PriorityQueue;
//Given an array arr[] containing n elements. The problem is to find maximum number of
//distinct elements (non-repeating) after removing k elements from the array.
//Note: 1 <= k <= n.
//
//Examples:
//
//Input : arr[] = {5, 7, 5, 5, 1, 2, 2}, k = 3
//Output : 4
//Remove 2 occurrences of element 5 and
//1 occurrence of element 2.
//
//Input : arr[] = {1, 2, 3, 4, 5, 6, 7}, k = 5
//Output : 2
//
//Input : arr[] = {1, 2, 2, 2}, k = 1
//Output : 1
public class MaximumDistinctAfterRemovingKElements
{ 

	static int maxDistinctNum(int[] arr, int n, int k) 
	{ 
			
			HashMap<Integer, Integer> map = new HashMap<>(); 

			PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->
			{   
	            if (o1 < o2) return 1;
	            if (o1 > o2) return -1;
	            return 0;
			}); 
			for (int i = 0; i < n; i++) 
			{ 
				if(map.containsKey(arr[i])) 
				{ 
					int val = map.get(arr[i]); 
					val++; 
					map.remove(arr[i]); 
					map.put(arr[i], val); 
				} 

				else
					map.put(arr[i], 1); 
			} 


			for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) 
			{ 
				pq.add(entry.getValue()); 
			} 

			while (k > 0) 
			{ 
				int temp = pq.poll(); 
				temp--; 
				if (temp > 0) 
					pq.add(temp); 
				k--; 
			} 

			int res = 0; 
			while (pq.size() != 0) 
			{ 
				pq.poll(); 
				res++; 
			} 

			return res; 
	} 

	public static void main(String args[]) 
	{ 
			int[] arr = { 5, 7, 5, 5, 1, 2, 2 }; 
			int n = arr.length; 
			int k = 3; 
			System.out.println("Maximum distinct elements = " + 
								maxDistinctNum(arr, n, k)); 
	} 
} 
//algo
//Approach: Following are the steps:
//
//Create a hash table to store the frequency of each element.
//Insert frequency of each element in a max heap.
//Now, perform the following operation k times. Remove an element from the max heap. Decrement 
//its value by 1. After this if element is not equal to 0, then again push the element in the 
//max heap.
//After the completion of step 3, the number of elements in the max heap is the required answer.