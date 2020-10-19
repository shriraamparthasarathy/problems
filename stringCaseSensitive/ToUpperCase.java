package stringCaseSensitive;
//Input : GeeksForGeeks
//Output : GEEKSFORGEEKS 
public class ToUpperCase 
{
	static String to_upper(char ch[])
	{
		for(int i=0;i<ch.length;i++)
			if(ch[i]>='a'&&ch[i]<='z')
				ch[i]&=~(1<<5);
		return String.valueOf(ch);
	}
	public static void main(String[] args) 
	{ 
	    String str = "geeksforgeeks"; 
	    System.out.println(to_upper(str.toCharArray())); 
	} 
}
//algo

//Making lower case to upper case : & ~32
//Making upper case to lower case : | 32


//The ASCII table is constructed in such way that the binary representation of 
//lowercase letters is almost identical of binary representation of uppercase letters. 
//The only difference is the sixth bit, setted only for lowercase letters. What that elegant
//function does is unset the bit of index 5 of in[i], consequently, making that character lowercase.
//
//Disadvantages: That strategy works only for alphabetical characters. 
//If the input contains numbers or punctuations, we’ll have to use the naive way.
//
//Example: Character ‘A’ is integer 65 = (0100 0001)2, while character ‘a’ is
//integer = 97 = (0110 0001)2. (Note that 97 – 65 = 32. Can you guess why?)
