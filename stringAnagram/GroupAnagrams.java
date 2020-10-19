package stringAnagram;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
public class GroupAnagrams 
{
	static void printAnagrams(String arr[])
	{
		HashMap<String,ArrayList<String>> hm=new HashMap<>();
		for(String s:arr)
		{
			char ch[]=s.toCharArray();
			Arrays.sort(ch);
			String temp=new String(ch);
			if(hm.containsKey(temp))
				hm.get(temp).add(s);
			else
			{
				ArrayList<String> al=new ArrayList<>();
				al.add(s);
				hm.put(temp, al);
			}
		}
		for(String s: hm.keySet())
		{
			ArrayList<String> al=hm.get(s);
			if(al.size()>1)
				System.out.println(al);
		}
	}
	 public static void main(String[] args) 
	 { 
	  
	        // Driver program 
	        String arr[] = { "cat", "dog", "tac", "god", "act" }; 
	        printAnagrams(arr); 
	 } 
}
