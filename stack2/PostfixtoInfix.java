package stack2;
import java.util.Stack;
public class PostfixtoInfix 
{
	static String getInfix(String exp)
	{
		Stack<String> s=new Stack<>();
		char c='\0';
		for(int i=0;i<exp.length();i++)
		{
			c=exp.charAt(i);
			if(Character.isLetterOrDigit(c))
				s.push(c+"");
			else
			{
				String op1=s.pop();
				String op2=s.pop();
				s.push('('+ op2 + c + op1 + ')');
			}
		}
		return s.peek();
	}
	public static void main(String args[]) 
	{ 
	    String exp = "ab*c+"; 
	    System.out.println( getInfix(exp)); 
	}
}
//algo
//1.While there are input symbol left
//…1.1 Read the next symbol from the input.
//2.If the symbol is an operand
//…2.1 Push it onto the stack.
//3.Otherwise,
//…3.1 the symbol is an operator.
//…3.2 Pop the top 2 values from the stack.
//…3.3 Put the operator, with the values as arguments and form a string.
//…3.4 Push the resulted string back to stack.
//4.If there is only one value in the stack
//…4.1 That value in the stack is the desired infix string.