package arrayMatrix2;


//Algo
//1)  countX == countO or countX == countO + 1
//2)  If O is in win condition then check 
//    a)     If X also wins, not valid
//    b)     If xbox != obox , not valid
//3)  If X is in win condition then check if xCount is
//    one more than oCount or not  
class ValidityXOBoard
{
  static boolean isWin(char b[],char x)
  {
     // This matrix is used to find indexes to check all  
//possible wining triplets in board[0..8]
      int win[][]={{0,1,2},
                  {3,4,5},
                  {6,7,8},
                  {0,3,6},
                  {1,4,7},
                  {2,5,8},
                  {0,4,8},
                  {2,4,6}};
      
      for(int i=0;i<win.length;i++)
          if(b[win[i][0]]==x&&b[win[i][1]]==x&&b[win[i][2]]==x)
              return true;
       return false;
  }
  static boolean isValidBoard(char b[])
  {
      int xcount=0,ocount=0;
      for(int i=0;i<b.length;i++)
          if(b[i]=='X')
              xcount++;
          else
              ocount++;
      if(xcount==ocount||xcount==ocount+1)
      {
          if(isWin(b,'O'))
          {
              if(isWin(b,'X'))
                  return false;
              return true;    
          }
          else if(isWin(b,'X')&&xcount!=ocount+1)
              return false;
          else
              return true;
      }
      else
          return false;
  }
  public static void main(String args[])
  {
      char board[] = {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X'};
      if(isValidBoard(board))
          System.out.println("Valid");
      else
          System.out.println("Invalid");
  }
}