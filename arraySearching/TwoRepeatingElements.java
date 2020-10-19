package arraySearching;

//You are given an array of n+2 elements. All elements of the array are in range 1 to n. And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
//For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5
//
//The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.

class TwoRepeatingElements
{
    static void findtwoRepeat2(int a[])//using array elements as index and modifying array
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[Math.abs(a[i])]>0)
                a[Math.abs(a[i])]*=-1;
            else
                System.out.print(Math.abs(a[i])+" ");
        }
    }
    static int fact(int n)
    {
        int f=1;
        for(int i=1;i<=n;i++)
            f*=i;
        return f;    
    }
    static void findtwoRepeat1(int a[])//using equation
    {
        int n=a.length;
        int S=0,P=1,D;
        int x,y;
        //find X+Y+n*(n-1)/2=S and X*Y*n!=P 
        for(int i=0;i<n;i++)
        {
            S+=a[i];
            P*=a[i];
        }
        n=n-2;//since there are 2 duplicates
        //find X+Y and XY
        S=S-n*(n+1)/2;
        P=P/fact(n);
        //find D = X-Y= sqrt((x+y)square-4XY)
        D=(int)Math.sqrt(S*S - 4*P);
        //solving X+Y=c and X-Y=k
        //we get (S+D)/2=X and (S-D)/2=Y
        x=(S+D)/2;
        y=(S-D)/2;
        System.out.println(x+" "+y);
        
    }
	public static void main (String[] args) 
	{
	    int a[] = {4, 2, 4, 5, 2, 3, 1};
	    System.out.print("The repeating elements are: ");
	    findtwoRepeat1(a);
	}
}

//algo 1 using equation
// Let the numbers which are being repeated are X and Y. We make two equations for X and Y and the simple task left is to solve the two equations.
// We know the sum of integers from 1 to n is n(n+1)/2 and product is n!. We calculate the sum of input array, when this sum is subtracted from n(n+1)/2, we get X + Y because X and Y are the two numbers missing from set [1..n]. Similarly calculate product of input array, when this product is divided from n!, we get X*Y. Given sum and product of X and Y, we can find easily out X and Y.

// Let summation of all numbers in array be S and product be P

// X + Y = S – n(n+1)/2
// XY = P/n!

// Using above two equations, we can find out X and Y. For array = 4 2 4 5 2 3 1, we get S = 21 and P as 960.

// X + Y = 21 – 15 = 6

// XY = 960/5! = 8

// X – Y = sqrt((X+Y)^2 – 4*XY) = sqrt(4) = 2

// Using below two equations, we easily get X = (6 + 2)/2 and Y = (6-2)/2
// X + Y = 6
//X – Y = 2


//algo 2: array elements as index and modifying array
// Traverse the array. Do following for every index i of A[].
// {
// check for sign of A[abs(A[i])] ;
// if positive then
//   make it negative by   A[abs(A[i])]=-A[abs(A[i])];
// else  // i.e., A[abs(A[i])] is negative
//   this   element (ith element of list) is a repetition
// }
