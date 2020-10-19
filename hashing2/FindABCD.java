package hashing2;

//Given an array of distinct integers, find if there are two pairs (a, b) and (c, d) 
//such that a+b = c+d, and a, b, c and d are distinct elements. 
//If there are multiple answers, then print any of them.
////
//Example:
//
//Input:   {3, 4, 7, 1, 2, 9, 8}
//Output:  (3, 8) and (4, 7)
//Explanation: 3+8 = 4+7
//
//Input:   {3, 4, 7, 1, 12, 9};
//Output:  (4, 12) and (7, 9)
//Explanation: 4+12 = 7+9
//
//Input:  {65, 30, 7, 90, 1, 9, 8};
//Output:  No pairs found
import java.util.HashMap; 

class FindABCD 
{ 
	static class pair 
	{ 
		int first, second; 
		pair(int f,int s) 
		{ 
			first = f; second = s; 
		} 
	}

	boolean findPairs(int arr[]) 
	{ 
		HashMap<Integer,pair> map = new HashMap<Integer,pair>(); 
		int n=arr.length; 
		for (int i=0; i<n; ++i) 
		{ 
			for (int j=i+1; j<n; ++j) 
			{ 
				int sum=arr[i]+arr[j];
				if(map.containsKey(sum))
				{
					pair p=map.get(sum);
					System.out.println("("+arr[p.first]+", "+arr[p.second]+ 
							") and ("+arr[i]+", "+arr[j]+")");
					return true;
				}
				else
					map.put(sum, new pair(i,j));
			} 
		} 
		return false; 
	} 
	public static void main(String args[]) 
	{ 
		int arr[] = {3, 4, 7, 1, 2, 9, 8}; 
		FindABCD a = new FindABCD(); 
		if(a.findPairs(arr)==false)
			System.out.println("No such pairs found");
	} 
} 
//algo Time complexity of map insert and search is actually O(Log n) instead of O(1).
// so it is O(n^2 Log n).

//Loop i = 0 to n-1 :
//    Loop j = i + 1 to n-1 :
//        calculate sum
//        If in hash table any index already exist
//            Then print (i, j) and previous pair 
//            from hash table  
//        Else update hash table
//    EndLoop;
//EndLoop;
