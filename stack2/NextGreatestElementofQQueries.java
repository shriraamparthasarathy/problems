package stack2;
import java.util.Stack;
//Given an array of n elements and q queries, for each query which has an index i, 
//find the next greater element and print its value. If there is no such greater element to its
//right then print -1.
//
//Examples:
//
//Input : arr[] = {3, 4, 2, 7, 5, 8, 10, 6} 
//        query indexes = {3, 6, 1}
//Output: 8 -1 7 
//Explanation : 
//For the 1st query index is 3, element is 7 and 
//the next greater element at its right is 8 
//
//For the 2nd query index is 6, element is 10 and 
//there is no element greater then 10 at right, 
//so print -1.
//
//For the 3rd query index is 1, element is 4 and
//the next greater element at its right is 7.
public class NextGreatestElementofQQueries
{
	static void NGE(int next[], int a[], int n) 
	{ 
	    Stack<Integer> s = new Stack<Integer>(); 	  
	    s.push(0); 
	    for (int i = 1; i < n; i++)  
	    { 
	        while (s.size() > 0)  
	        { 
	            int cur = s.peek(); 
	            if (a[cur] < a[i]) 
	            { 
	                next[cur] = a[i]; 
	                s.pop(); 
	            } 
	            else
	                break; 
	        }
	        s.push(i); 
	    } 

	    while (s.size() > 0)  
	    { 
	        int cur = s.peek();
	        next[cur] = -1; 
	        s.pop(); 
	    } 
	}
	public static void main(String[] args)  
	{ 
	    int arr[] = {3, 4, 2, 7,5, 8, 10, 6}; 
	    int n=arr.length;
	    int query[] = {3, 6, 1}; 
	    int next[] =new int[n];
	    NGE(next,arr,n);
	    for(int i : query)
	    	System.out.println(i+" -->"+next[i]);
	    
	}    
}
//algo
//find the result array of next greatest element program
//with the help of query element as index print the next element value
