package bitAlgorithms;

public class BitManipulations 
{
	static void bin(long n)
	{
		for(int i=1<<7;i>0;i=i/2)// 1<<30 means 31 bits representation.. 1<<7 means 8 bit representation
		{
			//i=i/2 is similar to i>>1(rightshift 1)
			if((n&i)>0)
				System.out.print("1");
			else
				System.out.print("0");
		}	
		System.out.println();
	}
	static void bitAnd(int a,int b)
	{
		bin(a);
		bin(b);
		System.out.print( a+" AND "+b+ " is: ");
		bin(a&b);
	}
	static void bitOr(int a,int b)
	{
		bin(a);
		bin(b);
		System.out.print( a+" OR "+b+ " is: ");
		bin(a|b);
	}
	static void bitLeftShift(int a,int pos)
	{	
		System.out.print("The left shift of "+a+" with "+pos+" position is: ");
		bin(3<<pos);
	}
	static void bitRightShift(int a,int pos)
	{
		System.out.print("The right shift of "+a+" with "+pos+" position is: ");
		bin(3>>1);
	}
	static void setBit(int n,int pos)
	{
		int mask=1<<pos;
		n=n|mask;
		bin(n);
	}
	static void clearBit(int n,int pos)
	{
		int mask=1<<pos;
		n=n&(~mask);
		bin(n);
	}
	static void flipBit(int n,int pos)
	{
		int mask=1<<pos;
		n=n^mask;
		bin(n);
	}
	static void isEven(int n)
	{
		if((n&1)==0)
			System.out.println("Even");
		else
			System.out.println("Odd");
	}
	static void isPowerof2(int n)
	{
		if((n&n-1)==0)
			System.out.println("Power of 2");
		else
			System.out.println("Not a power of 2");
	}
	static void countSetBits(int n)
	{
		int count=0;
		System.out.println("No of set bits in ");
		bin(n);
		while(n>0)
		{
			count+=n&1;
			n>>=1;
		}
		System.out.println(" is: "+count);
	}
	public static void main(String [] args)
	{
		bin(5);
		bitAnd(3,5);
		bitOr(3,5);
		bitLeftShift(3,1);
		bitRightShift(3,1);
		setBit(8,1);
		clearBit(7,1);
		flipBit(15,2);
		isEven(200);
		isPowerof2(256);
		countSetBits(200);
	}
}
//IMPORTANT ALL SHIFTING ARE 0 BASED INDEXING
//leftshift << takes the binary representation and shifts the bits position number of times left and adds 0s to the right.
//rightshift << takes the binary representation and shifts the bits position number of times right and adds 0s to the left.
//Setting a particular bit of position, we need to create a mask with that position (1 left shifted that many times)
//* we bitOR with the given number.
//Clearing a particular bit of position, we need to create a mask with that position (1 left shifted that many times)
//* we invert the mask. because we need to make sure other bits are safe.
//* we bitAND with the given number.
//Flipping a particular bit of position, we need to create a mask with that position (1 left shifted that many times)
//* we XOR with the given number.
//Setting a particular bit of position, we need to create a mask with that position (1 left shifted that many times)
//* we bitAND with the given number.
//Otherwise we can right shift number by position times, then bitand with 1. {Reverse of above logic!}
//Is number even? check for last bit if it is one, it is odd.
//for a number to be a power of 2 only one bit must be set.
//* if we subtract a power of 2 by 1, we set the current set bit to 0 and all other bits on the right to 1
//* so we can do bitand to check if it is 0 to make sure it is indeed a power of 2
