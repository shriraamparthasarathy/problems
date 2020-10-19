package hashing;


import java.util.HashMap; 

class CumulativeFrequencyinUnSortedArray 
{ 
	static void countFreq(int[] a, int n) 
	{ 

		HashMap<Integer,Integer> hm = new HashMap<>(); 
		for (int i = 0; i < n; i++) 
			hm.put(a[i], hm.get(a[i]) == null ? 
					1 : hm.get(a[i]) + 1); 

//		SortedMap<Integer, Integer> st = new TreeMap<>(); 
//
//		for (HashMap.Entry<Integer,Integer> x : hm.entrySet()) 
//		{ 
//			st.put(x.getKey(), x.getValue()); 
//		} 

		int cumul = 0; 

		for (HashMap.Entry<Integer,Integer> x : hm.entrySet()) 
		{ 
			cumul += x.getValue(); 
			System.out.println(x.getKey() + " " + cumul); 
		} 
	} 


	public static void main(String[] args) 
	{ 
		int[] a = { 1, 3, 2, 4, 2, 1 }; 
		int n = a.length; 
		countFreq(a, n); 
	} 
} 

