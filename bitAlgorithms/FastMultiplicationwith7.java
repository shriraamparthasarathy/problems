package bitAlgorithms;
//this algo can be used for multiplication with any number, check the algo below

public class FastMultiplicationwith7 
{
	static long multiplywith7(long n)
	{
		return ((n<<2)+(n<<1)+n); //it can be (n<<3)-n as well
	}
	public static void main(String args[])
	{
		long n=4;
		System.out.println("Multiplication with 7 is: "+multiplywith7(n));
	}
}
//n * 7 = n * (8-1) = n*(4 + 4 -1 ) = n * (4 + 2 +1) So it becomes
//(n<<2) + (n<<1) + n :-)
//shifting once is nothing but multiplying with 2