package hashing3;
//Given an array of n elements. The task is to count the total number of indices (i, j) 
//such that arr[i] = arr[j] and i != j
//
//Examples :
//
//Input : arr[] = {1, 1, 2}
//Output : 1
//As arr[0] = arr[1], the pair of indices is (0, 1)
//
//Input : arr[] = {1, 1, 1}
//Output : 3
//As arr[0] = arr[1], the pair of indices is (0, 1), 
//(0, 2) and (1, 2)
//
//Input : arr[] = {1, 2, 3}
//Output : 0

import java.util.HashMap; 

class CountEqualIndexPair
{ 

	public static int countPairs(int arr[], int n) 
	{ 
		HashMap<Integer,Integer> hm = new HashMap<>(); 
		for(int i = 0; i < n; i++) 
		{ 
		if(hm.containsKey(arr[i])) 
			hm.put(arr[i],hm.get(arr[i]) + 1); 
		else
			hm.put(arr[i], 1); 
		} 
		int ans=0; 
		for(HashMap.Entry<Integer,Integer> it : hm.entrySet()) 
		{ 
			int count = it.getValue(); 
			ans += (count * (count - 1)) / 2; 
		} 
		return ans; 
	} 

	public static void main(String[] args) 
	{ 
		int arr[] = new int[]{1, 2, 3, 1}; 
		System.out.println(countPairs(arr,arr.length)); 
	} 
} 
// algo
// The idea is to count the frequency of each number and then find the number of pairs with 
// equal elements. Suppose, a number x appears k times at index i1, i2,….,ik. Then pick any 
// two indexes ix and iy which will be counted as 1 pair. Similarly, iy and ix can also be pair.
// So, choose nC2 is the number of pairs such that arr[i] = arr[j] = x.