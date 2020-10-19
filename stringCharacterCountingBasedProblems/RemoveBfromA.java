package stringCharacterCountingBasedProblems;
//Remove characters from the first string which are present in the second string
public class RemoveBfromA 
{
	static String removeDirtyChars(String str,String mask)
	{
		boolean count[]=new boolean[256];
		for(int i=0;i<mask.length();i++)
			count[mask.charAt(i)]=true;
		String res="";
		for(int i=0;i<str.length();i++)
		{
			if(count[str.charAt(i)]==false)
				res+=str.charAt(i);
		}
		return res;
	}
	public static void main(String[] args) 
    { 
        String str = "geeksforgeeks"; 
        String mask_str = "mask"; 
        System.out.println(removeDirtyChars(str, mask_str)); 
    } 
}
