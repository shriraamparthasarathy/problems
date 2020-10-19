package stringOccurrenceBased;
import java.util.HashMap;
//Given a string, Find the 1st repeated word in a string
//
//Examples:
//
//Input : "Ravi had been saying that he had been there"
//Output : had
//
//Input : "Ravi had been saying that"
//Output : No Repetition
//
//Input : "he had had he"
//Output : he
public class FirstRepeatedWordinString 
{

	static class CountIndex
	{
		int index, count;
		CountIndex(int index)
		{
			this.count=1;
			this.index=index;
		}
		private void incCount()
		{
			this.count++;
		}
	}
	static HashMap<String,CountIndex> hm=new HashMap<>();//for all the alphabets
	static void getCharCount(String str)
	{
		String t="";
		int n=str.length();
		for(int i=0;i<n;i++)
		{
			char ch=str.charAt(i);
			if(ch==' ')
			{	
				if(hm.containsKey(t))
					hm.get(t).incCount();

				else
					hm.put(t,new CountIndex(i));
				t="";
			}
			else
				t+=ch;
		}
		//to put the last word
		if(str.charAt(n-1)!=' ')
			if(hm.containsKey(t))
				hm.get(t).incCount();
			else
				hm.put(t,new CountIndex(n-1));
	}
	static String firstRepeating(String str)
	{
		getCharCount(str);
		int res=Integer.MAX_VALUE;
		String resString="";
		for(String s: hm.keySet())
		{
			if(hm.get(s).count!=1 && res>hm.get(s).index)
			{
				res=hm.get(s).index;
				resString=s;
			}
		}	
		return resString==""?("NoRepeat"):resString;
	}
	public static void main(String[] args) 
    { 
        String str="Ravi had been saying that he had been there";
        String first=firstRepeating(str);
        if(first=="NoRepeat")
        	System.out.println("No repeated words");
        else
        	System.out.println(first);
    }
}