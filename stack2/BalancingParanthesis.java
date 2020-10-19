package stack2;
import java.util.Stack;
public class BalancingParanthesis 
{
	static boolean areParanthesisBalanced(String exp)
	{
		Stack<Character> s=new Stack<>();
		char x='\0';
		for(int i=0;i<exp.length();i++)
		{
			x=exp.charAt(i);
			System.out.println(x);
			if(x=='('|| x=='{' || x=='[')
				s.push(x);
			else if(s.isEmpty())
				return false;
			else
			{
				char t=s.pop();
				switch(x)
				{
					case '}':
						if(t!='{')
							return false;
						break;
					case ']':
						if(t!='[')
							return false;
						break;
					case ')':
						if(t!='(')
							return false;
						break;
				}
			}
		}
		return s.isEmpty();
	}
	public static void main(String[] args) 
    { 
        String expr = "([{}])"; 
        if (areParanthesisBalanced(expr)) 
            System.out.println("Balanced "); 
        else
            System.out.println("Not Balanced "); 
    } 
}
