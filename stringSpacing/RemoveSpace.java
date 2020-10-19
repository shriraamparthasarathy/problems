package stringSpacing;

public class RemoveSpace 
{
	static int removeSpaces(char [] str)
	{
		int count=0;
		for(int i=0;i<str.length;i++)
			if(str[i]!=' ')
				str[count++]=str[i];
		return count;
	}
	public static void main(String[] args) 
	{ 
	    char str[] = "g eeks for ge eeks ".toCharArray(); 
	    int i = removeSpaces(str); 
	    System.out.println(String.valueOf(str));
	    System.out.println(String.valueOf(str).substring(0,i)); 
	} 
}
