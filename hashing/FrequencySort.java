package hashing;
import java.util.HashMap;
public class FrequencySort 
{
	static class pair
	{
		int occur;
		int freq;
		pair(int occur,int freq)
		{
			this.occur=occur;
			this.freq=freq;
		}
	}
	static void sortByFrequency(int arr[],int n)
	{
		HashMap<Integer,pair>hm=new HashMap<>();
		
	}
	public static void main(String args[])
	{
		int arr[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 }; 
		int n=arr.length;
	    sortByFrequency(arr, n); 
	}
}
