package stringSubsequenceandSubstring;
//Given a integer represented as a string, we need to get the sum of all possible substrings of this string.
//
//Examples:
//
//Input  : num = “1234”
//Output : 1670
//Sum = 1 + 2 + 3 + 4 + 12 + 23 +
//       34 + 123 + 234 + 1234 
//    = 1670
//
//Input  : num = “421”
//Output : 491
//Sum = 4 + 2 + 1 + 42 + 21 + 421 = 491
public class SumofAllSubStringsinaGivenNumber 
{
	static int sumOfSubstrings(String s)
	{
		int res=0,cur=0,prev=0;
		prev=s.charAt(0)-'0';
		res=prev;
		for(int i=1;i<s.length();i++)
		{
			cur=(i+1)*(s.charAt(i)-'0') + 10*prev;
			prev=cur;
			res+=cur;
		}
		return res;
	}
	public static void main(String[] args) 
    { 
        String num = "1234"; 
  
        System.out.println(sumOfSubstrings(num)); 
    } 
}
//algo: O(n) O(1)
//We can solve this problem using dynamic programming. We can write summation of all
//substrings on basis of digit at which they are ending in that case,
//Sum of all substrings = sumofdigit[0] + sumofdigit[1] + sumofdigit[2] … + sumofdigit[n-1]
//		where n is length of string.
//
//Where sumofdigit[i] stores sum of all substring ending at ith index digit, in above example,
//Example : num = "1234"
//sumofdigit[0] = 1 = 1
//sumofdigit[1] = 2 + 12  = 14
//sumofdigit[2] = 3 + 23  + 123 = 149
//sumofdigit[3] = 4 + 34  + 234 + 1234  = 1506
//Result = 1670
//Now we can get the relation between sumofdigit values and can solve the question iteratively. 
//Each sumofdigit can be represented in terms of previous value as shown below,
//
//For above example,
//sumofdigit[3] = 4 + 34 + 234 + 1234
//           = 4 + 30 + 4 + 230 + 4 + 1230 + 4
//           = 4*4 + 10*(3 + 23 +123)
//           = 4*4 + 10*(sumofdigit[2])
//In general, 
//sumofdigit[i]  =  (i+1)*num[i] + 10*sumofdigit[i-1]
