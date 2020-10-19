package arithmeticOperationsString;
//Given two positive numbers calculate the minimum and maximum possible sums of two numbers. We are allowed to replace digit 5 with digit 6 and vice versa in either or both the given numbers.
//
//Examples :
//
//Input  : x1 = 645 x2 = 666
//Output : Minimum Sum: 1100 (545 + 555)
//         Maximum Sum: 1312 (646 + 666)
//
//Input: x1 = 5466 x2 = 4555
//Output: Minimum sum: 10010
//        Maximum Sum: 11132
public class Replace5with6 
{
	
	static void findMaxMinSum(String s1,String s2)
	{
		int max=0,min=0;
		//s1.replace returns a string and integer.parseint converts that string to integer
		max=Integer.parseInt(s1.replace('5','6'))+Integer.parseInt(s2.replace('5','6'));
		min=Integer.parseInt(s1.replace('6','5'))+Integer.parseInt(s2.replace('6','5'));
		System.out.println("Min and max are: "+min+" "+max);
	}
	public static void main(String args[])
	{
		String s1="645",s2="666";
		findMaxMinSum(s1,s2);
	}
}
//algo
//Since both numbers are positive, we always get maximum sum if replace 5 with 6 in both numbers.
//And we get minimum sum if we replace 6 with 5 in both numbers.