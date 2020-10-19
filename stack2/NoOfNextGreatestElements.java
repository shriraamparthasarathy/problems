package stack2;
import java.util.Stack;
//Given an array of n integers and q queries, print the number of next greater elements to the 
//right of the given index element.
//
//Examples:
//
//Input : a[] = {3, 4, 2, 7, 5, 8, 10, 6}  
//              q = 2 
//              index = 0, 
//              index = 5
//Output: 4 
//        1 
//Explanation: the next greater elements
//to the right of 3(index 0) are 4, 7, 8, 
//10. The next greater elements to the right
//of 8(index 5) are 10.
public class NoOfNextGreatestElements
{
	static void fillNext(int next[], int a[], int n) 
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
	                next[cur] = i; 
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
	static void count(int a[], int dp[],int n)
	{
		int next[]=new int[n];
		fillNext(next,a,n);
		for(int i=n-2;i>=0;i--)
		{
			if(next[i]==-1)
				dp[i]=0;
			else
				dp[i]=1+dp[next[i]];
		}
	}
	static int answerQuery(int dp[],int i)
	{
		return dp[i];
	}
	public static void main(String args[]) 
	{ 
	    int a[] = { 3, 4, 2, 7, 5, 8, 10, 6 }; 
	    int n = a.length; 
	  
	    int dp[] = new int[n]; 
	  
	    // calls the function to count the number 
	    // of greater elements to the right for 
	    // every element. 
	    count(a, dp, n); 
	  
	    // query 1 answered 
	    System.out.println(answerQuery(dp, 3)); 
	  
	    // query 2 answered 
	    System.out.println( answerQuery(dp, 6)); 
	      
	    // query 3 answered 
	    System.out.println( answerQuery(dp, 1) ); 
	  
	} 
}
//algo Time complexity: O(1) to answer a query. Auxiliary Space: O(n)
//Efficient approach is to store the next greater elements index using next 
//greater element in a next[] array. Then create a dp[] array that starts from n-2,
//as n-1th index will have no elements to its right and dp[n-1] = 0. While traversing
//from back we use dynamic programming to count the number of elements to the right where we
//use memoization as dp[next[i]] which gives us a count of the numbers to the right of the next
//greater element of the current element, hence we add 1 to it. If next[i]=-1 then we do not have
//any element to the right hence dp[i]=0. dp[index] stores the count of the number of next greater 
//elements to the right.