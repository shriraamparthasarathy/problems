package stringPalindrome;
//Given a string, check if it is a rotation of a palindrome. For example your
//function should return true for “aab” as it is a rotation of “aba”.
//Examples:
//
//Input:  str = "aaaad"
//Output: 1  
//// "aaaad" is a rotation of a palindrome "aadaa"
//
//Input:  str = "abcd"
//Output: 0
// "abcd" is not a rotation of any palindrome.
public class RoationPalindrome 
{
	static String reform(String s)
	{
		String str1="$#";
		for(int i=0;i<s.length();i++)
		{
			str1+=s.charAt(i);
			str1+='#';
		}	
		str1+='@';
		return str1;
	}
	static boolean isPal(int x,int n)
	{
		if(x==n)
			return true;
		else if(x>n)
		{
			if((x%2==0&&n%2==0)||(x%2!=0&&n%2!=0))
				return true;
		}
		return false;
	}
	static boolean longestPal(String s,int n)
	{
		//center position,current right position, current left position
		int c=0,r=0,mirror=0;
		 // LPS Length Array  
		int p[]=new int[s.length()];
		// Get currentLeftPosition Mirror  
	    // for currentRightPosition i  
		for(int i=1;i<s.length()-1;i++)
		{
			mirror=2*c-i;
			// If currentRightPosition i is  
	        // within centerRightPosition R  
			if(i<r)
				p[i]=Math.min(r-i, p[mirror]);
			while(s.charAt(i+(1+p[i]))==s.charAt(i-(1+p[i])))
				p[i]++;
			// Attempt to expand palindrome centered  
	        // at currentRightPosition i  
			if(isPal(p[i],n))
				return true;

	        // If palindrome centered at currentRightPosition i  
	        // expand beyond centerRightPosition R,  
	        // adjust centerPosition C based on expanded palindrome  
			if(i+p[i]>r)
			{
				c=i;
				r=i+p[i];
			}
		}
		return false;
	}
	public static void main(String[] args)  
	{ 
	    String s = "aaaad"; 
	    int len = s.length(); 
	    s += s; 
	    s = reform(s); 
	    System.out.println(s);
	    System.out.println(longestPal(s, len) ? 1 : 0); 
	} 
}
//algo
//An Optimized Solution can work in O(n) time. The idea here is to use Manacher’s algorithm to 
//solve the above problem.
//
//Let the given string be ‘s’ and length of string be ‘n’.
//Preprocess/Prepare the string to use Manachers Algorithm, to help find even length palindrome, 
//for which we concatenate the given string with itself (to find if rotation will give a palindrome)
//and add ‘$’ symbol at the beginning and ‘#’ characters between letters. We end the string using ‘@’
//. So for ‘aaad’ input the reformed string will be – ‘$#a#a#a#a#d#a#a#a#a#d#@’
//Now the problem reduces to finding Longest Palindromic Substring using Manacher’s algorithm of 
//length n or greater in the string.
//If there is palindromic substring of length n, then return true, else return false. If we find
//		a palindrome of greater length then we check if the size of our input is even or odd, 
//		correspondingly our palindrome length found should also be even or odd.
//For eg. if our input size is 3 and while performing Manacher’s Algorithm we get a palindrome size
//of 5 it obviously would contain a substring of size of 3 which is a palindrome but the same cannot
//be said for a palindrome of length of 4. Hence we check if both the size of the input and the size
//of palindrome found at any instance is both even or both odd.
//
//Boundary case would be a word with same letters that would defy the above property but for that
//case our algorithm will find both even length and odd length palindrome one of them being a 
//substring, hence it wont be a problem.