package ArrayRearrangement;
import java.util.*;
public class SortBasedOnOrderofAnotheArray 
{
	static Map<Integer,Integer> key= new HashMap<>();
	static void sortArray(Integer a1[],Integer a2[])
	{
		for(int i=0;i<a2.length;i++)
			key.put(a2[i], i);
		for(int i=0;i<a1.length;i++)
		{
			if(!key.containsKey(a1[i]))
				key.put(a1[i],a1.length);
		}
		System.out.println(Arrays.toString(a1));
		Arrays.sort(a1,(o1,o2)->{		// need integer object not int for comparator.compare method
			Integer k1=key.get(o1);
			Integer k2=key.get(o2);
			if(k1<k2)
				return -1;				// returning -1 for "NOT SWAPPING"
			if(k1>k2)
				return 1;				// returning 1 for "SWAPPING"
			if(k1.equals(k2)) 
			{
	            if (o1 < o2) 
	            	return -1;
	            else 
	            	return 1;
			}    
			return 0;
		});
		System.out.println(Arrays.toString(a1));
	}
	public static void main(String[] args)
	{
		Integer a1[]= {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8},a2[]= {2,1,8,3};
		sortArray(a1,a2);

	}
}
