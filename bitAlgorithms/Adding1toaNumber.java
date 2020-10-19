package bitAlgorithms;

public class Adding1toaNumber 
{
	static int addOne(int n)
	{
		int mask=1;
		while((n&mask)>0)
		{
			n=n^mask;
			mask<<=1;
		}
		//flip the rightmost 0 bit
		n^=mask;
		return n;
	}
	public static void main(String args[])
	{
		int n=13;
		System.out.println("Adding 1 to "+n+" is: "+addOne(n));
	}
}
//algo:
//	To add 1 to a number x (say 0011000111), flip all the bits after the rightmost 0 bit (we get 0011000000).
//	Finally, flip the rightmost 0 bit also (we get 0011001000) to get the answer.	