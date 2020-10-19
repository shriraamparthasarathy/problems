package binaryHeap2;
//Given an array of n positive integers. We are required to write a program to print 
//the minimum product of k integers of the given array.
//
//Examples:
//
//Input : 198 76 544 123 154 675
//         k = 2
//Output : 9348
//We get minimum product after multiplying
//76 and 123.
//
//Input : 11 8 5 7 5 100
//        k = 4
//Output : 1400
import java.util.PriorityQueue; 

class MinProductofKIntegers 
{ 
	public static int minProduct(int[] arr, int n, int k) 
	{ 
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		for (int i = 0; i < n; i++) 
			pq.add(arr[i]); 
		int count = 0, ans = 1; 
		while(pq.isEmpty() == false && count < k) 
		{ 
			ans = ans * pq.element(); 
			pq.remove(); 
			count++; 
		} 
		
		return ans; 
	} 
	public static void main(String args[])
	{ 
		int arr[] = {198, 76, 544, 123, 154, 675}; 
		int k = 2; 
		int n = arr.length; 
		System.out.print("Minimum product is " + 
						minProduct(arr, n, k)); 
	} 
} 
//algo
//The idea is simple, we find the smallest k elements and print multiplication of them.
//In below implementation, we have used simple Heap based approach where we insert array elements
//into a min heap and then find product of top k elements.