package stringOccurrenceBased;
import java.util.HashMap; 
//Given an array of words find the most occurring word in it
//
//Examples:
//
//Input : arr[] = {"geeks", "for", "geeks", "a", 
//                "portal", "to", "learn", "can",
//                "be", "computer", "science", 
//                 "zoom", "yup", "fire", "in", 
//                 "be", "data", "geeks"}
//Output : Geeks 
//"geeks" is the most frequent word as it 
//occurs 3 times
class FrequentElement { 


	static String findWord(String[] arr) 
	{ 
		HashMap<String, Integer> hs = new HashMap<String, Integer>(); 

		for (int i = 0; i < arr.length; i++) { 
			if (hs.containsKey(arr[i]))  
				hs.put(arr[i], hs.get(arr[i]) + 1); 
			else 
				hs.put(arr[i], 1);  
		} 
		String key = ""; 
		int value = 0; 

		for (String s: hs.keySet()) { 
			if (hs.get(s) > value) { 
				value = hs.get(s); 
				key = s; 
			} 
		} 
		return key; 
	} 

	public static void main(String[] args) 
	{ 
		String arr[] = { "geeks", "for", "geeks", "a", 
						"portal", "to", "learn", "can", "be", 
						"computer", "science", "zoom", "yup", 
						"fire", "in", "be", "data", "geeks" }; 
		String sol = findWord(arr); 
		System.out.println(sol); 
	} 
} 
//algo: using hashmap