package hashing;


import java.util.HashMap; 

class KthDistinctElement 
{ 

	static int printKDistinct(int arr[], int n, int k) 
	{ 
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			if(!hm.containsKey(arr[i]))
				hm.put(arr[i],1);
			else
				hm.put(arr[i],hm.get(arr[i])+1);
		}
		int distinct=0;
		for(int i:arr)
		{
			if(hm.get(i)==1)
				distinct++;
			if(distinct==k)
				return i;
		}
		return -1;
	} 

	public static void main (String[] args) 
	{ 
		int ar[] = {1, 2, 1, 3, 4, 2}; 
		int n = ar.length; 
		System.out.println(printKDistinct(ar, n, 2)); 
	} 
} 
