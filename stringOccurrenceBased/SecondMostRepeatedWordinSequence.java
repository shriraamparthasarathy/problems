package stringOccurrenceBased;
import java.util.HashMap;
public class SecondMostRepeatedWordinSequence 
{
	static String secMostRepeated(String [] arr)
	{
		HashMap<String,Integer> hm=new HashMap<>();
		for(String s:arr)
		{
			if(hm.containsKey(s))
				hm.put(s,hm.get(s)+1);
			else
				hm.put(s,1);
		}
		if(hm.size()<2)
			return "Doest have atleast two repeated words";
		int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
		String t1="",t2="";
		for(String s:hm.keySet())
		{
			if(first<hm.get(s))
			{
				second =first;
				t2=t1;
				first=hm.get(s);
				t1=s;
			}
			else if(second < hm.get(s))
			{
				second=hm.get(s);
				t2=s;
			}
		}
		if(second<2)
			return "Doest have atleast two repeated words";
		else
			return t2;
		
	}
	public static void main(String[] args)  
    { 
        String arr[] = { "ccc", "aaa", "ccc", 
                         "ddd", "aaa", "aaa" }; 
        System.out.println(secMostRepeated(arr)); 
    }   
}
