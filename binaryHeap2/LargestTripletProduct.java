package binaryHeap2;
import java.util.PriorityQueue;
//Given a stream of integers represented as arr[]. For each index i from 0 to n-1, 
//print the multiplication of largest, second largest, third largest element of the 
//subarray arr[0…i]. If i < 2 print -1.
//
//Examples:
//
//Input : arr[] = {1, 2, 3, 4, 5}
//Output :-1
//        -1
//         6
//         24
//         60
//Explanation : for i = 2 only three elements 
//are there {1, 2, 3} so answer is 6. For i = 3
//largest three elements are {2, 3, 4} their
//product is 2*3*4 = 24 ....so on    
public class LargestTripletProduct 
{
	static void LargestTripletMultiplication(int arr[],int n)
	{
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->
		{   
		    if (o1 < o2) return 1;
		    if (o1 > o2) return -1;
		    return 0;
		}); 
		for(int i=0;i<n;i++)
		{
			pq.add(arr[i]);
			if(pq.size()<3)
			{
				System.out.print(-1+" ");
			}
			else
			{
				int x=pq.poll();
				int y=pq.poll();
				int z=pq.poll();
				System.out.print((x*y*z)+" ");
				pq.add(x);
				pq.add(y);
				pq.add(z);
			}
		}
	}
	public static void main(String[] args) 
	{ 
	    int arr[] = { 1, 2, 3, 4, 5 }; 
	    int n = arr.length; 
	    LargestTripletMultiplication(arr, n); 
	} 
}
//algo
//We will use priority queue here.
//
//Insert arr[i] in the priority queue
//As the top element in priority queue is largest so pop it and store it as x.
//Now the top element in the priority queue will be the second largest element in 
//subarray arr[0…i] pop it and store as y. Now the top element is third largest element in
//subarray arr[0…i] so pop it and store it as z.
//Print x*y*z
//Reinsert x, y, z.