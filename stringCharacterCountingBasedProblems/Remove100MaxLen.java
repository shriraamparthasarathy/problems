package stringCharacterCountingBasedProblems;
import java.util.ArrayList;
//given an input, we should remove all 100 only and find out the maximum length we removed..
//for example:
//1110000- we remove the first 100 -> 11(100)00->1100 since we still have an 100, remove it
//->1(100)-> 1.. the substring removed is 110000 which is of length 6
public class Remove100MaxLen 
{
	static class pair
	{
		char first;
		int second;
		pair(char first,int second)
		{
			this.first=first;
			this.second=second;
		}
	}
	static int longestNull(String s)
	{
		ArrayList<pair> arr=new ArrayList<>();
		int len=Integer.MIN_VALUE;
		arr.add(new pair('@',-1));//since array size will be same as final index value
		for(int i=0;i<s.length();i++)
		{
			arr.add(new pair(s.charAt(i),i));
			while(arr.size()>=3&&arr.get(arr.size()-3).first=='1'
					&&arr.get(arr.size()-2).first=='0'
					&&arr.get(arr.size()-1).first=='0')
			{
				arr.remove(arr.size()-3);
				arr.remove(arr.size()-2);
				arr.remove(arr.size()-1);
			}
			int t=i-arr.size()-1;
			len=Math.max(t, len);
		}
		return len;
	}
	 public static void main(String args[]) 
	    { 
	        System.out.println(longestNull("1011100000100")); 
	    }
}
//algo
//We can solve this problem using a container like vector in c++ or ArrayList in Java. 
//Below is the algorithm to solve this problem :
//
//Take a vector arr of pair type. Each element in arr stores two values character and
//it’s respective index in string.
//Store pair(‘@’,-1) as a base in arr. Take variable maxlen = 0 which stores the final result.
//Now one by one iterate for all characters in string, make pair of characters and it’s 
//respective index and store it in arr. In parallel also check the condition if after 
//inserting i’th character last three elements of ‘arr’ are making sub-string “100”.
//If sub-string exist then delete it from ‘arr’. Repeat this loop by number of times 
//till you are getting sub-string “100” in arr and make it null by deleting continuously.
//The difference of indexs of i’th character and index of last element currently present 
//in arr after deletion gives the length of sub-string that can be make null by continuous 
//deletion of sub-string “100”, update maxlen.
//filter_none