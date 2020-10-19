package bitAlgorithms;
//Given an integer ‘x’, write a C function that returns true if binary representation 
//of x is palindrome else return false.

public class BinaryPalindrome 
{
	static void bin(long n)
	{
		for(long i=1<<30;i>0;i=i/2)
		{
			if((n&i)>0)
				System.out.print("1");
			else	
				System.out.print("0");
		}	
		System.out.println();
	}
	static int isBitSet(long x,int k)
	{
		return (x&(1<<k))>0?1:0;
	}
	static void isPalindrome(long x)
	{
		int l=0,r=31; //(r=Integer.SIZE/8)=4 and since we need for 8, r=4*8=32
		while(l<r)
		{
			if(isBitSet(x,l)!=isBitSet(x,r))
			{	
				System.out.println("Not a Palindrome");
				return;
			}	
			l++;
			r--;
		}
		System.out.println("Palindrome");
	}
	public static void main(String[] args)
	{
		long x= (1<<15) + (1<<16);
		bin(1<<15);
		bin(1<<16);
		bin(x);
		isPalindrome(35);
	}
}
//isPalindrome(x)
//1) Find number of bits in x using sizeof() operator.
//2) Initialize left and right positions as 1 and n respectively.
//3) Do following while left ‘l’ is smaller than right ‘r’.
//..…..a) If bit at position ‘l’ is not same as bit at position ‘r’, then return false.
//..…..b) Increment ‘l’ and decrement ‘r’, i.e., do l++ and r–-.
//4) If we reach here, it means we didn’t find a mismatching bit.
//
//The expression “x & (1 << (k-1))” gives us non-zero value if bit at k’th position 
//from right is set and gives a zero value if if k’th bit is not set.