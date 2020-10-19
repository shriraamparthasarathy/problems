package stringSubsequenceandSubstring;
import java.util.Stack;
public class LengthofLongestValidParanthesis 
{
	static int findMaxLen(String str)
	{
		int n=str.length();
		int res=0;
		Stack<Integer> s=new Stack<>();
		s.push(-1);
		for(int i=0;i<n;i++)
		{
			int top=s.peek();
			if(top!=-1&&str.charAt(top)=='('&&str.charAt(i)==')')
			{
				s.pop();
				res=Math.max(res, i-s.peek());
			}
			else
				s.push(i);
			
		}
		return res;
	}
	public static void main(String[] args)  
    { 
        String str = "((()()"; 
        System.out.println(findMaxLen(str)); 
       
        str = ")))))"; 
        System.out.println(findMaxLen(str)); 
       
    } 
}
