package backTracking;


//print the numbers corresponding to the number of digits given 
//for example if n=2 then all two digits should be displayed which also includes one digits
public class PrintBinaryDecimal 
{
	static void _printBinaryHelper(int n, String prefix) 
	{
        if (n == 0) 
            System.out.println(prefix);
        else 
        {
            _printBinaryHelper(n - 1, prefix + "0");
            _printBinaryHelper(n - 1, prefix + "1");

        }
    }


    static void _printDecimalHelper(int n, String prefix) 
    {
        if (n == 0)
        	System.out.println(prefix);
        else
        {
            for (int i = 0; i <= 9; i++) 
                _printDecimalHelper(n - 1, prefix + Integer.toString(i));
        }
    }
    static void printDecimal(int n)
    {
    	_printDecimalHelper(n,"");
    }
    static void printBinary(int n)
    {
    	_printBinaryHelper(n,"");
    }
    public static void main(String args[])
    {
    	int n=3;
    	int n1=2;
    	printBinary(n);
    	System.out.println();
    	printDecimal(n1);
    }
}
