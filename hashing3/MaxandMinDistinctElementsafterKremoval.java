package hashing3;
//incomplete... solution contradicts the question
import java.util.HashMap;
import java.util.PriorityQueue;

class MaxandMinDistinctElementsafterKremoval
{ 
 
	static int maxDistinctNum(int[] arr, int n, int k) 
	{ 

			HashMap<Integer, Integer> map = new HashMap<>(); 
			PriorityQueue<Integer> pq =new PriorityQueue<>((o1,o2)->
			{
				if(o1>02)
					return -11;
				else if(o1<o2)
					return 1;
				else
					return 0;
			});  
			for (int i = 0; i < n; i++)
			{ 
				if(map.containsKey(arr[i]))
				{ 
					int val = map.get(arr[i]); 
					val++; 
					map.remove(arr[i]); 
					map.put(arr[i], val); 
				} 

				else
					map.put(arr[i], 1); 
			} 
			for (HashMap.Entry<Integer, Integer> entry : map.entrySet())  
				pq.add(entry.getValue());  
			while (k > 0) 
			{ 
				int temp = pq.poll(); 
				temp--; 
				if (temp > 0) 
					pq.add(temp); 
				k--; 
			} 
			int res = 0; 
			while (pq.size() != 0) 
			{ 
				pq.poll(); 
				res++; 
			} 

			return res; 
	} 
	static int minDistinctNum(int arr[], int n, int mi) 
    { 
  
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>(); 
        int count = 0; 
        int size = 0; 
  
        for (int i = 0; i < n; i++) 
        { 
            if (!m.containsKey(arr[i])) 
            { 
                m.put(arr[i], 1); 
                size++; 
            } 
 
            else m.put(arr[i], m.get(arr[i]) + 1); 
        } 
        System.out.println(m.toString());
        for (HashMap.Entry<Integer, Integer> mp:m.entrySet()) 
        { 
            if (mp.getKey() <= mi) 
            { 
                mi -= mp.getKey(); 
                count++; 
                System.out.println(m.toString());
            } 
            else return size - count; 
        } 
  
        return size - count; 
    } 
	public static void main(String args[]) 
	{ 
			int[] arr = {  2, 4, 1, 5, 3, 5, 1, 3 }; 
			int n = arr.length; 
			int k = 2; 
			System.out.println("Maximum distinct elements = " +maxDistinctNum(arr, n, k));  
			System.out.println("Maximum distinct elements = " +minDistinctNum(arr, n, k)); 
	} 
} 

