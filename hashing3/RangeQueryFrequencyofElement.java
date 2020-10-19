package hashing3;
import java.util.HashMap;
import java.util.ArrayList;
public class RangeQueryFrequencyofElement 
{
	static HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
	static int findFrequency(int arr[],int n,int left,int right,int key)
	{
		Object temp[]=hm.get(key).toArray();
		int lower=0; //find the lower bound after the left using binary search
		int upper=0; // find the upper bound before the right using binary search
		return upper-lower;
	}
	public static void main(String[] args) 
	{ 
		int arr[] = {2, 8, 6, 9, 8, 6, 8, 2, 11}; 
		int n = arr.length; 
		for(int i=0;i<n;i++)
		{
			if(!hm.containsKey(arr[i]))
			{
				ArrayList<Integer> v=new ArrayList<>();
				v.add(i+1);
				hm.put(arr[i], v);
			}
			else
			{
				ArrayList<Integer> v=hm.get(arr[i]);
				v.add(i+1);
				hm.put(arr[i], v);
			}
		}
		System.out.println(hm.toString());
		System.out.println("Frequency of 2 from 1 to 6 = " + 
			findFrequency(arr, n, 1, 6, 2)); 
	
		System.out.println("Frequency of 8 from 4 to 9 = " + 
			findFrequency(arr, n, 4, 9, 8)); 
		
	} 
}

