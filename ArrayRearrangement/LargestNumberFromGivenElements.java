package ArrayRearrangement;
import java.util.*;
public class LargestNumberFromGivenElements
{
	static void findMax(Vector<String> arr)
	{
		Collections.sort(arr,new Comparator <String>()
		{
			@Override
			public int compare(String x,String y)
			{
				String XY= x+y;
				String YX=y+x;
				return XY.compareTo(YX)>0?-1:1;
			}
		});
		
//		equivalent lambda expression:
//		Collections.sort(arr,(x,y)->
//		{
//			String XY= x+y;
//			String YX=y+x;
//			return XY.compareTo(YX)>0?-1:1;
//		});
		for(Object s: arr)
		{
			System.out.print(s);
		}
	}
	public static void main(String[] args)
	{
		//String s[]= {"1", "34", "3", "98", "9", "76", "45", "4"};//"1", "34", "3", "98", "9", "76", "45", "4"
		Vector <String> arr = new Vector<String>();
		arr.add("1"); 
        arr.add("34"); 
        arr.add("3"); 
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");
		System.out.println("The maximum number formed is:");
		findMax(arr);
	}
}
