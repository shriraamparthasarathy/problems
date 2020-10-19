package dynamicProgramming;


import java.util.*;

/**
 * 
 * Given a string and a dictionary, split this string into multiple words such that
 * each word belongs in dictionary.
 * 
 * e.g peanutbutter -> pea nut butter
 * e.g Iliketoplay -> I like to play
 * 
 * Solution 
 * DP solution to this problem
 * if( input[i...j] belongs in dictionary) T[i][j] = i
 * else{
 *     T[i][j] = k if T[i][k-1] != -1 && T[k][j] != -1
 *     
 * Test cases
 * 1) Empty string
 * 2) String where entire string is in dictionary
 * 3) String which cannot be split into words which are in dictionary
 * 3) String which can be split into words which are in dictionary    
 *
 */
public class BreakMultipleWordsWithNoSpaceIntoSpace 
{

    
//    /**
//     * Recursive and slow version of breaking word problem.
//     * If no words can be formed it returns null
//     */
//    public String breakWord(char[] str,int low,Set<String> dictionary){
//        StringBuffer buff = new StringBuffer();
//        for(int i= low; i < str.length; i++){
//            buff.append(str[i]);
//            if(dictionary.contains(buff.toString())){
//                String result = breakWord(str, i+1, dictionary);
//                if(result != null){
//                    return buff.toString() + " " + result;
//                }
//            }
//        }
//        if(dictionary.contains(buff.toString())){
//            return buff.toString();
//        }
//        return null;
//    }
    
    /**
     * Dynamic programming version for breaking word problem.
     * It returns null string if string cannot be broken into multipe words
     * such that each word is in dictionary.
     * Gives preference to longer words over splits
     * e.g peanutbutter with dict{pea nut butter peanut} it would result in
     * peanut butter instead of pea nut butter.
     */
    public boolean breakWordDP(String word, Set<String> dict)
    {
        boolean T[][] = new boolean[word.length()][word.length()];
        
        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++)
        {
            for(int i=0; i < word.length() -l + 1 ; i++)
            {
                int j = i + l-1;
                String str = word.substring(i,j+1);
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str))
                {
                    T[i][j] = true;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
                for(int k=i+1; k <= j; k++)
                {
                    if(T[i][k-1] == true && T[k][j] == true)
                    {
                        T[i][j] = true;
                        break;
                    }
                }
            }
        }
        
        //create space separate word from string is possible
//        StringBuffer buffer = new StringBuffer();
//        int i = 0; int j = word.length() -1;
//        while(i < j)
//        {
//            int k = T[i][j];
//            if(i == k)
//            {
//                buffer.append(word.substring(i, j+1));
//                break;
//            }
//            buffer.append(word.substring(i,k) + " ");
//            i = k;
//        }		to convert into spaced sentence
        for(int i=0;i<T.length;i++)
        {
        	for(int j=0;j<T[0].length;j++)
        	{
        		System.out.print(T[i][j]+" ");
        		if(T[i][j])
        			System.out.print(" ");
        	}
        	System.out.println();
        }
        
        return T[0][word.length()-1];
    }

  
    
    public static void main(String args[])
    {
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("am");
        dictionary.add("a");
        dictionary.add("ace");
        String str = "Iamace";
        System.out.println(dictionary.toString());
        BreakMultipleWordsWithNoSpaceIntoSpace bmw = new BreakMultipleWordsWithNoSpaceIntoSpace();
        if(bmw.breakWordDP(str, dictionary))
        	System.out.println("Yes");
        else
        	System.out.println("No");
    }
}
//https://www.youtube.com/watch?v=WepWFGxiwRs