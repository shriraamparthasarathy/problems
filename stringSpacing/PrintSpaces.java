package stringSpacing;
//given a string you need to print all possible strings that can be made by placing spaces
//(zero or one) in between them.
//Input:  str[] = "ABC"
//Output: ABC
//        AB C
//        A BC
//        A B C
public class PrintSpaces
{
	static void printPattern(String a,String b,int start)
	{
		if(start==a.length()-1)
		{
			b+=a.charAt(start);
			System.out.println(b);
			return;
		}
		printPattern(a,b+a.charAt(start),start+1);
		printPattern(a,b+a.charAt(start)+' ',start+1);
	}
	public static void main (String[] args)  
    { 
        String str = "ABC"; 
        printPattern(str,"",0); 
    } 
}
//algo
//similar to bit algorithm
//since length of ABC is 3, the number of spaces will be 2
//so 2 bit is
//00
//01
//10
//11 where 0 means no space, 1 means we add a space