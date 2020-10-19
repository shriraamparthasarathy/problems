package stack2;
import java.util.Stack;
public class InfixtoPostfix 
{
	static int pref(char ch)
	{
		switch(ch)
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	static String infixToPostfix(String exp)
	{
		Stack<Character> s=new Stack<>();
		char c='\0';
		String res="";
		for(int i=0;i<exp.length();i++)
		{
			c=exp.charAt(i);
			if(Character.isLetterOrDigit(c))
				res+=c;
			else if(c=='(')
				s.push(c);
			else if(c==')')
			{
				while(!s.isEmpty()&&s.peek()!='(')
					res+=s.pop();
				if(s.isEmpty())
					return "Invalid Expression";
				else
					s.pop();
			}
			else
			{
				while(!s.isEmpty()&&pref(c)<=pref(s.peek()))
				{
					if(c=='(')
						return "Invalid Expression";
					res+=s.pop();
				}
				s.push(c);
			}
		}
		while(!s.empty())
		{
			if(c=='(')
				return "Invalid Expression";
			res+=s.pop();
		}
		return res;
	}
	public static void main(String[] args)  
	{
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
		System.out.println(infixToPostfix(exp)); 
	} 
}
//algo
//1. Scan the infix expression from left to right.
//2. If the scanned character is an operand, output it.
//3. Else,
//…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty or the stack contains a ‘(‘ ), push it.
//…..3.2 Else, Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator. After doing that Push the scanned operator to the stack. (If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)
//4. If the scanned character is an ‘(‘, push it to the stack.
//5. If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered, and discard both the parenthesis.
//6. Repeat steps 2-6 until infix expression is scanned.
//7. Print the output
//8. Pop and output from the stack until it is not empty.