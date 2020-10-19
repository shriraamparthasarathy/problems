package hashing;

import java.util.HashSet; 

class TwoSum
{ 
	static boolean printpairs(int arr[], int sum) 
	{ 
		HashSet<Integer> s = new HashSet<Integer>(); 
		boolean flag=false;
		for (int i = 0; i < arr.length; ++i) 
		{ 
			int temp = sum - arr[i]; 

			if (s.contains(temp)) 
			{ 
				System.out.println("Pair with given sum "+ sum + " is (" + arr[i]+ ", " + temp + ")"); 
				flag=true;
			} 
			s.add(arr[i]); 
		} 
		return flag;
	} 
 
	public static void main(String[] args) 
	{ 
		int A[] = { 1, 4, 45, 6, 10, 8 }; 
		int n = 16; 
		if(!printpairs(A, n))
			System.out.println("No pair found");
	} 
} 

