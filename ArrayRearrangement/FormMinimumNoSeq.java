package ArrayRearrangement;
import java.util.Stack;
public class FormMinimumNoSeq 
{
	public static void PrintMinNumberForPattern(String s)
    {
        String res="";
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<=s.length();i++)
        {
            st.push(i+1);
            if(i==s.length()||s.charAt(i)=='I')
            {
                while(!st.isEmpty())
                {
                    res+=st.peek();
                    st.pop();
                }
            }
        }
        System.out.println(res);
    }
	public static void main (String[] args) 
	{
        PrintMinNumberForPattern("IDID"); 
        PrintMinNumberForPattern("I"); 
        PrintMinNumberForPattern("DD"); 
        PrintMinNumberForPattern("II"); 
        PrintMinNumberForPattern("DIDI"); 
        PrintMinNumberForPattern("IIDDD"); 
        PrintMinNumberForPattern("DDIDDIID");	
	}
}
