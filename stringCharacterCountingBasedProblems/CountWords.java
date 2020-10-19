package stringCharacterCountingBasedProblems;

public class CountWords
{
	static int countWords(String str)
	{
		int count=0;
		int OUT=0,IN=1;
		int state=OUT;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' '||str.charAt(i)=='\n'||str.charAt(i)=='\t')
				state=OUT;
			else if(state==OUT)
			{
				state=IN;
				count++;
			}
		}
		return count;
	}
	public static void main(String args[])
	{
		String str = "One two       three\n four\tfive  "; 
        System.out.println("No of words : " + countWords(str)); 
	}
}
