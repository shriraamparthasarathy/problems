package hashing;
//Given an array of n numbers and a positive integer k. The problem is to find k
//numbers with most occurrences, i.e., the top k numbers having the maximum frequency. 
//If two numbers have the same frequency then the larger number should be given preference. 
//The numbers should be displayed in decreasing order of their frequencies. It is assumed
//that the array consists of k numbers with most occurrences.
//
//Examples:
//
//Input: 
//arr[] = {3, 1, 4, 4, 5, 2, 6, 1}, 
//k = 2
//Output: 4 1
//Explanation:
//Frequency of 4 = 2
//Frequency of 1 = 2
//These two have the maximum frequency and
//4 is larger than 1.
//
//Input : 
//arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
//k = 4
//Output: 5 11 7 10
//Explanation: 
//Frequency of 5 = 3
//Frequency of 11 = 2
//Frequency of 7 = 2
//Frequency of 10 = 10
//These four have the maximum frequency and
//10 is largest among rest.
import java.util.HashMap;
import java.util.PriorityQueue;
public class KMaxOccurrences
{ 
	static void print_N_mostFrequentNumber(int[] arr, int n, int k) 
	{ 
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
		for (int i = 0; i < n; i++) 
		{ 
			hm.put(arr[i], hm.get(arr[i]) == null ? 1 : hm.get(arr[i]) + 1); 
		} 

		PriorityQueue<HashMap.Entry<Integer, Integer> > queue = 
		new PriorityQueue<>((a,b)->
		{
			if(a.getValue()>b.getValue())		//sorting based on the frequency 
				return -1;
			else if(a.getValue()<b.getValue())
				return 1;
			else								//if the frequency are same, we sort the key in descending order
			{
				if(a.getKey()<b.getKey())
					return 1;
				else if(a.getKey()>b.getKey())
					return -1;
				else 
					return 0;
			}
		}); 
 
		for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) 
			queue.add(entry); 


		for (int i = 0; i < k; i++) 
		{ 
			System.out.println(queue.poll().getKey()); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		int arr[] = { 3, 1, 4, 4, 5, 2, 6, 1 }; 
		int n = arr.length; 
		int k = 2; 
		print_N_mostFrequentNumber(arr, n, k); 
	} 
} 
//algo
//Create a Hashmap hm, to store key-value pair, i.e. element-frequency pair.
//Traverse the array from start to end.
//For every element in the array update hm[array[i]]++
//Store the element-frequency pair in a Priority Queue and create the Priority Queue, this takes O(n) time.
//Run a loop k times, and in each iteration remove the top of the priority queue and print the 
//element.