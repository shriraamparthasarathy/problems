package stringSubsequenceandSubstring;
//Given a string ‘str’ of digits, find the length of the longest substring of ‘str’, such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
//Examples :
//
//Input: str = "123123"
//Output: 6
//The complete string is of even length and sum of first and second
//half digits is same
//
//Input: str = "1538023"
//Output: 4
//The longest substring with same first and second half sum is "5380"
public class LengthofLongestEVENSubString 
{
	static int findLength(String s,int n)
	{
		int ans=0;
		for(int i=0;i<n-1;i++)
		{
			int l=i,r=i+1;
			int lsum=0,rsum=0;
			while(r<n&&l>=0)
			{
				lsum+=s.charAt(l)-'0';
				rsum+=s.charAt(r)-'0';
				if(lsum==rsum)
					ans=Math.max(ans, r-l+1);
				l--;
				r++;
			}
		}
		return ans;
	}
	static public void main(String[] args) { 
        String str = "123123"; 
        System.out.println("Length of the substring is "
                + findLength(str, str.length())); 
    } 
}
//algo
//The idea is to consider all possible mid points (of even length substrings)
//and keep expanding on both sides to get and update optimal length as the sum of two
//sides become equal.