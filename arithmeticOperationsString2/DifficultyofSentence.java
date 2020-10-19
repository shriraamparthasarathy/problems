package arithmeticOperationsString2;

//Calculate difficulty of a given sentence. Here a Word is considered hard if it has 4 consecutive consonants or number of consonants are more than number of vowels. Else word is easy. Difficulty of sentence is defined as 5*(number of hard words) + 3*(number of easy words).
//
//Examples:
//
//Input : str = "Difficulty of sentence"
//Output : 13
//Hard words = 2(Difficulty and sentence)
//Easy words = 1(of)
//So, answer is 5*2+3*1 = 13

public class DifficultyofSentence 
{
	static boolean isVowel(char c)
	{
		return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
	}
	static int calculateDifficulty(String s)
	{
		int vow=0,cons=0,conscount=0;
		int hard=0,easy=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' '&& isVowel(Character.toLowerCase(s.charAt(i))))
			{
				vow++;
				conscount=0;
			}
			else if(s.charAt(i)!=' ')
			{
				cons++;
				conscount++;
			}
			if(conscount==4)
			{
				hard++;
				while(s.charAt(i)!=' '&&i<s.length())
					i++;
				conscount=0;
				vow=0;
				cons=0;
			}
			else if(i<s.length()&&((s.charAt(i)==' ')||(i==s.length()-1)))
			{
				if(cons>vow)
					hard++;
				else
					easy++;
				cons=0;
				vow=0;
				conscount=0;
			}
		}
		return 5*hard+3*easy;
	}
	public static void main(String args[])
	{
		String s="Difficulty of sentence";
		System.out.println("The difficulty is: "+calculateDifficulty(s));
	}
}
//algo:
//Increment vowels count, if current character is vowel and set conecutive consonants count=0.
//Else increment consonants count, also increment consecutive consonants count.
//Check if consecutive consonants becomes 4, then current word is hard, so increment its count
//and move to the next word.Reset all counts to 0.
//Else check if a word is completed and count of consonants is greater than count of vowels,
//then it is a hard word else easy word.Reset all counts to 0.