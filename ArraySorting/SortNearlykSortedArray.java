package ArraySorting;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Arrays;
public class SortNearlykSortedArray 
{

	static void sortArray(int a[],int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int index=0;
		for(int i=0;i<k+1;i++)
		{
			pq.add(a[i]);
		}
		for(int i=k+1;i<a.length;i++)
		{
			a[index++]=pq.poll();
			pq.add(a[i]);
		}
		Iterator<Integer> it=pq.iterator();
		while(it.hasNext())
			a[index++]=pq.poll();
	}
	public static void main(String[] args) 
	{
		int a[]= {6, 5, 3, 2, 8, 10, 9},k=3;
		sortArray(a,k);
		System.out.println("The sorted array is: "+ Arrays.toString(a));

	}

}
