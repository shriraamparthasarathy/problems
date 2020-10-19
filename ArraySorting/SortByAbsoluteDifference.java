package ArraySorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
public class SortByAbsoluteDifference 
{
	
	static void rearrangeArray2(int[] arr, int n, int d) 
	{ 
	        ArrayList<Integer> a=new ArrayList<>();
	        for(int i=0;i<n;i++)
	            a.add(arr[i]);
			Collections.sort(a,(Integer o1,Integer o2)->
			{
			    if(Math.abs(o1-d) > Math.abs(o2-d))
                    return 1;
                else if(Math.abs(o1-d) < Math.abs(o2-d))
                    return -1;
                else
                    return 0;
			});
			for(int i=0;i<n;i++)
	            arr[i]=a.get(i);
	}
	static void rearrangeArray(int a[],int n,int x)
	{
		TreeMap<Integer, ArrayList<Integer>> tm=new TreeMap<>();
		for(int i=0;i<n;i++)
		{
			int diff=Math.abs(x-a[i]);
			if(tm.containsKey(diff))
			{
				ArrayList<Integer> al=tm.get(diff);
				al.add(a[i]);
				tm.put(diff,al);
			}
			else
			{
				ArrayList<Integer> al=new ArrayList<>();
				al.add(a[i]);
				tm.put(diff,al);
			}
		}
		int index=0;
		for(Map.Entry<Integer,ArrayList<Integer>> entry:tm.entrySet())
		{
			ArrayList<Integer> al=tm.get(entry.getKey());
			for(int i=0 ;i<al.size();i++)
				a[index++]=al.get(i);
		}
	}
	public static void main(String[] args) 
	{
		int[] a = {10, 5, 3, 9 ,2}; 
        int n = a.length; 
        int x = 7; 
        rearrangeArray(a,n,x);// nlog n time
        //rearrangeArray2(a,n,x);n^2 time
        System.out.println(Arrays.toString(a));

	}

}
